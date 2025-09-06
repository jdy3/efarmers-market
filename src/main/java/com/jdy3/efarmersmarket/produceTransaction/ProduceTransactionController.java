package com.jdy3.efarmersmarket.produceTransaction;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/transactions/produce-transactions")

/** Controller layer for the Produce Transaction class */

public class ProduceTransactionController {

    private final ProduceTransactionService produceTransactionService;

    public ProduceTransactionController(ProduceTransactionService produceTransactionService){
        this.produceTransactionService = produceTransactionService;
    }

    @GetMapping(produces = "application/json")
    public List<ProduceTransaction> getAllProduceTransactions(@RequestParam(required = false) UUID productId){
        if(productId != null){
            return produceTransactionService.getProductTransactionByProductId(productId);
        } else return produceTransactionService.getAllProduceTransactions();
    }
    

}
