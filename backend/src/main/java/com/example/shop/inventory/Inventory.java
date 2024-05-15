package com.example.shop.inventory;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "inventory")
@NoArgsConstructor
@Data
public class Inventory {
    @Id
    @GeneratedValue
    private Long id;
    private String itemName;
    private String seriesOrigin;
    private String imageUrl;
    @ElementCollection
    private List<String> tags;
    @Lob
    @Column(columnDefinition = "text")
    private String description;
    private double price;
    private int numInStock;
}