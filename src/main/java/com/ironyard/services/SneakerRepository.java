package com.ironyard.services;

import com.ironyard.entities.Sneaker;
import com.ironyard.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by illladell on 6/23/16.
 */
public interface SneakerRepository extends CrudRepository<Sneaker, Integer> {
    public Iterable<Sneaker> findByBrand (String brand);
    public Iterable<Sneaker> findByYear(int year);
    public Iterable<Sneaker> findByUser(User user);
    public Iterable<Sneaker> findByBrandAndYear (String brand, int year);

    @Query("SELECT sneaker FROM Sneaker sneaker WHERE lower(sneaker.brand) LIKE '%' || LOWER(?1) || '%'")
    public Iterable<Sneaker> searchBrand(String brand);
}
