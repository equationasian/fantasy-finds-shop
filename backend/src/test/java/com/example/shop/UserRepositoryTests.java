package com.example.shop;

import com.example.shop.user.ShopUser;
import com.example.shop.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;

    @Test
    public void testCreateUser() {
        ShopUser user = new ShopUser();
        user.setEmail("myemail@gmail.com");
        user.setPassword("password");
        user.setFirstName("Test");
        user.setLastName("User");

        ShopUser savedUser = repo.save(user);
        ShopUser existUser = entityManager.find(ShopUser.class, savedUser.getId());
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
    }
}
