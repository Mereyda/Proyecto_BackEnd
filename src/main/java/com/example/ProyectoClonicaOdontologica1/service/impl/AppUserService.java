package com.example.ProyectoClonicaOdontologica1.service.impl;

import com.example.ProyectoClonicaOdontologica1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {
    private final com.example.ProyectoClonicaOdontologica1.repository.UserRepository userRepository;
    @Autowired
    public AppUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String email)  {
//        return userRepository.findByEmail(email).get();
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow((() -> new UsernameNotFoundException("User email not found")));

    }
}
