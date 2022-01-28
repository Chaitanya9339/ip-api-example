package com.example.ipassignment;

import com.example.ipassignment.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        return ErrorResponse.builder().error(HttpStatus.BAD_REQUEST.toString()).errorCode(HttpStatus.BAD_REQUEST.value()).fieldErrors(
                ex.getBindingResult().getFieldErrors()
                        .stream()
                        .map((fieldError) ->
                                fieldError.getObjectName() + "." + fieldError.getField() + " : " + fieldError.getDefaultMessage() + " : rejected value [" + fieldError.getRejectedValue() + "]")
                        .collect(Collectors.toList())
        ).build();
    }

}