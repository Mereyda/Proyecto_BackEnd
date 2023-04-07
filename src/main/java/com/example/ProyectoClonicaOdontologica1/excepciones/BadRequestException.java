package com.example.ProyectoClonicaOdontologica1.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class BadRequestException extends Throwable {
    public BadRequestException(String message){
        super(message);
    }
}
