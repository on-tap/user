package com.userservice.restController;


import com.userservice.authen.UserPrincipal;
import com.userservice.entity.User;
import com.userservice.entity.VO;

import com.userservice.service.service;

import com.userservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/user")
public class RestController {


    @Autowired
private service service;

    @Autowired
    private JwtUtil jwtUtil;


    @GetMapping("/{id}")
    @Cacheable("phuoc")
    public VO getById(@PathVariable Long id){
        System.out.println(1);
        return service.getById(id);
    }


    @CacheEvict(value = "phuoc", allEntries = true)
    @GetMapping("/delete")
    public void clearCache() {
        System.out.println("daxoa");
    }






}
