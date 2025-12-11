package com.jdy3.efarmersmarket.livestock;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.micrometer.common.lang.NonNull;

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

    public List<Livestock> getLivestockByProvenance(String provenance){
        return livestockRepository.findByProvenance(provenance);
    }

    public Livestock getLivestock(@NonNull UUID id){
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }
        return livestockRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Livestock createLivestock(Livestock livestock){
        if (livestock == null) {
            throw new IllegalArgumentException("livestock must not be null");
        }
        livestockRepository.save(livestock);
        return livestock;
    }

    public Livestock updateLivestock(@NonNull UUID id, Livestock updatedLivestock){
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }

        Livestock existingLivestock = livestockRepository.findById(id).orElseThrow(NoSuchElementException::new);

        existingLivestock.setDate(updatedLivestock.getDate());
        existingLivestock.setName(updatedLivestock.getName());
        existingLivestock.setBreed(updatedLivestock.getBreed());
        existingLivestock.setPicture(updatedLivestock.getPicture());
        existingLivestock.setDescription(updatedLivestock.getDescription());
        existingLivestock.setWeight(updatedLivestock.getWeight());
        existingLivestock.setProvenance(updatedLivestock.getProvenance());
        existingLivestock.setLocation(updatedLivestock.getLocation());
        existingLivestock.setPrice(updatedLivestock.getPrice());
        existingLivestock.setAge(updatedLivestock.getAge());
        existingLivestock.setQuantity(updatedLivestock.getQuantity());
        existingLivestock.setCertification(updatedLivestock.getCertification());

        livestockRepository.save(existingLivestock);

        return existingLivestock;
    }

    public void deleteLivestock(@NonNull UUID id){
        if (id == null) {
            throw new IllegalArgumentException("id must not be null");
        }

        Livestock livestock = livestockRepository.findById(id).orElseThrow(NoSuchElementException::new);

        Objects.requireNonNull(livestock, "produce must not be null");

        livestockRepository.delete(livestock);
    }

}
