package com.registerLogin.FirstMicroservice.service;

import com.registerLogin.FirstMicroservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface RegisterLoginService {

    void register(User user);
    User getUserByname(String userName);
    User getUserByemailId(String email);
}
