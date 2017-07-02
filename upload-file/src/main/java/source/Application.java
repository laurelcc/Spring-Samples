package source;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import source.storage.StorageProperties;
import source.storage.StorageService;

/**
 * Created by soong on 2017/7/2.
 */
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }

}
