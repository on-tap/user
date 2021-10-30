package com.userservice.reposiroty;

import com.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<User, Long> {

}
