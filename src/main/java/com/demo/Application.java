package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by rawad.elrifai on 5/3/16.
 */


//@PropertySource(value = "classpath:demo.properties",ignoreResourceNotFound=true)
@SpringBootApplication
public class Application {


    public static void main(String[] args) throws Exception {
        System.out.println("Starting up demo app...");
        SpringApplication.run(Application.class, args);

    }




}

