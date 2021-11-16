package com.pcg.gitdemo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name = "asset")
@Getter
@Setter
public class Asset {

    @Id
    @Column(name="asset_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String description;
    @CsvBindByName
    private String installDate;
    @CsvBindByName
    private double price;
    @CsvBindByName
    private String purchaseDate;
    @CsvBindByName
    private int quantity;
    @CsvBindByName
    private String serialNumber;
    @CsvBindByName
    private String sku;
    @CsvBindByName
    private String assetType; // Picklist: Digital, Physical, External 
    @CsvBindByName
    private String status; //Picklist: Purchased, Shipped, Isntalled, Registered, Obsolete
}