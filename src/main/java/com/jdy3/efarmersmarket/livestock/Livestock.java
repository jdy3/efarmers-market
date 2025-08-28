package com.jdy3.efarmersmarket.livestock;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.jdy3.efarmersmarket.Product;

public class Livestock extends Product {
    /** Concrete child Livestock Product class */

    protected double age;
    protected int quantity;
    protected String certification;

    public Livestock(LocalDate entryDate, String productName, String productVariety, String productPicture, String productDescription, BigDecimal kg, String provenance, String collectionPoint, BigDecimal itemPrice, double animalAge, int numberOfAnimals, String certDetails){
        super(entryDate, productName, productVariety, productPicture, productDescription, kg, provenance, collectionPoint, itemPrice);
        this.age = animalAge;
        this.quantity = numberOfAnimals;
        this.certification = certDetails;
    }

    public Livestock(){
        super(null, "", "", "", "", BigDecimal.ZERO, "", "", BigDecimal.ZERO)
        this.age = 0.0d;
        this.quantity = 0;
        this.certification = "";
    }

    public void setAge(double inputAge){
        this.age = inputAge;
    }

    public double getAge(){
        return age;
    }

    public void setQuantity(int inputQuantity){
        this.quantity = inputQuantity;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setCertification(String inputCert){
        this.certification = inputCert;
    }

    public String getCertitification(){
        return certification;
    }
    
}
