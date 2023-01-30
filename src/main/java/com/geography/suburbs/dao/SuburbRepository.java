package com.geography.suburbs.dao;

import com.geography.suburbs.models.Suburb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SuburbRepository extends JpaRepository<Suburb, Integer> {
    public Suburb findByPincode(String pincode);
    public Suburb findByName(String name);
}
