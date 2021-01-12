package ro.agilehub.javacourse.car.hire.rental.rental.service.impl;

import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.rental.api.model.NewReservationDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.ResourceCreatedDTO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.RentalService;

@Service
public class RentalServiceImpl implements RentalService {

    @Override
    public ResourceCreatedDTO createReservation(NewReservationDTO newReservationDTO) {
        return null;
    }
}
