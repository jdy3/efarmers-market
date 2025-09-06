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
    protected int quantityToBuy;
    protected BigDecimal cost = BigDecimal.valueOf(quantityToBuy).multiply(this.productPrice);

    public LivestockTransaction(UUID productId, int quantityToBuy){
        super(productId);
        this.quantityToBuy = quantityToBuy;
    }

    public void setQuantityToBuy(int inputQuantityToBuy){
        this.quantityToBuy = inputQuantityToBuy;
    }

    public int getQuantityToBuy(){
        return quantityToBuy;
    }

    public void setCost(BigDecimal inputCost){
        this.cost = inputCost;
    }

    public BigDecimal getCost(){
        return cost;
    }

}
