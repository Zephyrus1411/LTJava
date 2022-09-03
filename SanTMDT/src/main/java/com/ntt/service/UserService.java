/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ntt.service;

import com.ntt.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;
/**
 *
 * @author TaiNguyen
 */
public interface UserService extends UserDetailsService {
    boolean addUser(User user);
    User getUserByUsername(String username);
    User getUserById(int id);
}
