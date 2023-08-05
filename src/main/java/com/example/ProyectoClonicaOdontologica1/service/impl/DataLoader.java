package com.example.ProyectoClonicaOdontologica1.service.impl;

import com.example.ProyectoClonicaOdontologica1.model.AppUser;
import com.example.ProyectoClonicaOdontologica1.model.AppUserRoles;
import com.example.ProyectoClonicaOdontologica1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private final UserRepository userRepository;

    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("pas");

        BCryptPasswordEncoder passwordEncoder1 = new BCryptPasswordEncoder();
        String hashedPassword1 = passwordEncoder1.encode("p1");

        userRepository.save(new AppUser("mar","mar@gmail.com","pass",AppUserRoles.ADMIN));
        //userRepository.save(new AppUser("mere","garcia","garcia@gmail.com","garcia",AppUserRoles.ADMIN));

        //userRepository.save(new AppUser("pepa","pepa@gmail.com",hashedPassword,AppUserRoles.ADMIN));


    }
}
