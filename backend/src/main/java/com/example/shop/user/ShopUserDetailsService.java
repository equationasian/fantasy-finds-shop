package com.example.shop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ShopUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ShopUser user = userRepository.findByEmail(username).orElseThrow();

        return new ShopUserDetails(user);
    }

    public void registerUser(ShopUser newUser) {
        boolean userExists = userRepository.findByEmail(newUser.getEmail()).isPresent();
        if (userExists) {
            throw new IllegalStateException("Email already exists");
        }

        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);

        userRepository.save(newUser);
    }
}
