package com.registerLogin.FirstMicroservice.service.serviceImpl;

import com.registerLogin.FirstMicroservice.dao.RegisterLoginDao;
import com.registerLogin.FirstMicroservice.entity.User;
import com.registerLogin.FirstMicroservice.service.RegisterLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterLoginImpl implements RegisterLoginService {

    @Autowired
    private RegisterLoginDao registerLoginDao;
    @Override
    public void register(User user) {
        registerLoginDao.save(user);
    }

    @Override
    public User getUserByname(String userName) {
        return registerLoginDao.findByName(userName);
    }

    @Override
    public User getUserByemailId(String email) {
        return registerLoginDao.findByEmail(email);
    }
}
