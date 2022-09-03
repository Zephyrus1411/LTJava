/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntt.controllers;

import com.ntt.pojo.Cart;
import com.ntt.service.CategoryService;
import com.ntt.service.ProductService;
import com.ntt.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author TaiNguyen
 */
@Controller
@ControllerAdvice
public class IndexController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private Environment env;
    
    @ModelAttribute
    public void commonAttr(Model model, HttpSession session) {
         model.addAttribute("categories", this.categoryService.getCategories());
         model.addAttribute("cartCounter", Utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));
    } 
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {

       
        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("products", this.productService.getProducts(params, page));
        model.addAttribute("productCounter", this.productService.countProduct());
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));
        
        return "index";
    }
    
    @GetMapping("/products/{productId}")
    public String productDetails(Model model, @PathVariable(value = "productId") int id) {
        model.addAttribute("product", this.productService.getProductById(id));
        return "details";
    }
}

