package com.example.ProyectoClonicaOdontologica1.service;

import com.example.ProyectoClonicaOdontologica1.dto.DomicilioDTO;
import com.example.ProyectoClonicaOdontologica1.excepciones.BadRequestException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ResourceNotFoundException;

import java.util.Set;

public interface IDomicilioService {
    public void crearDomicilio(DomicilioDTO domicilioDTODTO) throws BadRequestException;
    DomicilioDTO buscarDomicilioPorId(Long id) throws ResourceNotFoundException;
    public void modificarDomicilio(DomicilioDTO domicilioDTO) throws BadRequestException;
    public void eliminarDomicilio(Long id) throws ResourceNotFoundException;
    Set<DomicilioDTO> buscarTodosLosDomicilios();
}
