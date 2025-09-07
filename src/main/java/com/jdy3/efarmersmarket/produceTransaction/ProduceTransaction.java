package com.jdy3.efarmersmarket.produceTransaction;

import com.jdy3.efarmersmarket.Transaction;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "produceTransactions")

public class ProduceTransaction extends Transaction {
    /** Concrete child produce transaction entity */

    protected BigDecimal purchaseWeight;
    protected BigDecimal cost = purchaseWeight.multiply(this.productPrice);

    public ProduceTransaction(UUID productId, BigDecimal purchaseWeight){
        super(productId);
        this.purchaseWeight = purchaseWeight;
    }

    public void setpurchaseWeight(BigDecimal inputpurchaseWeight){
        this.purchaseWeight = inputpurchaseWeight;
    }

    public BigDecimal getpurchaseWeight(){
        return purchaseWeight;
    }

    public void setCost(BigDecimal inputCost){
        this.cost = inputCost;
    }

    public BigDecimal getCost(){
        return cost;
    }

}
