package net.mikoto.rikka;

import net.mikoto.rikka.model.ArtworkImage;
import net.mikoto.rikka.service.ArtworkImageService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RikkaApplicationTests {

    @Autowired
    ArtworkImageService artworkImageService;
    Logger log = Logger.getLogger(RikkaApplicationTests.class);

    @Test
    void insert() {
        ArtworkImage[] artworkImages = artworkImageService.createIllustrationImages(123, new String[]{"URL1", "URL2", "URL3"});
        log.info(artworkImages);
    }

    @Test
    void delete() {
        artworkImageService.removeIllustrationImages(1081919501672554497L);
    }

}
