package com.userservice.restController;

import com.userservice.authen.UserPrincipal;
import com.userservice.entity.User;
import com.userservice.service.service;
import com.userservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private service service;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping
    public ResponseEntity<?> login(@RequestParam String userName, @RequestParam String password){
        System.out.println("123213");

        UserPrincipal userPrincipal= service.findByUsername(userName);
        System.out.println("adsad"+userPrincipal);

        if (null == userName) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Account or password is not valid!");
        }
        String token= jwtUtil.generateToken(userPrincipal);
        return ResponseEntity.ok(token);
    }
}
