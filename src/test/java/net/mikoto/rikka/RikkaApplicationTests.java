package net.mikoto.rikka;

import net.mikoto.rikka.model.IllustrationImage;
import net.mikoto.rikka.service.IllustrationImageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RikkaApplicationTests {

    @Autowired
    IllustrationImageService illustrationImageService;

    @Test
    void insert() {
        IllustrationImage illustrationImage = new IllustrationImage();
        illustrationImage.setArtworkGlobalId(123);
        illustrationImage.setUrl("https://img-qn.51miz.com/preview/photo/00/01/51/26/P-1512602-6C1160D0O.jpg!/quality/90/unsharp/true/compress/true/format/jpg/fw/720");
        illustrationImageService.save(illustrationImage);
    }

    @Test
    void delete() {
        illustrationImageService.removeById(1632227271552651266L);
    }

}
