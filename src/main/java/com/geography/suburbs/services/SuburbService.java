package com.geography.suburbs.services;

import com.geography.suburbs.dao.SuburbRepository;
import com.geography.suburbs.exceptions.SuburbException;
import com.geography.suburbs.models.Suburb;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class SuburbService {

    @Autowired
    private SuburbRepository suburbRepository;

    /**
     * Save suburb details into DB
     * @param suburb
     * @return
     */
    public Suburb addSuburb(Suburb suburb) {
        if(suburbRepository.findByPincode(suburb.getPincode()) == null &&
        suburbRepository.findByName(suburb.getName()) == null) {

            Suburb savedSuburb = suburbRepository.save(suburb);
            log.debug("Suburb saved");
            return savedSuburb;
        } else {
            log.warn("Suburb already exists");
            throw new SuburbException("Suburb already exists");
        }
    }

    /**
     * Find suburb by given pincode
     * @param pincode
     * @return
     */
    public Suburb getSuburbByPincode(String pincode) {
        Suburb suburb = suburbRepository.findByPincode(pincode);
        if(suburb != null && suburb.getId() != 0) {
            return suburb;
        } else {
            log.debug("No suburb found for the given pincode");
            throw new SuburbException("No Suburb found with the given pincode");
        }
    }

    /**
     * Find suburb by given name
     * @param name
     * @return
     */
    public Suburb getSuburbByName(String name) {
        Suburb suburb = suburbRepository.findByName(name);
        if(suburb != null && suburb.getId() != 0) {
            return suburb;
        } else {
            log.debug("No suburb found by the given name");
            throw new SuburbException("No Suburb found by the given name");
        }
    }
}
