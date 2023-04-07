package com.example.ProyectoClonicaOdontologica1.repository;

import com.example.ProyectoClonicaOdontologica1.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio, Long> {

}
