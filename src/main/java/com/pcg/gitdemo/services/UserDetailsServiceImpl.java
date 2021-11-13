package com.pcg.gitdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pcg.gitdemo.repositories.UserRepository;
import com.pcg.gitdemo.models.User;
import com.pcg.gitdemo.models.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

   @Autowired
   private UserRepository userRepository;
    
   @Override
   public UserDetails loadUserByUsername(String username)
           throws UsernameNotFoundException {
       User user = userRepository.getUserByUsername(username);
        
       if (user == null) {
           throw new UsernameNotFoundException("Could not find user");
       }
        
       return new MyUserDetails(user);
   }

}