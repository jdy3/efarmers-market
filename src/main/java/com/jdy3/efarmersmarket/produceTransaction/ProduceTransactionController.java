package com.jdy3.efarmersmarket.produceTransaction;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
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
            return produceTransactionService.getProduceTransactionByProductId(productId);
        } else return produceTransactionService.getAllProduceTransactions();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ProduceTransaction getProduceTransaction(@PathVariable long transactionId){
        try{
            return produceTransactionService.getProduceTransaction(transactionId);
        } catch (NoSuchElementException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produce transaction not found", exception);
        } catch (RuntimeException exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @GetMapping(path = "/high", produces = "application/json")
    public List<ProduceTransaction> getHighValProduceTransactions(){
        return produceTransactionService.getHighValProduceTransactions();
    }

    @GetMapping(path = "/low", produces = "application/json")
    public List<ProduceTransaction> getHighValueProduceTransactions(){
        return produceTransactionService.getLowValuProduceTransactions();
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduceTransaction(@PathVariable long transactionId){
        try{
            produceTransactionService.deleteProduceTransaction(transactionId);
        } catch (NoSuchElementException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produce transaction not found", exception);
        } catch (RuntimeException exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

}
