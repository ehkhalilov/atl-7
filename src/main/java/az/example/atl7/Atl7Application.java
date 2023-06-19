package az.example.atl7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Atl7Application {

    public static void main(String[] args) {
        SpringApplication.run(Atl7Application.class, args);
    }

}
