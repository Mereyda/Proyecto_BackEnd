package com.example.ProyectoClonicaOdontologica1.repository;

import com.example.ProyectoClonicaOdontologica1.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
   @Query("SELECT p FROM Paciente p WHERE p.email = ?1")
  Set<Paciente> buscarPacientePorEmail(@Param("email") String email);

}
