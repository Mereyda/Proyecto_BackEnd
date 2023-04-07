package com.example.ProyectoClonicaOdontologica1;



import com.example.ProyectoClonicaOdontologica1.dto.TurnoDTO;
import com.example.ProyectoClonicaOdontologica1.excepciones.BadRequestException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ResourceNotFoundException;

import com.example.ProyectoClonicaOdontologica1.service.ITurnoService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class TurnoServiceTest  {
    private static final Logger logger = Logger.getLogger(TurnoServiceTest.class);

    @Autowired
    private ITurnoService turnoService;
    @Test
    public void testCrearTurno()throws BadRequestException, ResourceNotFoundException {
        TurnoDTO turnoDTO = new TurnoDTO();
        logger.debug("Creando un turno desde el Test");
        turnoDTO.setFechaDeTurno(new Date(122,01,05));
//        turnoDTO.setHora("10:00:00");


        turnoService.crearTurno(turnoDTO);
        //Assert.assertNotNull(turnoDTO);

    }
//    @Test
//    public void eliminarTurnoTest()throws  ResourceNotFoundException{
//        turnoService.eliminarTurno(0L);
//
//    }

}