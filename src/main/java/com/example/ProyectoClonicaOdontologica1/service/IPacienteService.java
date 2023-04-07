package com.example.ProyectoClonicaOdontologica1.service;

import com.example.ProyectoClonicaOdontologica1.dto.PacienteDTO;
import com.example.ProyectoClonicaOdontologica1.excepciones.BadRequestException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ResourceNotFoundException;

import java.util.Set;

public interface IPacienteService {
    public void crearPaciente(PacienteDTO pacienteDTO) throws BadRequestException;
    PacienteDTO buscarPacientePorId(Long id) throws ResourceNotFoundException;
    public void modificarPaciente(PacienteDTO pacienteDTO) throws BadRequestException;
    public void eliminarPaciente(Long id) throws ResourceNotFoundException;
    Set<PacienteDTO> listarTodosLosPacientes();


}
