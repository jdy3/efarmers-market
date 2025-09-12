package com.jdy3.efarmersmarket.produceTransaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jdy3.efarmersmarket.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "produceTransactions")

public class ProduceTransaction extends Transaction {
    /** Concrete child produce transaction entity */

    /** Temporary field for deserialisation only (not persisted) */
    protected transient UUID tempProductId;

    protected String produceVariety;
    protected String produceCategory;
    protected LocalDate produceExpiry;
    protected BigDecimal purchaseWeight;
    protected BigDecimal cost;

    public ProduceTransaction(UUID productId, BigDecimal purchaseWeight){
        this.tempProductId = productId;
        this.purchaseWeight = purchaseWeight;
    }

    public ProduceTransaction(){
    }

    @JsonProperty("productId")
    public void setTempProductId(UUID inputProductId){
        this.tempProductId = inputProductId;
    }

    public UUID getTempProductId(){
        return tempProductId;
    }

    public void setProduceVariety(String inputVariety){
        this.produceVariety = inputVariety;
    }

    public String getProduceVariety(){
        return produceVariety;
    }

    public void setProduceCategory(String category){
        this.produceCategory = category;
    }

    public String getProduceCategory(){
        return produceCategory;
    }

    public void setProduceExpiry(LocalDate expiry){
        this.produceExpiry = expiry;
    }

    public LocalDate getProduceExpiry(){
        return produceExpiry;
    }

    public void setPurchaseWeight(BigDecimal inputpurchaseWeight){
        this.purchaseWeight = inputpurchaseWeight;
    }

    public BigDecimal getPurchaseWeight(){
        return purchaseWeight;
    }

    public void setPurchaseCost(BigDecimal inputCost){
        this.cost = inputCost;
    }

    public BigDecimal getPurchaseCost(){
        return cost;
    }

}
