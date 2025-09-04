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

    protected BigDecimal weightToBuy;
    protected BigDecimal cost = weightToBuy.multiply(this.productPrice);

    public ProduceTransaction(UUID productId, BigDecimal weightToBuy){
        super(productId);
        this.weightToBuy = weightToBuy;
    }

    public void setWeightToBuy(BigDecimal inputWeightBought){
        this.weightToBuy = inputWeightBought;
    }

    public BigDecimal getWeightToBuy(){
        return weightToBuy;
    }

    public void setCost(BigDecimal inputCost){
        this.cost = inputCost;
    }

    public BigDecimal getCost(){
        return cost;
    }

}
