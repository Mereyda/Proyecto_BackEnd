package com.example.ProyectoClonicaOdontologica1.controller;

import com.example.ProyectoClonicaOdontologica1.dto.PacienteDTO;
import com.example.ProyectoClonicaOdontologica1.excepciones.BadRequestException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ResourceNotFoundException;
import com.example.ProyectoClonicaOdontologica1.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/pacientes")
public class PacienteControler {
    @Autowired
    private IPacienteService pacienteService;
    @PostMapping
    public ResponseEntity<?> crearPaciente (@RequestBody PacienteDTO pacienteDTO) throws BadRequestException {
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok("El paciente se ha creado exitosamente.");
    }
    @GetMapping("/{id}")
    public PacienteDTO buscarPacientePorId(@PathVariable Long id) throws ResourceNotFoundException {
        return pacienteService.buscarPacientePorId(id);
    }
    @GetMapping("/all")
    public Collection<PacienteDTO> listarTodosLosPacientes(){
        return pacienteService.listarTodosLosPacientes();
    }
    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO) throws BadRequestException {
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok("El paciente ha sido mofificado");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok("el paciente ha sido eliminado");
    }




}
