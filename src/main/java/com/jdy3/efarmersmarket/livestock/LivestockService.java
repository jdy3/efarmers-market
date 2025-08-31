package com.jdy3.efarmersmarket.livestock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;


/** Service layer for Livestock class */

@Service

public class LivestockService {

    public final LivestockRepository livestockRepository;

    public LivestockService(LivestockRepository livestockRepository){
        this.livestockRepository = livestockRepository;
    }

    public List<Livestock> getAllLivestock(){
        return livestockRepository.findAll();
    }

    public List<Livestock> getLivestockByName(String name){
        return livestockRepository.findByName(name);
    }

    public List<Livestock> getLivestockByProvenance(String farm){
        return livestockRepository.findByProvenance(farm);
    }

    public Livestock getLivestock(UUID id){
        return livestockRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Livestock createLivestock(Livestock livestock){
        livestockRepository.save(livestock);
        return livestock;
    }

    public Livestock updateLivestock(UUID id, Livestock updatedLivestock){
        Livestock existingLivestock = livestockRepository.findById(id).orElseThrow(NoSuchElementException::new);

        existingLivestock.setDate(updatedLivestock.getDate());
        existingLivestock.setName(updatedLivestock.getName());
        existingLivestock.setVariety(updatedLivestock.getVariety());
        existingLivestock.setPicture(updatedLivestock.getPicture());
        existingLivestock.setDescription(updatedLivestock.getDescription());
        existingLivestock.setWeight(updatedLivestock.getWeight());
        existingLivestock.setProvenance(updatedLivestock.getProvenance());
        existingLivestock.setLocation(updatedLivestock.getLocation());
        existingLivestock.setPrice(updatedLivestock.getPrice());
        existingLivestock.setAge(updatedLivestock.getAge());
        existingLivestock.setQuantity(updatedLivestock.getQuantity());
        existingLivestock.setCertification(updatedLivestock.getCertitification());

        livestockRepository.save(existingLivestock);

        return existingLivestock;
    }

    public void deleteLivestock(UUID id){
        Livestock livestock = livestockRepository.findById(id).orElseThrow(NoSuchElementException::new);
        livestockRepository.delete(livestock);
    }

}
