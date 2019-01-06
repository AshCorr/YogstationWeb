package net.yogstation.ping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class YogstationPingApplication {
    public static void main(String[] args) {
        SpringApplication.run(YogstationPingApplication.class, args);
    }
}
