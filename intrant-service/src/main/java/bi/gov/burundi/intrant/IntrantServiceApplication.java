package bi.gov.burundi.intrant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IntrantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntrantServiceApplication.class, args);
    }
}
