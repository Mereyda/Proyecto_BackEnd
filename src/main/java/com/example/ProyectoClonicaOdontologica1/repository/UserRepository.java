package com.example.ProyectoClonicaOdontologica1.repository;

import com.example.ProyectoClonicaOdontologica1.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<AppUser, Long> {
    //metodo para buscar por email a los usuarios

    Optional<AppUser> findByEmail(String email);

}
