package com.example.ProyectoClonicaOdontologica1.service.impl;

import com.example.ProyectoClonicaOdontologica1.dto.TurnoDTO;
import com.example.ProyectoClonicaOdontologica1.excepciones.BadRequestException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ResourceNotFoundException;

import com.example.ProyectoClonicaOdontologica1.model.Turno;

import com.example.ProyectoClonicaOdontologica1.repository.ITurnoRepository;
import com.example.ProyectoClonicaOdontologica1.service.ITurnoService;
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
public class TurnoService implements ITurnoService {
    private final Logger logger = Logger.getLogger(TurnoService.class);
    @Autowired
    private ITurnoRepository turnoRepository;
    @Autowired
    ObjectMapper mapper;

    public TurnoService(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public void crearTurno(TurnoDTO turnoDTO) throws BadRequestException {
        if(turnoDTO == null){
            throw new BadRequestException("El turno que  intenta crear es nulo");
        }else{
            logger.debug("CREANDO UN TURNO....");
            Turno turno = mapper.convertValue(turnoDTO,Turno.class);
            turnoRepository.save(turno);
        }

    }

    @Override
    public TurnoDTO buscarTurnoPorID(Long id) throws ResourceNotFoundException {
         logger.debug("BUSCANDO UN TURNO CON ID: " + id);
        Optional<Turno> turno = turnoRepository.findById(id);
        if(turno.isPresent()){
            return mapper.convertValue(turno, TurnoDTO.class);
        } else {
            throw new ResourceNotFoundException("El TURNO con id: " + id + " no existe.");
        }
    }
    private void guardarTurno(TurnoDTO turnoDTO){
        logger.debug("GUARDANDO UN DOMICILIO");
        Turno turno = mapper.convertValue(turnoDTO,Turno.class);
        turnoRepository.save(turno);

    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) throws BadRequestException {
        if (turnoDTO.getId() == null) {
            throw new BadRequestException("El turno que está intentando modificar no existe.");
        } else {
            logger.debug("MODOFICANDO UN TURNO");
            guardarTurno(turnoDTO);
        }

    }

    @Override
    public void eliminarTurno(Long id) throws ResourceNotFoundException {
        if (turnoRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("No existe el turno con id: " + id);
        } else {
            logger.debug("Eliminando el domicilio con id: " + id);
            turnoRepository.delete(turnoRepository.findById(id).get());
        }

    }

    @Override
    public Set<TurnoDTO> buscarTodosLosTurnos() throws ServiceException {
        List<Turno> turnos = turnoRepository.findAll();

        if (turnos.isEmpty()){
            throw new ServiceException("No hay turnos para listar.");
        } else {
            Set<TurnoDTO> turnoDTO = new HashSet<>();
            for (Turno turno : turnos){
                turnoDTO.add(mapper.convertValue(turno,TurnoDTO.class));
            }
            logger.debug("Listando todos domicilios");
            return turnoDTO;
        }
    }
}
