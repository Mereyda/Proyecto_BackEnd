package com.example.ProyectoClonicaOdontologica1.repository;

import com.example.ProyectoClonicaOdontologica1.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {
//    @Query("from Odontologo o where o.apellido like %:apellido%")
//    Set<Odontologo> getOdontologoPorMatricula(@Param("matricula") int matrcula);


}
