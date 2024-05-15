package com.example.shop.login;

import com.example.shop.config.JwtService;
import com.example.shop.user.ShopUser;
import com.example.shop.user.ShopUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private ShopUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public UserDetails getUser(String email) {
        return userDetailsService.loadUserByUsername(email);
    }

    public Token authenticate(LoginUser user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.email(), user.password()));
        UserDetails authenticatedUser = userDetailsService.loadUserByUsername(user.email());
        return new Token(jwtService.generateToken(authenticatedUser));
    }
}
