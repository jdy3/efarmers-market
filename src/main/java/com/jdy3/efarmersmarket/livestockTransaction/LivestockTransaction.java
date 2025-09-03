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

    protected int quantityBought;

    public LivestockTransaction(UUID productId, BigDecimal cost, int quantityBought){
        super(productId, cost);
        this.quantityBought = quantityBought;
    }

    public void setQuantityBought(int inputQuantityBought){
        this.quantityBought = inputQuantityBought;
    }

    public int getQuantityBought(){
        return quantityBought;
    }

}
