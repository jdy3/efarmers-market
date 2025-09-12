package com.jdy3.efarmersmarket.livestockTransaction;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/transactions/livestock-transactions")

/** Controller layer for the Livestock Transaction class */

public class LivestockTransactionController {

    private final LivestockTransactionService livestockTransactionService;

    public LivestockTransactionController(LivestockTransactionService livestockTransactionService){
        this.livestockTransactionService = livestockTransactionService;
    }

    @GetMapping(produces = "application/json")
    public List<LivestockTransaction> getAllLivestockTransactions(@RequestParam(required = false) UUID productId){
        if(productId != null){
            return livestockTransactionService.getLivestockTransactionByProductId(productId);
        } else return livestockTransactionService.getAllLivestockTransactions();
    }

    @GetMapping(path = "/{transactionId}", produces = "application/json")
    public LivestockTransaction getLivestockTransaction(@PathVariable long transactionId){
        try{
            return livestockTransactionService.getLivestockTransaction(transactionId);
        } catch (NoSuchElementException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livestock transaction not found", exception);
        } catch (RuntimeException exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @GetMapping(path = "/high", produces = "application/json")
    public List<LivestockTransaction> getHighValueLivestockTransactions(){
        return livestockTransactionService.getHighValueLivestockTransactions();
    }

    @GetMapping(path = "/low", produces = "application/json")
    public List<LivestockTransaction> getLowValueLivestockTransactions(){
        return livestockTransactionService.getLowValueLivestockTransactions();
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<LivestockTransaction> createdLivestockTransaction(@RequestBody LivestockTransaction livestockTransaction) {
        LivestockTransaction createLivestockTransaction = livestockTransactionService.createLivestockTransaction(livestockTransaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(createLivestockTransaction);
    }

    /** Although transactions should be immutable, delete endpoint is useful for development */    
    @DeleteMapping("/{transactionId}")
    public void deleteLivestockTransaction(@PathVariable long transactionId){
        try{
            livestockTransactionService.deleteLivestockTransaction(transactionId);
        } catch (NoSuchElementException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livestock transaction not found", exception);
        } catch (RuntimeException exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }
    

}
