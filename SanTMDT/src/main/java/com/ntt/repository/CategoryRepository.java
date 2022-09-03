/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntt.repository;

import com.ntt.pojo.Category;
import java.util.List;

/**
 *
 * @author TaiNguyen
 */
public interface CategoryRepository {
    List<Category> getCategories();
}
