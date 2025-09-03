package com.jdy3.efarmersmarket.produce;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty Cereal("Cereal"), @JsonProperty Vegetable("Vegetable"), @JsonProperty Fruit("Fruit"), @JsonProperty None("None");
    
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

    public Produce(LocalDate entryDate, String productName, String productVariety, String productPicture, String productDescription, BigDecimal kg, String provenance, String collectionPoint, BigDecimal itemPrice, Category productCategory, LocalDate expiryDate){
        super(entryDate, productName, productVariety, productPicture, productDescription, kg, provenance, collectionPoint, itemPrice);
        this.category = productCategory;
        this.expiry = expiryDate;
    }

     public Produce(){
        super(null, "", "", "", "", BigDecimal.ZERO, "", "", BigDecimal.ZERO);
        this.category = Category.None;
        this.expiry = null;
    }

    /** Direct user to input allowed produce category values */
    public void setCategory(Category inputCategory){
        if(!inputCategory.equals(Category.Cereal) || !inputCategory.equals(Category.Vegetable) || !inputCategory.equals(Category.Fruit) || !inputCategory.equals(Category.None)){
            throw new IllegalArgumentException("Category must be Cereal, Vegetable or Fruit");
        }
        this.category = inputCategory; 
    }

    @JsonValue
    public Category getCategory(){
        return category;
    }

    public void setExpiry(LocalDate inputExpiryDate){
        this.expiry = inputExpiryDate;
    }
    
    public LocalDate getExpiry(){
        return expiry;
    }

}
