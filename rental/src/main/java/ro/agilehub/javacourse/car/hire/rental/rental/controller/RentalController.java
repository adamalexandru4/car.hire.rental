package ro.agilehub.javacourse.car.hire.rental.rental.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.agilehub.javacourse.car.hire.rental.api.model.*;
import ro.agilehub.javacourse.car.hire.rental.api.specification.RentApi;
import ro.agilehub.javacourse.car.hire.rental.rental.entity.Reservation;
import ro.agilehub.javacourse.car.hire.rental.rental.mapper.RentalMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.service.RentalService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RentalController implements RentApi {

    private final RentalService rentalService;
    private final RentalMapper rentalMapper;

    @Override
    public ResponseEntity<ResourceCreatedDTO> createReservation(@Valid NewReservationDTO newReservationDTO) {

        Reservation reservation = rentalMapper.mapDTOToEntity(newReservationDTO);
        ResourceCreatedDTO resourceCreatedDTO = rentalMapper.mapEntityToResourceCreatedDTO(rentalService.createReservation(reservation));

        return new ResponseEntity<>(resourceCreatedDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseDTO> deleteReservation(String id) {
        rentalService.deleteReservation(id);

        ResponseDTO response = new ResponseDTO();
        response.setMessage("Reservation deleted successfully");

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<ReservationDTO>> getAllReservations(@Valid StatusEnum status) {
        return ResponseEntity.ok(
                rentalService.getAllReservations(status)
                    .stream().map(rentalMapper::mapEntityToDTO).collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<ReservationDTO> getReservationByID(String id) {
        return ResponseEntity.ok(rentalMapper.mapEntityToDTO(rentalService.getReservation(id)));
    }

    @Override
    public ResponseEntity<ResponseDTO> updateReservationDetails(String id, @Valid List<PatchDocument> patchDocument) {
        rentalService.updateReservation(id, patchDocument);

        ResponseDTO response = new ResponseDTO();
        response.setMessage("Reservation updated successfully");

        return ResponseEntity.ok(response);
    }
}
