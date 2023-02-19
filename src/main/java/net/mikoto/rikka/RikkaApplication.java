package net.mikoto.rikka;

import net.mikoto.yukino.YukinoApplication;
import net.mikoto.yukino.manager.YukinoJsonManager;
import net.mikoto.yukino.manager.YukinoModelManager;
import net.mikoto.yukino.model.YukinoModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class RikkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RikkaApplication.class, args);
    }

    @Bean
    public YukinoJsonManager yukinoJsonManager() {
        return new YukinoJsonManager();
    }

    @Bean
    public YukinoModelManager yukinoModelManager() {
        return new YukinoModelManager();
    }

    @Bean
    public YukinoApplication yukinoApplication(YukinoModelManager yukinoModelManager,
                                               YukinoJsonManager yukinoJsonManager) {
        return new YukinoApplication(yukinoModelManager, yukinoJsonManager);
    }
}
