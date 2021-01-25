package ro.agilehub.javacourse.car.hire.rental.controller.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
