package com.example.ProyectoClonicaOdontologica1.service;



import com.example.ProyectoClonicaOdontologica1.dto.DomicilioDTO;
import com.example.ProyectoClonicaOdontologica1.dto.TurnoDTO;
import com.example.ProyectoClonicaOdontologica1.excepciones.BadRequestException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ResourceNotFoundException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ServiceException;

import java.util.Set;

public interface ITurnoService {
    public void crearTurno(TurnoDTO turnoDTO) throws BadRequestException;
    TurnoDTO buscarTurnoPorID(Long id) throws ResourceNotFoundException;
    public void modificarTurno(TurnoDTO turnoDTO) throws BadRequestException;
    public void eliminarTurno(Long id) throws ResourceNotFoundException;
    Set<TurnoDTO> buscarTodosLosTurnos() throws ServiceException;



}
