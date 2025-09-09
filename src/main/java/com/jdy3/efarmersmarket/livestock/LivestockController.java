package com.jdy3.efarmersmarket.livestock;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/products/livestock")

/** Controller layer for the Livestock class */

public class LivestockController {

    private final LivestockService livestockService;

    public LivestockController(LivestockService livestockService){
        this.livestockService = livestockService;
    }

    @GetMapping(produces = "application/json")
    public List<Livestock> getAllLivestock(@RequestParam(required = false) String name, String provenance){
        if(name !=null && !name.isEmpty()){
            return livestockService.getLivestockByName(name);
        } else if(provenance !=null && !provenance.isEmpty()){
            return livestockService.getLivestockByProvenance(provenance);
        } else return livestockService.getAllLivestock();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Livestock getLivestock(@PathVariable UUID id){
        try{
            return livestockService.getLivestock(id);
        } catch (NoSuchElementException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livestock not found", exception);
        } catch (RuntimeException exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Livestock> createLivestock(@RequestBody Livestock livestock){
        Livestock createdLivestock = livestockService.createLivestock(livestock);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLivestock);        
    }
    
    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Livestock> updateLivestock(@PathVariable UUID id, @RequestBody Livestock amendedlivestock){
        try{
            Livestock updatedLivestock = livestockService.updateLivestock(id, amendedlivestock);
            return ResponseEntity.status(HttpStatus.OK).body(updatedLivestock);
        } catch (NoSuchElementException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livestock not found", exception);
        }catch (RuntimeException exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @DeleteMapping(path = "/{id}")
    public void deleteLivestock(@PathVariable UUID id){
        try{
            livestockService.deleteLivestock(id);
        } catch (NoSuchElementException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livestock not found", exception);
        } catch (RuntimeException exception){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

}
