package com.example.shop.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public void addItem(Inventory item) {
        if (itemExists(item.getItemName())) {
            throw new IllegalStateException("Item already exists");
        }

        inventoryRepository.save(item);
    }

    public void updateItem(Inventory updatedItem) {
        if (!itemExists(updatedItem.getItemName())) {
            throw new IllegalStateException("Item does not exist");
        }

        inventoryRepository.save(updatedItem);
    }

    public Inventory getItem(String itemName) {
        return inventoryRepository.findByItemName(itemName).orElseThrow();
    }

    public void deleteItem(String itemName) {
        if (!itemExists(itemName)) {
            throw new IllegalStateException("Item does not exist");
        }

        inventoryRepository.deleteByItemName(itemName);
    }

    public List<Inventory> getFiveItems() {
        Pageable fiveItems = PageRequest.of(0, 5);
        return inventoryRepository.findAll(fiveItems).getContent();
    }

    public List<Inventory> filterItems(List<String> tags) {
        return inventoryRepository.findAll(InventorySpecs.hasAllTags(tags));
    }

    public boolean itemExists(String name) {
        return inventoryRepository.findByItemName(name).isPresent();
    }
}