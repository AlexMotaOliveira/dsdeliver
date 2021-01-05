package com.devsuperior.dsdeliver.exceptions.response;

import com.devsuperior.dsdeliver.exceptions.errors.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebHandlerResponse {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RestResponseError handleException(OrderNotFoundException e) {
        return RestResponseError.userNotFoundException(e.getMessage());
    }
}
