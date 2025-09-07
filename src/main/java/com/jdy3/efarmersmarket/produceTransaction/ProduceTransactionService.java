package com.jdy3.efarmersmarket.produceTransaction;

import org.springframework.stereotype.Service;

import com.jdy3.efarmersmarket.produce.Produce;
import com.jdy3.efarmersmarket.produce.ProduceRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/** Service layer for Produce Transaction class */

@Service

public class ProduceTransactionService {

    public final ProduceTransactionRepository produceTransactionRepository;
    public final ProduceRepository produceRepository;

    public ProduceTransactionService(ProduceTransactionRepository produceTransactionRepository, ProduceRepository produceRepository){
            this.produceTransactionRepository = produceTransactionRepository;
            this.produceRepository = produceRepository;
    }

    public List<ProduceTransaction> getAllProduceTransactions(){
        return produceTransactionRepository.findAll();
    }

    public List<ProduceTransaction> getProduceTransactionByProductId(UUID productId){
        return produceTransactionRepository.findByProductId(productId);
    }

    public List<ProduceTransaction> getHighValProduceTransactions(){
        return produceTransactionRepository.findHighValueProduceTransactions();
    }

    public List<ProduceTransaction> getLowValuProduceTransactions(){
        return produceTransactionRepository.findLowValueProduceTransactions();
    }

     public ProduceTransaction getProduceTransaction(long transactionId){
        return produceTransactionRepository.findById(transactionId).orElseThrow(NoSuchElementException::new);
    }

    public ProduceTransaction createProduceTransaction(ProduceTransaction produceTransaction){

        /** On creation of a successful transaction, update produce table data */

        Produce produce = produceRepository.findById(produceTransaction.getProductId()).orElseThrow(() -> new NoSuchElementException("Produce not found"));
        
        // Set category and expiry from Produce to ProduceTransaction
        produceTransaction.setProduceCategory(produce.getCategory().getValue());
        produceTransaction.setProduceExpiry(produce.getExpiry());
        
        BigDecimal productWeight = produce.getWeight();
        BigDecimal purchaseWeight = produceTransaction.getpurchaseWeight();

        if (purchaseWeight.compareTo(BigDecimal.ZERO) > 0 && productWeight.compareTo(purchaseWeight) >= 0){
            
            if (productWeight.compareTo(purchaseWeight) == 0){

            produceTransactionRepository.save(produceTransaction);
            produceRepository.delete((Produce) produce);
        } 
        
        else if(productWeight.compareTo(purchaseWeight) > 0){

            produceTransactionRepository.save(produceTransaction);
            ((Produce) produce).setWeight(productWeight.subtract(purchaseWeight));
            
         }

        } else throw new IllegalArgumentException("Weight to buy must be greater than 0 and no more than the product weight");

    return produceTransaction;
    }

    public void deleteProduceTransaction(long transactionId){
        ProduceTransaction produceTransaction = produceTransactionRepository.findById(transactionId).orElseThrow(NoSuchElementException::new);
        produceTransactionRepository.delete(produceTransaction);
    }

}
