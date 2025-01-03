package com.company.services_reservas_app.config;

import com.company.service__reservas_app.transportlayers.openapi.model.ResponseClienteError;
import com.company.services_reservas_app.config.exceptions.ClienteError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdviceConfiguration {

    @ExceptionHandler(ClienteError.class)
    public ResponseEntity<ResponseClienteError> handleResponseError(ClienteError error) {
        ResponseClienteError errorResponse = new ResponseClienteError();
        errorResponse.setErrorCode(error.getCode());
        errorResponse.setMessage(error.getDescription());
        errorResponse.setStatus(error.getStatus());
        return ResponseEntity.status(HttpStatus.valueOf(Integer.valueOf(error.getStatus()))).body(errorResponse);
    }


}
