package com.jdy3.efarmersmarket;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

/** Annotation on the abstract base class to allow mapping for the concrete child class tables */
@MappedSuperclass

public abstract class Product {
    /** Abstract class for all farm product tables*/

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;
    
    protected LocalDate date;
    protected String name;
    protected String variety;
    protected String picture;
    protected String description;
    protected BigDecimal weight;
    protected String provenance;
    protected String location;
    protected BigDecimal price;

    @OneToMany(mappedBy = "product")
    protected List<Transaction> transaction;

    public Product(LocalDate entryDate, String productName, String productVariety, String productPicture, String productDescription, BigDecimal kg, String productProvenance, String collectionPoint, BigDecimal productPrice){
        this.date = entryDate;
        this.name = productName;
        this.variety = productVariety;
        this.picture = productPicture;
        this.description = productDescription;
        this.weight = kg;
        this.provenance = productProvenance;
        this.location = collectionPoint;
        this.price = productPrice;
    }

    /** Default table values for a no argument constructor call*/
    public Product(){
        this(null, "", "", "", "", BigDecimal.ZERO, "", "", BigDecimal.ZERO);
    }

    public void setDate(LocalDate inputDate){
        this.date = inputDate;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setName(String inputName){
        this.name = inputName;
    }

    public String getName(){
        return name;
    }

   public void setVariety(String inputVariety){
        this.variety = inputVariety;
   }

   public String getVariety(){
    return variety;
   }

   public void setPicture(String inputPicture){
    this.picture = inputPicture;
   }

   public String getPicture(){
    return picture;
   }

   public void setDescription(String inputDescription){
    this.description = inputDescription;
   }

   public String getDescription(){
    return description;
   }

   public void setWeight(BigDecimal inputWeight){
    this.weight = inputWeight;
   }

   public BigDecimal getWeight(){
    return weight;
   }

   public void setProvenance(String inputProvenance){
    this.provenance = inputProvenance;
   }

   public String getProvenance(){
    return provenance;
   }

   public void setLocation(String inputLocation){
    this.location = inputLocation;
   }

   public String getLocation(){
    return location;
   }

   public void setPrice(BigDecimal inputPrice){
    this.price = inputPrice;
   }

   public BigDecimal getPrice(){
    return price;
   }

   public UUID getId(){
    return id;
   }
    
    }


