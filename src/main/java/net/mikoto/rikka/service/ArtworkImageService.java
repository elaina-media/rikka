package net.mikoto.rikka.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.mikoto.rikka.model.ArtworkImage;

/**
 * @author mikoto
 * &#064;date 2023/3/5
 * Create for rikka
 */
public interface ArtworkImageService extends IService<ArtworkImage> {
    /**
     * Put the single image after a chain
     *
     * @param artworkId The artwork id
     * @param previousImageId The previous image id which the image will be put after
     * @param url The url of the image
     * @return The image
     */
    ArtworkImage createIllustrationImage(long artworkId, long previousImageId, String url);

    /**
     * Put the single image after a chain
     *
     * @param artworkId The artwork id
     * @param url The url of the image
     * @return The image
     */
    ArtworkImage createSingleIllustrationImage(long artworkId, String url);

    /**
     * Put the full image chain into the database
     *
     * @param artworkId The artwork id
     * @param urls      The url chain
     * @return The image chain
     */
    ArtworkImage[] createIllustrationImages(long artworkId, String[] urls);

    /**
     * Remove the full chain of the images
     *
     * @param imageId The start of the image chain
     */
    void removeIllustrationImages(long imageId);

    /**
     * <b>
     *     Warn: please use the method carefully. It may cause some data can't be searched normally.
     *     </br>
     *     Except search by artworkGlobalId and url (But the cost is loss of database performance and time).
     * </b>
     * @param imageId The image id
     */
    void removeIllustrationImage(long imageId);
}
