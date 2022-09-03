/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ntt.repository;

import com.ntt.pojo.Cart;
import com.ntt.pojo.Orderprd;
import com.ntt.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author TaiNguyen
 */
public interface OrderRepository {
    boolean addReceipt(Map<Integer, Cart> cart);
}
