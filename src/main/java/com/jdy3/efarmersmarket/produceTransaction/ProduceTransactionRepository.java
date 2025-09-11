package com.jdy3.efarmersmarket.produceTransaction;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import com.jdy3.efarmersmarket.Product;

public interface ProduceTransactionRepository extends ListCrudRepository<ProduceTransaction, Long> {

    public List<ProduceTransaction> findByProduct(Product product);

    @Query("SELECT i FROM ProduceTransaction i WHERE i.cost > (SELECT AVG(j.cost) FROM ProduceTransaction j)")
    public List<ProduceTransaction> findHighValueProduceTransactions();

    @Query("SELECT i FROM ProduceTransaction i WHERE i.cost < (SELECT AVG(j.cost) FROM ProduceTransaction j)")
    public List<ProduceTransaction> findLowValueProduceTransactions();

}
