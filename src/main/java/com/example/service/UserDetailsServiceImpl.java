package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.models.User;
 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Value("${email}")
    private String emailUser;
    @Value("${password}")
    private String password;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
 
        if (!emailUser.equals(email)) {
            throw new UsernameNotFoundException("User " + email + " was not found in the database");
        }
 
        User user = new User((long)1, emailUser, password);
        
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
        grantList.add(authority);

        UserDetails userDetails = 
        		(UserDetails) new org.springframework.security.core.userdetails.User(user.getEmail(), 
                user.getPassword(), grantList);
 
        return userDetails;
    }
 
}