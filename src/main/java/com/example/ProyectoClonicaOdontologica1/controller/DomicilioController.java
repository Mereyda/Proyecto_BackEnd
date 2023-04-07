package com.example.ProyectoClonicaOdontologica1.controller;

import com.example.ProyectoClonicaOdontologica1.dto.DomicilioDTO;
import com.example.ProyectoClonicaOdontologica1.dto.OdontologoDTO;
import com.example.ProyectoClonicaOdontologica1.excepciones.BadRequestException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ResourceNotFoundException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ServiceException;
import com.example.ProyectoClonicaOdontologica1.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/domicilios")
public class DomicilioController {
    @Autowired
    private IDomicilioService domicilioService;
    @PostMapping
    public ResponseEntity<?> crearDomicilio(@RequestBody DomicilioDTO domicilioDTO) throws BadRequestException {
        domicilioService.crearDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public DomicilioDTO getDomicilio(@PathVariable Long id) throws ResourceNotFoundException {
        return domicilioService.buscarDomicilioPorId(id);
    }
    @PutMapping
    public ResponseEntity<?> modificarDomicilio (@RequestBody DomicilioDTO domicilioDTO) throws BadRequestException {
        domicilioService.modificarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id) throws ResourceNotFoundException {
        domicilioService.eliminarDomicilio(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/all")
    public Collection<DomicilioDTO> getTodosLosDomicilios() throws ServiceException {
        return domicilioService.buscarTodosLosDomicilios();
    }




}
