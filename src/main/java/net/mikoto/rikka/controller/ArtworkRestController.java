package net.mikoto.rikka.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import net.mikoto.rikka.model.Artwork;
import net.mikoto.rikka.model.ArtworkImage;
import net.mikoto.rikka.service.ArtworkImageService;
import net.mikoto.rikka.service.ArtworkService;
import net.mikoto.rikka.service.CollectionService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;


/**
 * @author mikoto
 * &#064;date 2023/2/11
 * Create for rikka
 */
@RestController
public class ArtworkRestController {
    private final ArtworkService artworkService;
    private final ArtworkImageService artworkImageService;

    @Autowired
    public ArtworkRestController(ArtworkService artworkService, ArtworkImageService artworkImageService) {
        this.artworkService = artworkService;
        this.artworkImageService = artworkImageService;
    }

    @RequestMapping(
            value = "/artwork/createSingle",
            method = RequestMethod.POST
    )
    public JSONObject createSingleArtwork(@RequestParam Map<String,Object> params) {
        Artwork artwork = JSON.to(Artwork.class, params);
        return JSONObject.from(artworkService.createArtwork(artwork, true));
    }

    @RequestMapping(
            value = "/artwork/create",
            method = RequestMethod.POST
    )
    public JSONObject createArtwork(@RequestParam @NotNull Map<String,Object> params) {
        Object image = params.get("imageGlobalId");
        if (image instanceof String[]) {
            params.remove("imageGlobalId");
            Artwork artwork = JSON.to(Artwork.class, params);
            artwork = artworkService.createArtwork(artwork, false);

            ArtworkImage[] artworkImages =
                    artworkImageService.createIllustrationImages(
                            artwork.getArtworkGlobalId(),
                            (String[]) image
                    );
            artwork.setImageGlobalId(artworkImages[0].getImageGlobalId());

            artworkService.save(artwork);

            return JSONObject.from(artwork);
        }
        throw new RuntimeException("Unknown image param type");
    }

    @RequestMapping(
            value = "/artwork/{artworkId}"
    )
    public JSONObject getArtwork(@PathVariable long artworkId) {
        return JSONObject.from(artworkService.getById(artworkId));
    }

    @RequestMapping(
            value = "/artwork/image/{artworkImageId}"
    )
    public JSONObject getArtworkImage(@PathVariable long artworkImageId) {
        return JSONObject.from(artworkImageService.getById(artworkImageId));
    }

    @RequestMapping(
            value = "/artwork/images/{artworkImageId}"
    )
    public JSONObject getArtworkImages(@PathVariable long artworkImageId) {
        ArrayList<ArtworkImage> artworkImages = new ArrayList<>();

        ArtworkImage artworkImage = artworkImageService.getById(artworkImageId);
        artworkImages.add(artworkImage);

        long nextImageId = artworkImage.getNextImageGlobalId();
        while (nextImageId == 0) {
            artworkImage = artworkImageService.getById(nextImageId);
            nextImageId = artworkImage.getNextImageGlobalId();
            artworkImages.add(artworkImage);
        }
        return JSONObject.from(artworkImages);
    }
}
