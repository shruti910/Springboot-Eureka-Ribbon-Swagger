package com.example.flywaydb.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.flywaydb.Inventory;
import java.util.Optional;


public interface InventoryRepository extends CrudRepository<Inventory, Integer>{
    public Optional<Inventory> findById(int invId);

    public void deleteById(int invId);

}
