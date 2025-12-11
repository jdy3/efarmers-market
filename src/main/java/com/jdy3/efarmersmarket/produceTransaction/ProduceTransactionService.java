package com.jdy3.efarmersmarket.produceTransaction;

import org.springframework.stereotype.Service;

import com.jdy3.efarmersmarket.produce.Produce;
import com.jdy3.efarmersmarket.produce.ProduceRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.Objects;

import io.micrometer.common.lang.NonNull;

/** Service layer for Produce Transaction class */

@Service

public class ProduceTransactionService {

    public final ProduceTransactionRepository produceTransactionRepository;
    public final ProduceRepository produceRepository;

    public ProduceTransactionService(ProduceTransactionRepository produceTransactionRepository,
            ProduceRepository produceRepository) {
        this.produceTransactionRepository = produceTransactionRepository;
        this.produceRepository = produceRepository;
    }

    public List<ProduceTransaction> getAllProduceTransactions() {
        return produceTransactionRepository.findAll();
    }

    public List<ProduceTransaction> getProduceTransactionByProductId(@NonNull UUID productId) {
        /** Fetch produce entity by its ID */
        if (productId == null) {
            throw new IllegalArgumentException("product id must not be null");
        }

        Produce produce = produceRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("produce not found for id " + productId));
        return produceTransactionRepository.findByProduct(produce);
    }

    public List<ProduceTransaction> getHighValueProduceTransactions() {
        return produceTransactionRepository.findHighValueProduceTransactions();
    }

    public List<ProduceTransaction> getLowValueProduceTransactions() {
        return produceTransactionRepository.findLowValueProduceTransactions();
    }

    public ProduceTransaction getProduceTransaction(long transactionId) {
        return produceTransactionRepository.findById(transactionId).orElseThrow(NoSuchElementException::new);
    }

    public ProduceTransaction createProduceTransaction(ProduceTransaction produceTransaction) {
        /** Retrieve product fields */
        UUID productId = produceTransaction.getTempProductId();

        if (productId == null) {
            throw new IllegalArgumentException("product id must not be null");
        }

        Produce produce = produceRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("produce not found for product id " + productId));
        produceTransaction.setProduct(produce);

        BigDecimal productPrice = produce.getPrice();
        produceTransaction.setProductPrice(productPrice);

        String productName = produce.getName();
        produceTransaction.setProductName(productName);

        String productPicture = produce.getPicture();
        produceTransaction.setproductPicture(productPicture);

        String productDescription = produce.getDescription();
        produceTransaction.setProductDescription(productDescription);

        String productProvenance = produce.getProvenance();
        produceTransaction.setProductProvenance(productProvenance);

        String productLocation = produce.getLocation();
        produceTransaction.setProductLocation(productLocation);

        /** Retrieve produce fields */
        produceTransaction.setProduceVariety(produce.getVariety());
        produceTransaction.setProduceCategory(produce.getCategory().getValue());
        produceTransaction.setProduceExpiry(produce.getExpiry());

        BigDecimal productWeight = produce.getWeight();
        BigDecimal purchaseWeight = produceTransaction.getPurchaseWeight();

        produceTransaction.setPurchaseCost(purchaseWeight.multiply(productPrice));

        /** On creation of a successful transaction, update produce table data */
        if (purchaseWeight.compareTo(BigDecimal.ZERO) > 0 && productWeight.compareTo(purchaseWeight) >= 0) {

            produceTransactionRepository.save(produceTransaction);
            ((Produce) produce).setWeight(productWeight.subtract(purchaseWeight));
            produceRepository.save(produce);

        } else
            throw new IllegalArgumentException(
                    "Purchase weight must be greater than 0 and no more than the product weight");
        return produceTransaction;
    }

    /**
     * Although transactions should be immutable, delete endpoint is useful in
     * development
     */
    public void deleteProduceTransaction(long transactionId) {
        ProduceTransaction produceTransaction = produceTransactionRepository.findById(transactionId)
                .orElseThrow(NoSuchElementException::new);

        Objects.requireNonNull(produceTransaction, "produce transaction must not be null");

        produceTransactionRepository.delete(produceTransaction);
    }

}
