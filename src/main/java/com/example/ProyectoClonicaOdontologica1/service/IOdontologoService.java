package com.example.ProyectoClonicaOdontologica1.service;

import com.example.ProyectoClonicaOdontologica1.dto.OdontologoDTO;
import com.example.ProyectoClonicaOdontologica1.excepciones.BadRequestException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ResourceNotFoundException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ServiceException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface IOdontologoService{
    public void crearOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException;
    public OdontologoDTO buscarOdontologoPorId(Long id) throws ResourceNotFoundException;
    public void modificarOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException;
   public void eliminarOdontologo(Long id) throws ResourceNotFoundException;
    Set<OdontologoDTO> listarTodosLosOdontologos() throws ServiceException;
//   Set<OdontologoDTO> getOdontologoPorMatricula(int matricula) throws ResourceNotFoundException;



}
