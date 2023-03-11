package net.mikoto.rikka.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.mikoto.rikka.mapper.ArtworkImageMapper;
import net.mikoto.rikka.model.ArtworkImage;
import net.mikoto.rikka.service.ArtworkImageService;
import net.mikoto.rikka.util.SnowflakeIdGenerateUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mikoto
 * &#064;date 2023/3/5
 * Create for rikka
 */
@Service
public class ArtworkImageServiceImpl
        extends ServiceImpl<ArtworkImageMapper, ArtworkImage>
        implements ArtworkImageService {
    private static final SnowflakeIdGenerateUtil snowflakeIdGenerateUtil = new SnowflakeIdGenerateUtil(10, 1);

    private static void arrayReverse(Object[] array) {
        for (int start = 0, end = array.length - 1; start < end; start++, end--) {
            Object temp = array[end];
            array[end] = array[start];
            array[start] = temp;
        }
    }

    /**
     * Put the single image after a chain
     *
     * @param artworkId       The artwork id
     * @param previousImageId The previous image id which the image will be put after
     * @param url             The url of the image
     * @return The image
     */
    @Override
    public ArtworkImage createIllustrationImage(long artworkId, long previousImageId, String url) {
        ArtworkImage artworkImage = new ArtworkImage();
        artworkImage.setImageGlobalId(snowflakeIdGenerateUtil.getId());
        artworkImage.setArtworkGlobalId(artworkId);
        artworkImage.setUrl(url);
        this.save(artworkImage);

        ArtworkImage previousArtworkImage = new ArtworkImage();
        previousArtworkImage.setImageGlobalId(previousImageId);
        previousArtworkImage.setNextImageGlobalId(artworkImage.getImageGlobalId());
        this.updateById(previousArtworkImage);
        return artworkImage;
    }

    /**
     * Put the single image after a chain
     *
     * @param artworkId The artwork id
     * @param url       The url of the image
     * @return The image
     */
    @Override
    public ArtworkImage createSingleIllustrationImage(long artworkId, String url) {
        ArtworkImage artworkImage = new ArtworkImage();
        artworkImage.setImageGlobalId(snowflakeIdGenerateUtil.getId());
        artworkImage.setArtworkGlobalId(artworkId);
        artworkImage.setUrl(url);
        this.save(artworkImage);
        return artworkImage;
    }

    /**
     * Put the full image chain into the database
     *
     * @param artworkId The artwork id
     * @param urls      The url chain
     * @return The image chain
     */
    @Override
    public ArtworkImage[] createIllustrationImages(long artworkId, String[] urls) {
        arrayReverse(urls);
        long nextImageId = 0;
        List<ArtworkImage> artworkImages = new ArrayList<>();
        for (String url : urls) {
            ArtworkImage artworkImage = new ArtworkImage();
            artworkImage.setImageGlobalId(snowflakeIdGenerateUtil.getId());
            artworkImage.setArtworkGlobalId(artworkId);
            artworkImage.setUrl(url);

            if (nextImageId != 0) {
                artworkImage.setNextImageGlobalId(nextImageId);
            }

            nextImageId = artworkImage.getImageGlobalId();
            artworkImages.add(artworkImage);
        }

        this.saveBatch(artworkImages);
        return artworkImages.toArray(new ArtworkImage[0]);
    }

    /**
     * Remove the full chain of the images
     *
     * @param imageId The start of the image chain
     */
    @Override
    public void removeIllustrationImages(long imageId) {
        ArtworkImage artworkImage = this.getById(imageId);
        this.removeById(imageId);
        while (artworkImage.getNextImageGlobalId() != 0) {
            artworkImage = this.getById(artworkImage.getNextImageGlobalId());
            this.removeById(artworkImage.getImageGlobalId());
        }
    }

    /**
     * <b>
     * Warn: please use the method carefully. It may cause some data can't be searched normally.
     * </br>
     * Except search by artworkGlobalId and url (But the cost is loss of database performance and time).
     * </b>
     *
     * @param imageId The image id
     */
    @Override
    public void removeIllustrationImage(long imageId) {
        this.removeById(imageId);
    }
}
