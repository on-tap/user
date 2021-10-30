package com.userservice.service;

import com.userservice.entity.Order;
import com.userservice.entity.User;
import com.userservice.entity.VO;
import com.userservice.reposiroty.Repository;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class service {

    @Autowired
    private Repository repository;
    @Autowired

    private RestTemplate restTemplateConfig;

//    @Retry(name = "basic",fallbackMethod = "getUserByIDFallBack")
//    @RateLimiter(name = "basic")
    @RateLimiter(name = "timeoutExample")
    public VO getById( Long id){

        User user = repository.findById(id).get();

        Order order=  restTemplateConfig.getForObject("/"+user.getOrderID(),Order.class);

        return new VO(user,order);
    }

    public VO getUserByIDFallBack( Long id,RuntimeException e){
        User user = repository.findById(id).get();
        VO vo= new VO();
        vo.setUser(user);
        return vo;
    }
}
