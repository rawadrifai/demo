package com.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Hibernate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.List;


/**
 * Created by rawad.elrifai on 5/3/16.
 */


//@PropertySource(value = "classpath:demo.properties",ignoreResourceNotFound=true)
@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {


    public static void main(String[] args) throws Exception {
        System.out.println("Starting up demo app...");
        SpringApplication.run(Application.class, args);

    }



}

