package com.jdy3.efarmersmarket.produce;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.Locale.Category;

import org.springframework.stereotype.Service;


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

    public List<Produce> getProduceByCategory(Category category){
        return produceRepository.findByCategory(category);
    }

    public List<Produce> getProduceByExpiry(LocalDate expiry){
        return produceRepository.findByExpiry(expiry);
    }

    public List<Produce> getProduceByName(String name){
        return produceRepository.findByName(name);
    }

    public List<Produce> getProduceByProvenance(String farm){
        return produceRepository.findByProvenance(farm);
    }

    public Produce getProduce(UUID id){
        return produceRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Produce createProduce(Produce produce){
        produceRepository.save(Produce);
        return produce;
    }

    public Produce updateProduce(UUID id, Produce updatedProduce){
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

    public void deleteProduce(UUID id){
        Produce produce = produceRepository.findById(id).orElseThrow(NoSuchElementException::new);
        produceRepository.delete(produce);
    }

}
