/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntt.service;

import com.ntt.pojo.Comment;
import com.ntt.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author TaiNguyen
 */
public interface ProductService {
    List<Product> getProducts(Map<String, String> params, int page);
    int countProduct();
    boolean deleteProduct(int productId);
    boolean addProduct(Product p);
    Product getProductById(int productId);
    List<Comment> getComments(int productId);
    Comment addComment(String content, int productId);
}
