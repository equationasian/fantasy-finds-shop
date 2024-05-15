package com.example.shop.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody RegisterUser user) {
        String token = registerService.register(user);
        return ResponseEntity.ok(token);
    }
}
