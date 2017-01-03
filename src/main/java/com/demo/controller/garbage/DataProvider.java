package com.demo.controller.garbage;

import com.demo.domain.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by rawad.elrifai on 5/3/16.
 */
@RestController
@RequestMapping("/data")
public class DataProvider {

    private static final Logger LOG = LoggerFactory.getLogger(DataProvider.class);


    // CollectData GET endpoints

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Item> test() throws Exception {

        try {
            Item item1 = new Item();
            item1.setId(1);
            item1.setName("Chrome");

            Item item2 = new Item();
            item2.setId(2);
            item2.setName("Firefox");

            Item item3 = new Item();
            item3.setId(3);
            item3.setName("Safari");

            List<Item> items = new ArrayList<>();
            items.add(item1);
            items.add(item2);
            items.add(item3);

            return items;

        }
        catch (Exception ex) {
            LOG.error("exception happened: ", ex);
            return new ArrayList<>();
        }
    }
}
