package com.apler.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Apler
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String phone;

    private String password;
    private String cookie;
    private String hhzPassword;
    private String uid;
    private String nickname;
}