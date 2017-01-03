package com.demo;

import com.demo.controller.AspectSim;
import com.demo.util.MyAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * Created by rawad.elrifai on 12/29/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AspectSim.class, MyAspect.class})
//@ComponentScan(basePackages = {"com.demo"})
public class AspectTest {

    @Autowired
    AspectSim aspectSim;

    @Test
    public void testAspects() {
        aspectSim.helloWorld();
    }
}