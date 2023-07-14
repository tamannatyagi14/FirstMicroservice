package com.registerLogin.FirstMicroservice.dao;

import com.registerLogin.FirstMicroservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterLoginDao extends JpaRepository<User,Long> {
    public User findByName(String name);
    public User findByEmail(String email);
}
