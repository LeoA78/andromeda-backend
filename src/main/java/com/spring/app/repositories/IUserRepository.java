package com.spring.app.repositories;

import com.spring.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByToken (String token);

}
