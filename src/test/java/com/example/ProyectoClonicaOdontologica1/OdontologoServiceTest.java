package com.example.ProyectoClonicaOdontologica1;

import com.example.ProyectoClonicaOdontologica1.dto.OdontologoDTO;
import com.example.ProyectoClonicaOdontologica1.excepciones.BadRequestException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ResourceNotFoundException;
import com.example.ProyectoClonicaOdontologica1.service.IOdontologoService;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OdontologoServiceTest {
    private static final Logger logger = Logger.getLogger(OdontologoServiceTest.class);

    @Autowired
    private IOdontologoService odontologoService;
    @Test
    public void testCrearOdontologo()throws BadRequestException, ResourceNotFoundException {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        logger.debug("Creando un Odontologo desde el Test");
        odontologoDTO.setApellido("cat");
        odontologoDTO.setNombre("bodi");
        odontologoDTO.setMatricula(1234);
        odontologoService.crearOdontologo(odontologoDTO);
        Assert.assertNotNull(odontologoDTO);

    }
//    @Test
//    public void eliminarOdontologoTest()throws  ResourceNotFoundException{
//        odontologoService.eliminarOdontologo(10L);
//
//    }


}