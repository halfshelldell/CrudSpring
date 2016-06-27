package com.ironyard.services;

import com.ironyard.entities.Sneaker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by illladell on 6/23/16.
 */
public interface SneakerRepository extends CrudRepository<Sneaker, Integer> {
    public Iterable<Sneaker> findByBrand (String brand);


}
