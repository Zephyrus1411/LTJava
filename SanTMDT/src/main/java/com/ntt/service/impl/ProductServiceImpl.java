/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntt.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ntt.pojo.Comment;
import com.ntt.pojo.Product;
import com.ntt.repository.ProductRepository;
import com.ntt.service.ProductService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TaiNguyen
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Product> getProducts(Map<String, String> params, int page) {
        return this.productRepository.getProducts(params, page);
    }

    @Override
    public int countProduct() {
        return this.productRepository.countProduct();
    }

    @Override
    public boolean deleteProduct(int productId) {
        return this.productRepository.deleteProduct(productId);
    }

    @Override
    public boolean addProduct(Product p) {
        try {
            Map r = this.cloudinary.uploader().upload(p.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            p.setImage((String) r.get("secure_url"));
            
            return this.productRepository.addProduct(p);
        } catch (IOException ex) {
            System.err.println("== ADD PRODUCT ==" + ex.getMessage());
        }
        return false;
    }
    
     @Override
    public Product getProductById(int productId) {
        return this.productRepository.getProductById(productId);
    }
    
    @Override
    public List<Comment> getComments(int productId) {
        return this.productRepository.getComments(productId);
    }
    
    @Override
    public Comment addComment(String content, int productId) {
        return this.productRepository.addComment(content, productId);
    }
}
