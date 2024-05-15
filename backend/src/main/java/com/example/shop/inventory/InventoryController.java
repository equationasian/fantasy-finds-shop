package com.example.shop.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<Inventory> getInventory(@RequestParam(name = "tags", required = false) List<String> tags) {
        if (tags == null) {
            return inventoryService.getFiveItems();
        }

        return inventoryService.filterItems(tags);
    }

    @PostMapping
    public String addToInventory(@RequestBody Inventory item) {
        inventoryService.addItem(item);
        return "Successfully added item";
    }

    @PutMapping
    public String updateInventory(@RequestBody Inventory item) {
        inventoryService.updateItem(item);
        return "Successfully updated item";
    }
}
