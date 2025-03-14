package com.example.security;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserAuthController {

    private final UserAuthEntityService userAuthEntityService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/add")
    public UserAuthEntity addUser(@RequestBody UserAuthEntity userAuthEntity){

        userAuthEntity.setPassword(passwordEncoder.encode(userAuthEntity.getPassword()));

        userAuthEntityService.save(userAuthEntity);
        return  userAuthEntity;
    }

    @GetMapping
    public String hello(){
        return "hello Ariz";
    }



}
