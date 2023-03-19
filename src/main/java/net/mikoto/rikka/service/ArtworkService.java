package net.mikoto.rikka.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.mikoto.rikka.model.Artwork;

/**
 * @author mikoto
 * &#064;date 2023/3/12
 * Create for rikka
 */
public interface ArtworkService extends IService<Artwork> {
    /**
     * Create an artwork and save it to database
     *
     * @param artwork The input artwork object
     * @param isSave
     * @return The result
     */
    Artwork createArtwork(Artwork artwork, boolean isSave);

    /**
     * Update an artwork
     *
     * @param artwork The input artwork object
     * @return The result
     */
    boolean updateArtwork(Artwork artwork);

    /**
     * @param artworkId The artwork which is need to remove
     * @return The result
     */
    boolean removeSingleArtwork(long artworkId);
    boolean removeArtwork(long artworkId);
}
