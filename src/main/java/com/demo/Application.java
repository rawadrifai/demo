package com.demo;

import org.springframework.boot.SpringApplication;
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
@SpringBootApplication
@ComponentScan("com.demo")
@PropertySource(value = "classpath:demo.properties",ignoreResourceNotFound=true)
public class Application {


    public static void main(String[] args) throws Exception {
        System.out.println("hello world");
        SpringApplication.run(Application.class, args);

       // new ExceptionTest().testExceptionLoggin();

/*

        System.out.println("starting main");

        Observable<String> myobs = new Obs().testObs();

        myobs.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("completed");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        }
    );


        System.out.println("after observable");
*/


//        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
//        Date dateobj = new Date();
//        System.out.println(df.format(dateobj));
//
//        long currentDateTime = System.currentTimeMillis();
//
//        //creating Date from millisecond
//        String currentDate = df.format(new Date(currentDateTime));
//
//        //printing value of Date
//        System.out.println("current Date: " + currentDate);
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date());
//        cal.add(Calendar.HOUR, -1);
//        Date oneHourBack = cal.getTime();
//        System.out.println(oneHourBack);

   //
 //       new TestValidate().test(null);

//        new AsyncTester();

   // new AnnotationTest();

//new InterfaceTest();

       // LamdaTest lamdaTest = new LamdaTest();



       // new ThreadTest();

      //  new ObservableTest();

    /*    BaseClass baseClass = new ChildClass();
        baseClass.show();

        ChildClass c = new ChildClass();
        c.show();
        c.play();
*/

        //new JsonTest();

    //    new RestTemplateExample();

//        new DataStructure();

     //   new Prep();
    }




}

