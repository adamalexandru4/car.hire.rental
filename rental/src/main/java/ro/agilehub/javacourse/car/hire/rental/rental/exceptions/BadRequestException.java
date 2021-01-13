package ro.agilehub.javacourse.car.hire.rental.rental.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
