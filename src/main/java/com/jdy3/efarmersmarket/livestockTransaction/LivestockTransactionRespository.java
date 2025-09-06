package com.jdy3.efarmersmarket.livestockTransaction;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.ListCrudRepository;

public interface LivestockTransactionRespository extends ListCrudRepository<LivestockTransaction, Long> {

/** Insert age and certification columns from livestock table into livestock_transactions table  */
String upsertQuery = """
       MERGE INTO livestockTransactions (transaction_id, cost, time_stamp, product_id, quantity_bought, product_price, quantity_to_buy)
       KEY(product_id)
       VALUES (age, certification)
       """;

    public List<LivestockTransaction> findByProductId(UUID productId);

    @Query("SELECT i FROM LivestockTransaction i WHERE i.cost > (SELECT AVG(j.cost) FROM LivestockTransaction j)")
    public List<LivestockTransaction> findHighValueLivestockTransactions();

    @Query("SELECT i FROM LivestockTransaction i WHERE i.cost < (SELECT AVG(j.cost) FROM LivestockTransaction j)")
    public List<LivestockTransaction> findLowValueLivestockTransactions();

}
