package com.example.ProyectoClonicaOdontologica1.service.impl;


import com.example.ProyectoClonicaOdontologica1.dto.DomicilioDTO;
import com.example.ProyectoClonicaOdontologica1.dto.PacienteDTO;
import com.example.ProyectoClonicaOdontologica1.excepciones.BadRequestException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ResourceNotFoundException;
import com.example.ProyectoClonicaOdontologica1.model.Domicilio;
import com.example.ProyectoClonicaOdontologica1.model.Odontologo;
import com.example.ProyectoClonicaOdontologica1.model.Paciente;
import com.example.ProyectoClonicaOdontologica1.repository.IDomicilioRepository;
import com.example.ProyectoClonicaOdontologica1.repository.IOdontologoRepository;
import com.example.ProyectoClonicaOdontologica1.service.IDomicilioService;
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
public class DomicilioService implements IDomicilioService {
    private final Logger logger = Logger.getLogger(DomicilioService.class);
    @Autowired
    private IDomicilioRepository domicilioRepository;
    @Autowired
    ObjectMapper mapper;

    public DomicilioService(IDomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    @Override
    public void crearDomicilio(DomicilioDTO domicilioDTO) throws BadRequestException {
        if(domicilioDTO == null){
            throw new BadRequestException("El domicilio que se intenta crear es nulo");
        }else{
            logger.debug("CREANDO DOMICILIO....");
            Domicilio domicilio = mapper.convertValue(domicilioDTO,Domicilio.class);
            domicilioRepository.save(domicilio);
        }

    }

    @Override
    public DomicilioDTO buscarDomicilioPorId(Long id) throws ResourceNotFoundException {
        logger.debug("BUSCANDO PACIENTE CON ID: " + id);
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        if(domicilio.isPresent()){
            return mapper.convertValue(domicilio, DomicilioDTO.class);
        } else {
            throw new ResourceNotFoundException("El DOMICILIO con id: " + id + " no existe.");
        }
    }
    private void guardarDomicilio(DomicilioDTO domicilioDTO){
        logger.debug("GUARDANDO UN DOMICILIO");
        Domicilio domicilio = mapper.convertValue(domicilioDTO,Domicilio.class);
        domicilioRepository.save(domicilio);

    }

    @Override
    public void modificarDomicilio(DomicilioDTO domicilioDTO) throws BadRequestException {
        if (domicilioDTO.getId() == null) {
            throw new BadRequestException("El domicilio que está intentando modificar no existe.");
        } else {
            logger.debug("MODOFICANDO UN DOMICILIO");
            guardarDomicilio(domicilioDTO);
        }


    }

    @Override
    public void eliminarDomicilio(Long id) throws ResourceNotFoundException {
        if (domicilioRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("No existe un domicilio con id: " + id);
        } else {
            logger.debug("Eliminando el domicilio con id: " + id);
            domicilioRepository.delete(domicilioRepository.findById(id).get());
        }

    }

    @Override
    public Set<DomicilioDTO> buscarTodosLosDomicilios() {
        List<Domicilio> domicilios = domicilioRepository.findAll();

        if (domicilios.isEmpty()){
            throw new ServiceException("No hay domicilios para listar.");
        } else {
            Set<DomicilioDTO> domicilioDTO = new HashSet<>();
            for (Domicilio domicilio : domicilios){
                domicilioDTO.add(mapper.convertValue(domicilio,DomicilioDTO.class));
            }
            logger.debug("Listando todos domicilios");
            return domicilioDTO;
        }
    }
}
