package com.jdy3.efarmersmarket.livestock;

import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.ListCrudRepository;

public interface LivestockRepository extends ListCrudRepository<Livestock, UUID>{

    public List<Livestock> findByName(String name);
    public List<Livestock> findByProvenance(String provenance);

}
