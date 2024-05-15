package com.example.shop.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping
    public ResponseEntity<UserDetails> getUser(@RequestParam String email) {
        UserDetails user = loginService.getUser(email);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Token> verify(@RequestBody LoginUser user) {
        Token token = loginService.authenticate(user);
        return token != null ? ResponseEntity.ok(token) : ResponseEntity.notFound().build();
    }
}
