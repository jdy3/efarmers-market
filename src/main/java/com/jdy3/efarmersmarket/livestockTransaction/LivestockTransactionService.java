package com.jdy3.efarmersmarket.livestockTransaction;

import org.springframework.stereotype.Service;

import com.jdy3.efarmersmarket.livestock.Livestock;
import com.jdy3.efarmersmarket.livestock.LivestockRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/** Service layer for Livestock Transaction class */

@Service

public class LivestockTransactionService {

    public final LivestockTransactionRepository livestockTransactionRepository;
    public final LivestockRepository livestockRepository;

    public LivestockTransactionService(LivestockTransactionRepository livestockTransactionRepository,
            LivestockRepository livestockRepository){
        this.livestockTransactionRepository = livestockTransactionRepository;
        this.livestockRepository = livestockRepository;
    }

    public List<LivestockTransaction> getAllLivestockTransactions(){
        return livestockTransactionRepository.findAll();
    }

    public List<LivestockTransaction> getLivestockTransactionByProductId(UUID productId){
        return livestockTransactionRepository.findByProductId(productId);
    }

    public List<LivestockTransaction> getHighValueLivestockTransactions(){
        return livestockTransactionRepository.findHighValueLivestockTransactions();
    }

    public List<LivestockTransaction> getLowValueLivestockTransactions(){
        return livestockTransactionRepository.findLowValueLivestockTransactions();
    }

    public LivestockTransaction getLivestockTransaction(long transactionId){
        return livestockTransactionRepository.findById(transactionId).orElseThrow(NoSuchElementException::new);
    }

    public LivestockTransaction createLivestockTransaction(LivestockTransaction livestockTransaction){

        /** On creation of a successful transaction, update livestock table data */

        Livestock livestock = livestockRepository.findById(livestockTransaction.getProductId()).orElseThrow(() -> new NoSuchElementException("Livestock not found"));
        int productQuantity = livestock.getQuantity();
        int quantityToBuy = livestockTransaction.getQuantityToBuy();

        if (quantityToBuy > 0 && productQuantity > quantityToBuy ){
            
            if (productQuantity == quantityToBuy){

            livestockTransactionRepository.save(livestockTransaction);
            livestockRepository.delete((Livestock) livestock);
        } 
        
        else if(productQuantity > quantityToBuy){

            livestockTransactionRepository.save(livestockTransaction);
            ((Livestock) livestock).setQuantity(productQuantity - quantityToBuy);
            
         }

        } else throw new IllegalArgumentException("Quantity must be greater than 0 and no more than the product quantitiy");

    return livestockTransaction;
    }

    public void deleteLivestockTransaction(long transactionId){
        LivestockTransaction livestockTransaction = livestockTransactionRepository.findById(transactionId).orElseThrow(NoSuchElementException::new);
        livestockTransactionRepository.delete(livestockTransaction);
    }

}
