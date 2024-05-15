package com.example.shop.register;

import com.example.shop.config.JwtService;
import com.example.shop.user.ShopUserDetails;
import com.example.shop.user.ShopUserDetailsService;
import com.example.shop.user.ShopUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private ShopUserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    public String register(RegisterUser user) {
        ShopUser newUser = new ShopUser();
        newUser.setEmail(user.email());
        newUser.setPassword(user.password());
        newUser.setFirstName(user.firstName());
        newUser.setLastName(user.lastName());

        userDetailsService.registerUser(newUser);
        UserDetails registeredUser = userDetailsService.loadUserByUsername(newUser.getEmail());
        return jwtService.generateToken(registeredUser);
    }
}
