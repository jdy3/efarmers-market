package com.jdy3.efarmersmarket.livestockTransaction;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.ListCrudRepository;

import com.jdy3.efarmersmarket.Product;

public interface LivestockTransactionRepository extends ListCrudRepository<LivestockTransaction, Long> {

    public List<LivestockTransaction> findByProduct(Product product);

    @Query("SELECT i FROM LivestockTransaction i WHERE i.cost > (SELECT AVG(j.cost) FROM LivestockTransaction j)")
    public List<LivestockTransaction> findHighValueLivestockTransactions();

    @Query("SELECT i FROM LivestockTransaction i WHERE i.cost < (SELECT AVG(j.cost) FROM LivestockTransaction j)")
    public List<LivestockTransaction> findLowValueLivestockTransactions();

}
