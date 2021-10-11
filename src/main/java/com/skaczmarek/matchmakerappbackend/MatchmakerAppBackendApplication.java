package com.skaczmarek.matchmakerappbackend;

import com.skaczmarek.matchmakerappbackend.domain.game.Game;
import com.skaczmarek.matchmakerappbackend.repository.GameRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

//@SpringBootApplication(scanBasePackages="com.skaczmarek.matchmakerappbackend")

@SpringBootApplication
@Configuration
//@EnableJpaRepositories(basePackages = "com.skaczmarek.matchmakerappbackend")
public class MatchmakerAppBackendApplication implements RepositoryRestConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(MatchmakerAppBackendApplication.class, args);
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Game.class);
    }
}


