package com.example.ProyectoClonicaOdontologica1;


import com.example.ProyectoClonicaOdontologica1.dto.DomicilioDTO;

import com.example.ProyectoClonicaOdontologica1.excepciones.BadRequestException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ResourceNotFoundException;

import com.example.ProyectoClonicaOdontologica1.service.IDomicilioService;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DomicilioServiceTest  {
    private static final Logger logger = Logger.getLogger(DomicilioServiceTest.class);

    @Autowired
    private IDomicilioService domicilioService;
    @Test
    public void testCrearDomicilio()throws BadRequestException, ResourceNotFoundException {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        logger.debug("Creando un domicilio desde el Test");
        domicilioDTO.setCalle("calle 55");
        domicilioDTO.setNumero("1421");
        domicilioDTO.setLocalidad("La Plata");
        domicilioDTO.setProvincia("Buenos Aires");
        domicilioService.crearDomicilio(domicilioDTO);
        Assert.assertNotNull(domicilioDTO);

    }
    @Test
    public void eliminarDomicilioTest()throws  ResourceNotFoundException{
        domicilioService.eliminarDomicilio(2L);

    }



}