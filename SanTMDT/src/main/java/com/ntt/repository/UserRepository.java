/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ntt.repository;

import com.ntt.pojo.User;

/**
 *
 * @author TaiNguyen
 */
public interface UserRepository {
    boolean addUser(User user);
    User getUserByUsername(String username);
    User getUserById(int id);
}
