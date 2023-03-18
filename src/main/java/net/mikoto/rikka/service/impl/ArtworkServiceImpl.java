package net.mikoto.rikka.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.mikoto.rikka.mapper.ArtworkMapper;
import net.mikoto.rikka.model.Artwork;
import net.mikoto.rikka.service.ArtworkImageService;
import net.mikoto.rikka.service.ArtworkService;
import net.mikoto.rikka.util.SnowflakeIdGenerateUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author mikoto
 * &#064;date 2023/3/12
 * Create for rikka
 */
@Service
public class ArtworkServiceImpl
        extends ServiceImpl<ArtworkMapper, Artwork>
        implements ArtworkService {
    private static final SnowflakeIdGenerateUtil snowflakeIdGenerateUtil = new SnowflakeIdGenerateUtil(10, 1);

    private final ArtworkImageService artworkImageService;

    @Autowired
    public ArtworkServiceImpl(ArtworkImageService artworkImageService) {
        this.artworkImageService = artworkImageService;
    }


    /**
     * Create an artwork and save it to database
     *
     * @param artwork The input artwork object
     * @return The result
     */
    public Artwork createArtwork(Artwork artwork) {
        artwork.setArtworkGlobalId(snowflakeIdGenerateUtil.getId());
        artwork.setCreateTime(new Date());
        artwork.setUpdateTime(new Date());
        this.save(artwork);
        return artwork;
    }

    /**
     * Update an artwork
     *
     * @param artwork The input artwork object
     * @return The result
     */
    public boolean updateArtwork(@NotNull Artwork artwork) {
        artwork.setUpdateTime(new Date());
        return this.updateById(artwork);
    }

    /**
     * Only remove artwork
     *
     * @param artworkId The artwork which is need to remove
     * @return The result
     */
    public boolean removeSingleArtwork(long artworkId) {
        return this.removeById(artworkId);
    }

    /**
     * Remove artwork and artwork image
     *
     * @param artworkId The artwork which is need to remove
     * @return The result
     */
    public boolean removeArtwork(long artworkId) {
        Artwork artwork = this.getById(artworkId);
        artworkImageService.removeIllustrationImages(artwork.getImageGlobalId());
        return this.removeById(artworkId);
    }
}
