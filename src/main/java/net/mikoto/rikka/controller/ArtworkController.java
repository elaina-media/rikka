package net.mikoto.rikka.controller;

import net.mikoto.rikka.model.Artwork;
import net.mikoto.rikka.service.ArtworkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArtworkController {
    private final ArtworkService artworkService;

    public ArtworkController(ArtworkService artworkService) {
        this.artworkService = artworkService;
    }

    private String createImageElement(String address) {
        return "<img style=\"margin: 10px\" src=\"" +
                address +
                "\" alt=\"ArtworkImage\">";
    }

    @RequestMapping("/artwork/{id}")
    public String getArtwork(Model model, @PathVariable(name = "id") long artworkGlobalId) {
        Artwork artwork = artworkService.getById(artworkGlobalId);

        model.addAttribute("title", artwork.getTitle() + " - Rikka");
        model.addAttribute("artwork", artwork);


        return "artwork";
    }
}
