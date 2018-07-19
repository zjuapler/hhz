package com.apler.dao;

import com.apler.entity.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserDao extends CrudRepository<User, Long> {
    @Query(value = "select * from user where phone = ?1", nativeQuery = true)
    User findByPhone(String phone);

    @Query(value = "select * from user where phone = ?1 and password = ?2", nativeQuery = true)
    User findByPhoneAndPassword(String phone, String password);
}