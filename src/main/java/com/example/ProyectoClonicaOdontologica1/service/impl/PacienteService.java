package com.example.ProyectoClonicaOdontologica1.service.impl;

import com.example.ProyectoClonicaOdontologica1.model.Paciente;
import com.example.ProyectoClonicaOdontologica1.dto.PacienteDTO;
import com.example.ProyectoClonicaOdontologica1.excepciones.BadRequestException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ResourceNotFoundException;
import com.example.ProyectoClonicaOdontologica1.repository.IPacienteRepository;
import com.example.ProyectoClonicaOdontologica1.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class PacienteService implements IPacienteService {
    private final Logger logger = Logger.getLogger(PacienteService.class);

    @Autowired
    private IPacienteRepository pacienteRepository;
    @Autowired
    ObjectMapper mapper;

    public PacienteService(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public void crearPaciente(PacienteDTO pacienteDTO)throws BadRequestException {
        if (pacienteDTO == null){
            throw new BadRequestException("El paciente que está intentando crear es nulo.");
        } else {
            logger.debug("CREANDO UN PACIENTE....");
            guardarPaciente(pacienteDTO);
        }

    }

    @Override
    public PacienteDTO buscarPacientePorId(Long id) throws ResourceNotFoundException {
        logger.debug("BUSCANDO PACIENTE CON ID: " + id);
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isPresent()){
            return mapper.convertValue(paciente, PacienteDTO.class);
        } else {
            throw new ResourceNotFoundException("El paciente con id: " + id + " no existe.");
        }
    }

    private void guardarPaciente(PacienteDTO pacienteDTO){
        logger.debug("GUARDANDO UN PACIENTE");
        Paciente paciente = mapper.convertValue(pacienteDTO,Paciente.class);
        pacienteRepository.save(paciente);

    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) throws BadRequestException {
        if (pacienteDTO.getId() == null) {
            throw new BadRequestException("El paciente que está intentando modificar no existe.");
        } else {
            logger.debug("MODOFICANDO UN PACIENTE");
            guardarPaciente(pacienteDTO);
        }
    }

    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        if (pacienteRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("No existe un paciente con id: " + id);
        } else {
            logger.debug("Eliminando el paciente con id: " + id);
            pacienteRepository.delete(pacienteRepository.findById(id).get());
        }
    }

    @Override
    public Set<PacienteDTO> listarTodosLosPacientes() throws ServiceException {
        List<Paciente> pacientes = pacienteRepository.findAll();

        if (pacientes.isEmpty()){
            throw new ServiceException("No hay pacientes para listar.");
        } else {
            Set<PacienteDTO> pacientesDTO = new HashSet<>();
            for (Paciente paciente : pacientes){
                pacientesDTO.add(mapper.convertValue(paciente,PacienteDTO.class));
            }
            logger.debug("Listando todos los pacientes");
            return pacientesDTO;
        }
    }

}
