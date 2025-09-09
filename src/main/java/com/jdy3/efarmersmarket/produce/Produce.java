package com.jdy3.efarmersmarket.produce;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonValue;
import com.jdy3.efarmersmarket.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "produce")

public class Produce extends Product {
    /** Concrete child Produce class */

    /** Restrict produce input category values */
    public enum Category {
    Cereal("Cereal"), Vegetable("Vegetable"), Fruit("Fruit"), None("None");
    
    private final String value;
    Category(String value){
        this.value = value;
    }

    @JsonValue
    public String getValue(){
        return value;
    }
    };

    @Enumerated(EnumType.STRING)
    protected Category category;
    protected LocalDate expiry;
    protected String variety;

    public Produce(LocalDate entryDate, String productName, String productPicture, String productDescription, BigDecimal kg, String provenance, String collectionPoint, BigDecimal itemPrice, Category productCategory, LocalDate expiryDate, String productVariety){
        super(entryDate, productName, productPicture, productDescription, kg, provenance, collectionPoint, itemPrice);
        this.category = productCategory;
        this.expiry = expiryDate;
        this.variety = productVariety; 
    }

     public Produce(){
        super(null, "", "", "", BigDecimal.ZERO, "", "", BigDecimal.ZERO);
        this.category = Category.None;
        this.expiry = null;
    }

    /** Direct user to input allowed produce category values */
    public void setCategory(Category inputCategory){
        this.category = inputCategory; 
    }

    public Category getCategory(){
        return category;
    }

    public void setExpiry(LocalDate inputExpiryDate){
        this.expiry = inputExpiryDate;
    }
    
    public LocalDate getExpiry(){
        return expiry;
    }

    public void setVariety(String inputVariety){
        this.variety = inputVariety;
    }

    public String getVariety(){
        return variety;
    }

}
