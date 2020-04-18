package com.example.mySpringBoot.controller.advice;

import com.example.mySpringBoot.controller.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * A controller advice allows to use exception handling techniques but apply them across the whole application,
 * not just to an individual controller. You can think of them as an annotation driven interceptor.
 */
@ControllerAdvice
public class EmployeeNotFoundAdvice {

    @ResponseBody                                       // @ResponseBody signals that this advice is rendered straight into the response body.
    @ExceptionHandler(EmployeeNotFoundException.class)  // @ExceptionHandler configures the advice to only respond if an EmployeeNotFoundException is thrown.
    @ResponseStatus(HttpStatus.NOT_FOUND)               // @ResponseStatus says to issue an HttpStatus.NOT_FOUND, i.e. an HTTP 404.
    String employeeNotFoundHandler(EmployeeNotFoundException ex){
        return ex.getMessage();
    }
}
