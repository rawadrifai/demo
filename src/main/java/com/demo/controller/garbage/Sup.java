package com.demo.controller.garbage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


/**
 * Created by rawad.elrifai on 5/3/16.
 */
@RestController
@RequestMapping("/demo")
public class Sup {

    private static final Logger LOG = LoggerFactory.getLogger(Sup.class);


    // CollectData GET endpoints

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> test() throws Exception {

        try {
            return new ResponseEntity<String>("hello world...", HttpStatus.OK);
        }
        catch (Exception ex) {
            LOG.error("exception happened: ", ex);
            return new ResponseEntity<String>(HttpStatus.ALREADY_REPORTED);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<String> displayName(@PathVariable String name) throws Exception {

        try {
            return new ResponseEntity<String>("Hello " + name, HttpStatus.OK);
        }
        catch (Exception ex) {
            LOG.error("exception happened: ", ex);
            return new ResponseEntity<String>(HttpStatus.ALREADY_REPORTED);
        }

    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public ResponseEntity<String> test1() throws Exception {

        LOG.info("received hello1");
        return new ResponseEntity<>(HttpStatus.OK);

    }



    public void newMethod(Integer x) throws Exception {
        throw new Exception("any any message");
    }




}
