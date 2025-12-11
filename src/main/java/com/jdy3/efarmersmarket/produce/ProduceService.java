package com.jdy3.efarmersmarket.produce;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.Objects;

import org.springframework.stereotype.Service;

import io.micrometer.common.lang.NonNull;


/** Service layer for Produce class */

@Service

public class ProduceService {

    public final ProduceRepository produceRepository;

    public ProduceService(ProduceRepository produceRepository){
        this.produceRepository = produceRepository;
    }

    public List<Produce> getAllProduce(){
        return produceRepository.findAll();
    }

    public List<Produce> getProduceByCategory(Produce.Category category){
        return produceRepository.findByCategory(category);
    }

    public List<Produce> getProduceByName(String name){
        return produceRepository.findByName(name);
    }

     public List<Produce> getProduceByExpiry(LocalDate expiry){
        return produceRepository.findByExpiryAfter(expiry);
    }

    public List<Produce> getProduceByProvenance(String provenance){
        return produceRepository.findByProvenance(provenance);
    }

    public Produce getProduce(@NonNull UUID id){
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        return produceRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Produce createProduce(Produce produce){
        if (produce == null) {
            throw new IllegalArgumentException("produce must not be null");
        }
        return produceRepository.save(produce);
    }

    public Produce updateProduce(@NonNull UUID id, Produce updatedProduce){
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }

        Produce existingProduce = produceRepository.findById(id).orElseThrow(NoSuchElementException::new);

        existingProduce.setDate(updatedProduce.getDate());
        existingProduce.setName(updatedProduce.getName());
        existingProduce.setVariety(updatedProduce.getVariety());
        existingProduce.setPicture(updatedProduce.getPicture());
        existingProduce.setDescription(updatedProduce.getDescription());
        existingProduce.setWeight(updatedProduce.getWeight());
        existingProduce.setProvenance(updatedProduce.getProvenance());
        existingProduce.setLocation(updatedProduce.getLocation());
        existingProduce.setPrice(updatedProduce.getPrice());
        existingProduce.setCategory(updatedProduce.getCategory());
        existingProduce.setExpiry(updatedProduce.getExpiry());     

        produceRepository.save(existingProduce);

        return existingProduce;
    }

    public void deleteProduce(@NonNull UUID id){
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        
        Produce produce = produceRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Produce not found for id: " + id));

        Objects.requireNonNull(produce, "produce must not be null");

        produceRepository.delete(produce);
    }

}
