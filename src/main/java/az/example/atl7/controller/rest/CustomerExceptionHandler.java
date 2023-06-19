package az.example.atl7.controller.rest;

import az.example.atl7.exception.NotFoundException;
import az.example.atl7.model.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class CustomerExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto handler(NotFoundException exception) {
        log.error("ActionLog.handler.error not found exception {}", exception.getMessage());
        return new ExceptionDto(HttpStatus.NOT_FOUND.value(), exception.getMessage());
    }

//    @ExceptionHandler(Exception.class)
//    public ExceptionDto handler(Exception exception) {
//        log.error("ActionLog.handler.error unexpected exception {}", exception.getMessage());
//        return new ExceptionDto(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
//    }
}
