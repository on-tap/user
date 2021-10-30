package com.userservice.restController;


import com.userservice.entity.VO;

import com.userservice.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;





@org.springframework.web.bind.annotation.RestController
@RequestMapping("/user")
public class RestController {


    @Autowired
private service service;


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
