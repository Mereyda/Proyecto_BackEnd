package com.example.ProyectoClonicaOdontologica1.repository;

import com.example.ProyectoClonicaOdontologica1.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
