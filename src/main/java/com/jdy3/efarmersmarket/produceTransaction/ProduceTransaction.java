package com.jdy3.efarmersmarket.produceTransaction;

import com.jdy3.efarmersmarket.Product;
import com.jdy3.efarmersmarket.Transaction;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "produceTransactions")

public class ProduceTransaction extends Transaction {
    /** Concrete child produce transaction entity */

    protected BigDecimal weightBought;

    public ProduceTransaction(Product product, BigDecimal cost, BigDecimal weightBought){
        super(product, cost);
        this.weightBought = weightBought;
    }

    public void setWeightBought(BigDecimal inputWeightBought){
        this.weightBought = inputWeightBought;
    }

    public BigDecimal getWeightBought(){
        return weightBought;
    }

}
