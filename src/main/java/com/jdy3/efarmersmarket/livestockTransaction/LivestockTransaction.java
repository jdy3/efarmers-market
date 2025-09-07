package com.jdy3.efarmersmarket.livestockTransaction;

import com.jdy3.efarmersmarket.Transaction;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "livestockTransactions")

public class LivestockTransaction extends Transaction {
    /** Concrete child livestock transaction entity */
    protected double livestockAge;
    protected String livestockCertification;
    protected int purchaseQuantity;
    protected BigDecimal cost = BigDecimal.valueOf(purchaseQuantity).multiply(this.productPrice);

    public LivestockTransaction(UUID productId, int purchaseQuantity){
        super(productId);
        this.purchaseQuantity = purchaseQuantity;
    }

    public void setLivestockAge(double age){
        this.livestockAge = age;
    }

    public double getLivestockAge(){
        return livestockAge;
    }

    public void setLivestockCertification(String certification){
        this.livestockCertification = certification;
    }

    public String getLivestockCertification (){
        return livestockCertification;
    }

    public void setpurchaseQuantity(int inputpurchaseQuantity){
        this.purchaseQuantity = inputpurchaseQuantity;
    }

    public int getpurchaseQuantity(){
        return purchaseQuantity;
    }

    public void setCost(BigDecimal inputCost){
        this.cost = inputCost;
    }

    public BigDecimal getCost(){
        return cost;
    }

}
