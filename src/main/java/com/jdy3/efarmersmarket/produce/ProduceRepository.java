package com.jdy3.efarmersmarket.produce;

import java.util.List;
import java.util.UUID;
import java.time.LocalDate;
import org.springframework.data.repository.ListCrudRepository;

public interface ProduceRepository extends ListCrudRepository<Produce, UUID> {
    
    public List<Produce> findByCategory(Produce.Category category);
    public List<Produce> findByName(String name);
    public List<Produce> findByExpiry(LocalDate expiry);
    public List<Produce> findByProvenance(String farm);

}
