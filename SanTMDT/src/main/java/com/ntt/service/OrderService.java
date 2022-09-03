/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ntt.service;

import com.ntt.pojo.Cart;
import java.util.Map;

/**
 *
 * @author TaiNguyen
 */
public interface OrderService {
    boolean addReceipt(Map<Integer, Cart> cart);
}
