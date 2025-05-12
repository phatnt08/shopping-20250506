package com.shopping.inventory_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.inventory_service.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {

}
