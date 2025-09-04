package com.jdy3.efarmersmarket.livestockTransaction;

import org.springframework.stereotype.Service;

import com.jdy3.efarmersmarket.livestock.Livestock;
import com.jdy3.efarmersmarket.livestock.LivestockRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/** Service layer for LivestockTransaction class */

@Service

public class LivestockTransactionService {

    public final LivestockTransactionRespository livestockTransactionRespository;
    public final LivestockRepository livestockRepository;

    public LivestockTransactionService(LivestockTransactionRespository livestockTransactionRespository,
            LivestockRepository livestockRepository) {
        this.livestockTransactionRespository = livestockTransactionRespository;
        this.livestockRepository = livestockRepository;
    }

    public List<LivestockTransaction> getAllLivestockTransactions() {
        return livestockTransactionRespository.findAll();
    }

    public List<LivestockTransaction> getLivestockTransactionByProductId(UUID productId) {
        return livestockTransactionRespository.findByProductId(productId);
    }

    public List<LivestockTransaction> getHighValueLivestockTransactions() {
        return livestockTransactionRespository.findHighValueLivestockTransactions();
    }

    public List<LivestockTransaction> getLowValueLivestockTransactions() {
        return livestockTransactionRespository.findLowValueLivestockTransactions();
    }

    public LivestockTransaction getLivestockTransaction(long transactionId) {
        return livestockTransactionRespository.findById(transactionId).orElseThrow(NoSuchElementException::new);
    }

    public LivestockTransaction createLivestockTransaction(LivestockTransaction livestockTransaction) {

        Livestock livestock = livestockRepository.findById(livestockTransaction.getProductId()).orElseThrow(() -> new NoSuchElementException("Livestock not found"));
        int productQuantity = livestock.getQuantity();
        int quantityToBuy = livestockTransaction.getQuantityToBuy();

        if (quantityToBuy > 0 && productQuantity > quantityToBuy ){
            
            if (productQuantity == quantityToBuy) {

            livestockTransactionRespository.save(livestockTransaction);
            livestockRepository.delete((Livestock) livestock);
        } 
        
        else if(productQuantity > quantityToBuy) {

            livestockTransactionRespository.save(livestockTransaction);
            ((Livestock) livestock).setQuantity(productQuantity - quantityToBuy);
            
         }

        } else throw new IllegalArgumentException("Quantity must be greater than 0 and less than the product quantitiy");

    return livestockTransaction;
    }

    public void deleteLivestockTransaction(long transactionId){
        LivestockTransaction livestockTransaction = livestockTransactionRespository.findById(transactionId).orElseThrow(NoSuchElementException::new);
        livestockTransactionRespository.delete(livestockTransaction);
    }

}
