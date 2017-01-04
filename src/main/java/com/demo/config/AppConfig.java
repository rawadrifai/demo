package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

/**
 * Created by rawad.elrifai on 1/3/17.
 */
@Configuration
public class AppConfig {

    @Bean
    public AuditorAware auditorProvider() {
        System.out.println("spring boot user");

        return new AuditorAware() {

            @Override
            public String getCurrentAuditor() {
                return "spring boot user";
            }
        };
    }

}
