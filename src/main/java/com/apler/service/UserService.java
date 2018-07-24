package com.apler.service;

import com.apler.dao.UserDao;
import com.apler.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Apler
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

//    public Iterable<User> getAllUser(){
//        return userDao.findAll();
//    }

    public User getUser(String phone, String password){
        return userDao.findByPhoneAndPassword(phone, password);
    }
}
