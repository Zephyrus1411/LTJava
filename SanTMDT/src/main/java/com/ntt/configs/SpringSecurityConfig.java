/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntt.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author TaiNguyen
 */
@Configuration
@EnableTransactionManagement
@EnableWebSecurity
@ComponentScan(basePackages = {
    "com.ntt.repository",
    "com.ntt.service",})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "zephyrus14",
                        "api_key", "214889978952169",
                        "api_secret", "QNGNp2GS7wU-EidhQJDPuYM98s0",
                        "secure", true));
        return cloudinary;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/")
                .failureUrl("/login?error");
        http.logout().logoutSuccessUrl("/login");
        
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/**/comments").authenticated()
                .antMatchers("/admin/**")
                .access("hasRole('ROLE_ADMIN')");

        http.csrf().disable();
    }
}