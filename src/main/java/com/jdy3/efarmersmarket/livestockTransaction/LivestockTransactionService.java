package com.jdy3.efarmersmarket.livestockTransaction;

import org.springframework.stereotype.Service;

import com.jdy3.efarmersmarket.livestock.Livestock;
import com.jdy3.efarmersmarket.livestock.LivestockRepository;

import java.math.BigDecimal;
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

        /** Retrieve product fields */
        Livestock livestock = livestockRepository.findById(livestockTransaction.getProductId()).orElseThrow(() -> new NoSuchElementException("Livestock not found"));

        BigDecimal productPrice = livestock.getPrice();
        livestockTransaction.setProductPrice(productPrice);

        String productName = livestock.getName();
        livestockTransaction.setProductName(productName);

        String productPicture = livestock.getPicture();
        livestockTransaction.setproductPicture(productPicture);

        String productDescription = livestock.getDescription();
        livestockTransaction.setProductDescription(productDescription);

        String productProvenance = livestock.getProvenance();
        livestockTransaction.setProductProvenance(productProvenance);

        String productLocation = livestock.getLocation();
        livestockTransaction.setProductLocation(productLocation);   

       
        /** Retrieve livestock fields */
        livestockTransaction.setLivestockBreed(livestock.getBreed());
        livestockTransaction.setLivestockAge(livestock.getAge());
        livestockTransaction.setLivestockCertification(livestock.getCertification());

        int productQuantity = livestock.getQuantity();
        int purchaseQuantity = livestockTransaction.getPurchaseQuantity();

        livestockTransaction.setPurchaseCost(BigDecimal.valueOf(purchaseQuantity).multiply(productPrice));

        if (purchaseQuantity > 0 && productQuantity >= purchaseQuantity ){
            
            if (productQuantity == purchaseQuantity){

            livestockTransactionRepository.save(livestockTransaction);
            livestockRepository.delete((Livestock) livestock);
        } 
        
        else if(productQuantity > purchaseQuantity){

            livestockTransactionRepository.save(livestockTransaction);
            ((Livestock) livestock).setQuantity(productQuantity - purchaseQuantity);
            livestockRepository.save(livestock);
            
         }

        } else throw new IllegalArgumentException("Purchase quantity must be greater than 0 and no more than the product quantitiy");

    return livestockTransaction;
    }

    /** Transactions should be immutable, change to refud */
    // public LivestockTransaction updateLivestockTransaction(long id, LivestockTransaction amendedLivestockTransaction){
    //     LivestockTransaction existingLivestockTransaction = livestockTransactionRepository.findById(id).orElseThrow(NoSuchElementException::new);

    //     existingLivestockTransaction.setPurchaseQuantity(amendedLivestockTransaction.getPurchaseQuantity());

    //     return livestockTransactionRepository.save(existingLivestockTransaction);

    // }

    /** Although transactions should be immutable, delete endpoint is useful in development */
    public void deleteLivestockTransaction(long transactionId){
        LivestockTransaction livestockTransaction = livestockTransactionRepository.findById(transactionId).orElseThrow(NoSuchElementException::new);
        livestockTransactionRepository.delete(livestockTransaction);
    }

}
