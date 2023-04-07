package com.example.ProyectoClonicaOdontologica1.service.impl;

import com.example.ProyectoClonicaOdontologica1.model.Odontologo;
import com.example.ProyectoClonicaOdontologica1.dto.OdontologoDTO;
import com.example.ProyectoClonicaOdontologica1.excepciones.BadRequestException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ResourceNotFoundException;
import com.example.ProyectoClonicaOdontologica1.excepciones.ServiceException;
import com.example.ProyectoClonicaOdontologica1.repository.IOdontologoRepository;
import com.example.ProyectoClonicaOdontologica1.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {
    private final Logger logger = Logger.getLogger(OdontologoService.class);

    @Autowired
    private IOdontologoRepository odontologoRepository;
    @Autowired
    ObjectMapper mapper;

    public OdontologoService(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException {
        if(odontologoDTO == null){
            throw new BadRequestException("El odontologo que se intenta crear es nulo");
        }else{
            logger.debug("CREANDO ODONTOLOGO....");
            Odontologo odontologo = mapper.convertValue(odontologoDTO,Odontologo.class);
            odontologoRepository.save(odontologo);
        }

    }
    @Override
    public OdontologoDTO buscarOdontologoPorId(Long id) throws ResourceNotFoundException {
        logger.debug("BUSCANDO ODONTOLOGO CON ID: " + id);
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        if(odontologo.isPresent()){
            return mapper.convertValue(odontologo,OdontologoDTO.class);
        }   else{
            throw new ResourceNotFoundException("El odontologo con id: " + id + " no existe en la base de datos.");
        }

    }
    private void guardarOdontologo(OdontologoDTO odontologoDTO) {
        logger.debug("GGUARDANO UN ODONTOLOGO");
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException {
        if (odontologoDTO.getId() == null){
            throw new BadRequestException("El odontologo que se intenta modificar no existe en la base de datos");
        } else{
            logger.debug("MODIFICANDO ODONTOLOGO");
//            Odontologo odontologo = mapper.convertValue(odontologoDTO,Odontologo.class);
//            odontologoRepository.save(odontologo);
            guardarOdontologo(odontologoDTO);
        }

    }

    @Override
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        if(odontologoRepository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("No se puede eliminar el odontologo con id: " + id + " , ya que no existe.");
        } else{
            logger.debug("ELIMINADO ODONTOLOGO CON ID: " + id);
            odontologoRepository.delete(odontologoRepository.findById(id).get());
        }

    }

    @Override
    public Set<OdontologoDTO> listarTodosLosOdontologos() throws ServiceException {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        if(odontologos.isEmpty()){
            throw new ServiceException("No hay ningun odontologo para listar");
        }else{
            Set <OdontologoDTO> odontologosDto = new HashSet<>();
            for(Odontologo odontologo : odontologos){
                odontologosDto.add(mapper.convertValue(odontologo,OdontologoDTO.class));
            }
            logger.debug("MOSTRANDO TODOS LOS ODONTOLOGOS");
            return odontologosDto;
        }

    }




}
