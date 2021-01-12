package ro.agilehub.javacourse.car.hire.rental.rental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.agilehub.javacourse.car.hire.rental.api.model.NewReservationDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.ResourceCreatedDTO;
import ro.agilehub.javacourse.car.hire.rental.api.specification.RentApi;
import ro.agilehub.javacourse.car.hire.rental.rental.mapper.RentalMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.service.RentalService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class RentalController implements RentApi {

    private final RentalService rentalService;
    private final RentalMapper rentalMapper;

    @Override
    public ResponseEntity<ResourceCreatedDTO> createReservation(@Valid NewReservationDTO newReservationDTO) {

//        NewReservation newReservation = rentalMapper

        return new ResponseEntity<>(rentalService.createReservation(newReservationDTO), HttpStatus.CREATED);
    }
}
