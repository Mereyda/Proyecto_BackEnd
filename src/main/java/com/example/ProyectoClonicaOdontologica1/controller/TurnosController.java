package com.example.ProyectoClonicaOdontologica1.controller;


import com.example.ProyectoClonicaOdontologica1.dto.OdontologoDTO;
import com.example.ProyectoClonicaOdontologica1.dto.TurnoDTO;
import com.example.ProyectoClonicaOdontologica1.excepciones.BadRequestException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ResourceNotFoundException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ServiceException;
import com.example.ProyectoClonicaOdontologica1.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/turnos")
public class TurnosController {
    @Autowired
    private ITurnoService turnoService;
    @PostMapping
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO) throws BadRequestException {
        turnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public TurnoDTO getTurno(@PathVariable Long id) throws ResourceNotFoundException {
        return turnoService.buscarTurnoPorID(id);
    }
    @PutMapping
    public ResponseEntity<?> modificarTurno (@RequestBody TurnoDTO turnoDTO) throws BadRequestException {
        turnoService.modificarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/all")
    public Collection<TurnoDTO> getTodosLosTurnos() throws ServiceException {
        return turnoService.buscarTodosLosTurnos();

    }



}
