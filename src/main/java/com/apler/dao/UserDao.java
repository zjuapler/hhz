package com.apler.dao;

import com.apler.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

/**
 * @author Apler
 */
public interface UserDao extends CrudRepository<User, Long> {
    /**
     * @param phone
     * @return
     */
    @Query(value = "select * from user where phone = ?1", nativeQuery = true)
    User findByPhone(String phone);

    /**
     * @param phone
     * @param password
     * @return
     */
    @Query(value = "select * from user where phone = ?1 and password = ?2", nativeQuery = true)
    User findByPhoneAndPassword(String phone, String password);
}