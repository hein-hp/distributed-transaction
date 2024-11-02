package distributed.transaction;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * StorageApplication
 *
 * @author hein
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
public class StorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class);
    }
}
