package com.example.ProyectoClonicaOdontologica1;

import com.example.ProyectoClonicaOdontologica1.dto.PacienteDTO;
import com.example.ProyectoClonicaOdontologica1.excepciones.BadRequestException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ResourceNotFoundException;
import com.example.ProyectoClonicaOdontologica1.service.IPacienteService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PacienteServiceTest  {
    private static final Logger logger = Logger.getLogger(PacienteServiceTest.class);

    @Autowired
    private IPacienteService pacienteService;

    @Test
    public void testCrearPaciente() throws BadRequestException {

        PacienteDTO pacienteDTO = new PacienteDTO();
        logger.debug("Creando un Paciente desde el Test");
        pacienteDTO.setApellido("julia");
        pacienteDTO.setNombre("garcia");
        pacienteDTO.setDni("20124568");
       pacienteDTO.setFechaIngreso(new Date(122,12,02));
        pacienteDTO.setEmail("test4@gmail.com");


        pacienteService.crearPaciente(pacienteDTO);

        assertNotNull(pacienteDTO);


    }

    @Test
    void eliminarPaciente() throws ResourceNotFoundException {
        logger.debug("Eliminando un Paciente");
        pacienteService.eliminarPaciente(1L);

    }


}