package ro.agilehub.javacourse.car.hire.rental.rental.service;

import ro.agilehub.javacourse.car.hire.rental.api.model.NewReservationDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.ResourceCreatedDTO;

public interface RentalService {

    ResourceCreatedDTO createReservation(NewReservationDTO newReservationDTO);
}
