package com.geography.suburbs.controllers;

import com.geography.suburbs.exceptions.SuburbException;
import com.geography.suburbs.models.Suburb;
import com.geography.suburbs.services.SuburbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/suburbs")
public class SuburbController {

    @Autowired
    private SuburbService suburbService;

    /**
     * Add suburb
     * @param suburb
     * @return
     */
    @PostMapping(consumes = "application/json")
    public Suburb addSuburb(@RequestBody Suburb suburb) {
        try {
            Suburb savedSuburb = suburbService.addSuburb(suburb);
            return savedSuburb;
        } catch (SuburbException e) {
            log.error("Exception saving the suburb information ", e);
            throw e;
        }
    }

    /**
     * Get Suburb by pincode
     * @param pincode
     * @return
     */
    @GetMapping(params = {"pincode"})
    public Suburb getSuburbByPincode(@RequestParam("pincode") String pincode) {
        try{
            return suburbService.getSuburbByPincode(pincode);
        } catch (SuburbException e) {
            throw e;
        }
    }

    /**
     * Get suburb by name
     * @param name
     * @return
     */
    @GetMapping(params = {"name"})
    public Suburb getSuburbByName(@RequestParam("name") String name) {
        try{
            return suburbService.getSuburbByName(name);
        }catch (SuburbException e) {
            throw e;
        }
    }
}
