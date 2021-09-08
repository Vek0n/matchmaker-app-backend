package com.skaczmarek.matchmakerappbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan(basePackages = {"com.skaczmarek.matchmakerappbackend"})
@SpringBootApplication(scanBasePackages="com.skaczmarek.matchmakerappbackend")

public class MatchmakerAppBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatchmakerAppBackendApplication.class, args);
    }

}
