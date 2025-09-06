package com.jdy3.efarmersmarket.livestockTransaction;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.ListCrudRepository;

public interface LivestockTransactionRespository extends ListCrudRepository<LivestockTransaction, Long> {

    public List<LivestockTransaction> findByProductId(UUID productId);

    @Query("SELECT i FROM LivestockTransaction i WHERE i.cost > (SELECT AVG(j.cost) FROM LivestockTransaction j)") public List<LivestockTransaction> findHighValueLivestockTransactions();
    @Query("SELECT i FROM LivestockTransaction i WHERE i.cost < (SELECT AVG(j.cost) FROM LivestockTransaction j)") public List<LivestockTransaction> findLowValueLivestockTransactions();
    


} 
