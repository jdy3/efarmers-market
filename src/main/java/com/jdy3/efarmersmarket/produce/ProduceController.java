package com.jdy3.efarmersmarket.produce;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/products/produce")

/** Controller layer for the Produce class */

public class ProduceController {

    private final ProduceService produceService;

    public ProduceController(ProduceService produceService){
        this.produceService = produceService;
    }

    @GetMapping(produces = "application/json")
    public List<Produce> getAllProduce(@RequestParam(required = false) Produce.Category category, String name, String provenance, LocalDate expiry){
        if(category !=null){
            return produceService.getProduceByCategory(category);
        } else if(name !=null && !name.isEmpty()){
            return produceService.getProduceByName(name);
        } else if(provenance !=null && !provenance.isEmpty()){
            return produceService.getProduceByProvenance(provenance);
        } else return produceService.getAllProduce();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Produce getProduce(@PathVariable UUID id){
        try{
            return produceService.getProduce(id);
        } catch (NoSuchElementException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produce not found", exception);
        } catch (RuntimeException exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Produce> createProduce(@RequestBody Produce produce){
        System.out.println("recieved product");
        Produce createProduce = produceService.createProduce(produce);   
        return ResponseEntity.status(HttpStatus.CREATED).body(createProduce);
    }
    
    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Produce> updateProduce(@PathVariable UUID id, @RequestBody Produce ammendedProduce){
        try{
            Produce updatedProduce = produceService.updateProduce(id, ammendedProduce);
            return ResponseEntity.status(HttpStatus.OK).body(updatedProduce);
        } catch (NoSuchElementException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produce not found", exception);
        } catch (RuntimeException exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }  
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProduce(@PathVariable UUID id){
        try{
            produceService.deleteProduce(id);
        } catch (NoSuchElementException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produce not found", exception);
        } catch (RuntimeException exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }
    

}
