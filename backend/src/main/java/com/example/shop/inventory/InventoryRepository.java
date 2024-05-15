package com.example.shop.inventory;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findByItemName(String itemName);
    void deleteByItemName(String itemName);
    List<Inventory> findAll(Specification<Inventory> spec);
}