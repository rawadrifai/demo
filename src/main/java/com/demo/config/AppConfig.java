package com.demo.config;

import com.demo.domain.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.AuditorAware;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;

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

    @Bean
    public Item getItem() {
        Item item = new Item();
        item.setId(1);
        item.setName("hello world");
        return item;
    }

    @Autowired
    ApplicationContext applicationContext;

    // just a sample post construct to demonstrate how to get a bean from the application context
    @PostConstruct
    private void someStuff() {

        Item item = applicationContext.getBean(Item.class);
        System.out.println(item.getId() + item.getName());
    }



}
