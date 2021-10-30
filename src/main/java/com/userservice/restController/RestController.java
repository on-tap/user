package com.userservice.restController;

import com.userservice.entity.Order;
import com.userservice.entity.User;
import com.userservice.entity.VO;
import com.userservice.reposiroty.Repository;
import com.userservice.service.service;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;



@org.springframework.web.bind.annotation.RestController
@RequestMapping("/user")
public class RestController {


    @Autowired
private service service;


    @GetMapping("/{id}")
    public VO getById(@PathVariable Long id){
        return service.getById(id);
    }


}
