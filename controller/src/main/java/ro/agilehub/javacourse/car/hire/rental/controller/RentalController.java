package ro.agilehub.javacourse.car.hire.rental.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ro.agilehub.javacourse.car.hire.rental.api.model.*;
import ro.agilehub.javacourse.car.hire.rental.api.specification.RentApi;
import ro.agilehub.javacourse.car.hire.rental.controller.exceptions.BadRequestException;
import ro.agilehub.javacourse.car.hire.rental.controller.mapper.RentalMapperController;
import ro.agilehub.javacourse.car.hire.rental.controller.mapper.StatusMapperController;
import ro.agilehub.javacourse.car.hire.rental.service.RentalService;
import ro.agilehub.javacourse.car.hire.rental.service.domain.ReservationDO;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RentalController implements RentApi {

    private final RentalService rentalService;
    private final RentalMapperController rentalMapperController;
    private final StatusMapperController statusMapperController;

    @Override
    public ResponseEntity<ResourceCreatedDTO> createReservation(@Valid NewReservationDTO newReservationDTO) {

        ReservationDO reservation = rentalMapperController.mapToReservationDO(newReservationDTO);
        ResourceCreatedDTO resourceCreatedDTO = rentalMapperController.mapToResourceCreatedDTO(rentalService.createReservation(reservation));

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
                rentalService.getAllReservations(statusMapperController.toEnumDO(status))
                    .stream().map(rentalMapperController::mapToReservationDTO).collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<ReservationDTO> getReservationByID(String id) {
        return ResponseEntity.ok(rentalMapperController.mapToReservationDTO(rentalService.getReservation(id)));
    }

    @Override
    public ResponseEntity<ResponseDTO> updateReservationDetails(String id, @Valid List<PatchDocument> patchDocument) {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonPatch jsonPatch = objectMapper.convertValue(patchDocument, JsonPatch.class);

        ReservationDO reservation = rentalService.getReservation(id);
        try {
            JsonNode reservationPatch = jsonPatch.apply(objectMapper.convertValue(reservation, JsonNode.class));
            ReservationDO updatedReservation = objectMapper.treeToValue(reservationPatch, ReservationDO.class);

            if (!reservation.getId().equals(updatedReservation.getId())) {
                throw new BadRequestException("ID can't be changed");
            }

            rentalService.updateReservation(updatedReservation);
        } catch (JsonPatchException | JsonProcessingException e) {
            e.printStackTrace();
        }

        ResponseDTO response = new ResponseDTO();
        response.setMessage("Reservation updated successfully");

        return ResponseEntity.ok(response);
    }
}
