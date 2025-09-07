package com.jdy3.efarmersmarket.produceTransaction;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface ProduceTransactionRepository extends ListCrudRepository<ProduceTransaction, Long> {

    public List<ProduceTransaction> findByProductId(UUID productId);

    @Query("SELECT i FROM ProduceTransaction i WHERE i.cost > (SELECT AVG(j.cost) FROM ProduceTransaction j)")
    public List<ProduceTransaction> findHighValueProduceTransactions();

    @Query("SELECT i FROM ProduceTransaction i WHERE i.cost < (SELECT AVG(j.cost) FROM ProduceTransaction j)")
    public List<ProduceTransaction> findLowValueProduceTransactions();

}
