package ro.agilehub.javacourse.car.hire.rental.rental.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import ro.agilehub.javacourse.car.hire.rental.api.model.ErrorDTO;
import ro.agilehub.javacourse.car.hire.rental.rental.exceptions.BadRequestException;
import ro.agilehub.javacourse.car.hire.rental.rental.exceptions.NotFoundException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = { BadRequestException.class, HttpClientErrorException.BadRequest.class })
    protected ResponseEntity<?> handleBadRequest(Exception exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(exception.getMessage());
        errorDTO.setCode(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class )
    protected ResponseEntity<?> handleNotFound(Exception exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(exception.getMessage());
        errorDTO.setCode(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = HttpServerErrorException.InternalServerError.class )
    protected ResponseEntity<?> handleInternalServerError(Exception exception) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(exception.getMessage());
        errorDTO.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
