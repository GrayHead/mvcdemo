package com.example.mvcdemo.dao;

import com.example.mvcdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@Service
@EnableJpaRepositories
public interface UserDAO extends JpaRepository<User, Integer> {
}
