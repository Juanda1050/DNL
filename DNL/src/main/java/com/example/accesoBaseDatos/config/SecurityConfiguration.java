/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.accesoBaseDatos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author JAR
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration
  extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) 
      throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("jar")
          .password("1")
          .roles("ADMIN");
    }
 
    @Override
    protected void configure(HttpSecurity http) 
      throws Exception {
        http
          .csrf().disable()
          .authorizeRequests()
//          .anyRequest()
//          .authenticated()
          .antMatchers("/admin/**").hasRole("ADMIN")
          .antMatchers("/anonymous*").anonymous()
          .antMatchers("/login*").permitAll()
          .antMatchers("/js/**").permitAll()
          .antMatchers("/css/**").permitAll()
          .and()
          .formLogin()
          .loginPage("/login.html")
          .loginProcessingUrl("/perform_login")
          .defaultSuccessUrl("/home.html", true)
          .failureUrl("/login.html?error=true")
//          .failureHandler(authenticationFailureHandler())
          .and()
          .logout()
//          .logoutUrl("/perform_logout")
          .deleteCookies("JSESSIONID");
        
    }
        
}