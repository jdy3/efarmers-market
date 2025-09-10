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

    protected String livestockBreed;
    protected double livestockAge;
    protected String livestockCertification;
    protected int purchaseQuantity;
    protected BigDecimal cost;

    public LivestockTransaction(UUID productId, int purchaseQuantity){
        super(productId);
        this.purchaseQuantity = purchaseQuantity;
    }

    public LivestockTransaction(){
    super(null);
    }

    public void setLivestockBreed(String inputBreed){
        this.livestockBreed = inputBreed;
    }

    public String getLivestockBreed(){
        return livestockBreed;
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

    public void setPurchaseQuantity(int inputpurchaseQuantity){
        this.purchaseQuantity = inputpurchaseQuantity;
    }

    public int getPurchaseQuantity(){
        return purchaseQuantity;
    }

    public void setPurchaseCost(BigDecimal inputCost){
        this.cost = inputCost;
    }

    public BigDecimal getPurchaseCost(){
        return cost;
    }

}
