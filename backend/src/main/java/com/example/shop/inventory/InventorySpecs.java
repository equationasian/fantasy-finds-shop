package com.example.shop.inventory;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class InventorySpecs {
    public static Specification<Inventory> hasAllTags(List<String> tags) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.isMember(tags.get(0), root.get("tags")));

            for (int i = 1; i < tags.size(); ++i) {
                predicates.add(criteriaBuilder.isMember(tags.get(i), root.get("tags")));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
