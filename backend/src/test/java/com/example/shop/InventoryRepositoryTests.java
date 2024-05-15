package com.example.shop;

import com.example.shop.inventory.Inventory;
import com.example.shop.inventory.InventoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class InventoryRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Test
    public void testCreateItem() {
        /*Inventory item = new Inventory();
        Set<Tag> itemTags = new HashSet<>();
        //Collections.addAll(itemTags, "clothing", "armor", "full body");

        item.setItemName("Berserker Armor");
        item.setImageUrl("placeholder");
        item.setTags(itemTags);
        item.setDescription("""
                Are you tired of limitations holding you back? Do you crave power beyond imagination? Look no further! The Berserker Armor from Berserk is your ultimate solution!
                                
                Imagine a suit of armor that doesn't just protect you, but empowers you to surpass your own limits. With the Berserker Armor, you'll tap into an unparalleled reservoir of strength, agility, and ferocity. Whether you're facing hordes of enemies or a single formidable foe, this armor will turn you into an unstoppable force of nature.
                                
                Here's what makes the Berserker Armor truly revolutionary:
                                
                Enhanced Strength: Crush your enemies with brute force as the Berserker Armor amplifies your physical abilities beyond human limits.
                                
                Unyielding Defense: Protect yourself from any onslaught with armor crafted to withstand the fiercest of attacks. No blade or spell can pierce its resilient surface.
                                
                Heightened Agility: Move with the speed and grace of a predator, darting through the battlefield with unparalleled agility. No opponent can keep up with your lightning-fast strikes.
                                
                Unleash Your Inner Beast: Tap into your primal instincts and unleash the berserker within. The Berserker Armor allows you to push past pain and exhaustion, transforming you into a relentless warrior fueled by pure rage.
                                
                Dominate Any Challenge: Whether you're facing demons, monsters, or rival warriors, the Berserker Armor ensures victory is within your grasp. No challenge is too great when you wield the power of this legendary armor.
                                
                Don't let anything hold you back any longer. Embrace the power of the Berserker Armor and become the unstoppable force you were always meant to be.
                """);
        item.setPrice(249.99);
        item.setNumInStock(3);

        Inventory savedItem = inventoryRepository.save(item);
        Inventory existingItem = entityManager.find(Inventory.class, savedItem.getId());
        assertThat(item.getItemName()).isEqualTo(existingItem.getItemName());*/
    }
}
