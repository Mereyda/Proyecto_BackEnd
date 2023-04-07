package com.example.ProyectoClonicaOdontologica1.controller;

import com.example.ProyectoClonicaOdontologica1.dto.OdontologoDTO;
import com.example.ProyectoClonicaOdontologica1.excepciones.BadRequestException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ResourceNotFoundException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ServiceException;
import com.example.ProyectoClonicaOdontologica1.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@CrossOrigin
@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private IOdontologoService odontologoService;//lod controller necesitan conectarse con los service.
    @PostMapping
    public ResponseEntity <?> crearOdontologo (  @RequestBody OdontologoDTO odontologoDTO) throws BadRequestException {
        odontologoService.crearOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public OdontologoDTO getOdontologo (@PathVariable Long id) throws ResourceNotFoundException {
        return odontologoService.buscarOdontologoPorId(id);
    }


    @PutMapping
    public ResponseEntity<?> modificarOdontologo (@RequestBody OdontologoDTO odontologoDTO) throws BadRequestException {
        odontologoService.modificarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/all")
    public Collection<OdontologoDTO> getTodosLosOdontologos() throws ServiceException {
        return odontologoService.listarTodosLosOdontologos();
    }



}
