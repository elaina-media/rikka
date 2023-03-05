package net.mikoto.rikka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@MapperScan("net.mikoto.rikka.mapper")
public class RikkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RikkaApplication.class, args);
    }
}
