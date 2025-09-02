package com.jdy3.efarmersmarket.produce;

import java.util.List;
import java.util.UUID;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProduceRepository extends ListCrudRepository<Produce, UUID> {
    
    public List<Produce> findByCategory(Produce.Category category);
    public List<Produce> findByName(String name);
    public List<Produce> findByProvenance(String provenance);

    @Query("SELECT i FROM Produce i WHERE i.expiry.isAfter(:expiry)") public List<Produce> findByExpiryAfter(@Param("expiry") LocalDate expiry);

}
