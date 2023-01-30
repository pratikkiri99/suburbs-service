package com.geography.suburbs.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="SUBURB")
public class Suburb {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "PINCODE", unique = true)
    private String pincode;

    @Column(name = "POPULATION")
    private Integer population;
}
