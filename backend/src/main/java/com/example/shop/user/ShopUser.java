package com.example.shop.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class ShopUser {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}