package com.userservice.restController;

import com.userservice.entity.Order;
import com.userservice.entity.User;
import com.userservice.entity.VO;
import com.userservice.reposiroty.Repository;
import com.userservice.restTemplate.RestTemplateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/user")
public class RestController {

    @Autowired
    private Repository repository;

    @Autowired
    private RestTemplate restTemplateConfig;

    @GetMapping("/{id}")
    public VO getById(@PathVariable Long id){
        User user = repository.findById(id).get();

        Order order=  restTemplateConfig.getForObject("/"+user.getOrderID(),Order.class);

        return new VO(user,order);
    }
}
