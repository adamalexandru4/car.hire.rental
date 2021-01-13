package ro.agilehub.javacourse.car.hire.rental.rental.service.impl;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import ro.agilehub.javacourse.car.hire.rental.api.model.PatchDocument;
import ro.agilehub.javacourse.car.hire.rental.api.model.StatusEnum;
import ro.agilehub.javacourse.car.hire.rental.boot.exceptions.BadRequestException;
import ro.agilehub.javacourse.car.hire.rental.boot.exceptions.NotFoundException;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.rental.entity.Reservation;
import ro.agilehub.javacourse.car.hire.rental.rental.mapper.RentalMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.RentalRepository;
import ro.agilehub.javacourse.car.hire.rental.rental.service.RentalService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;
    private final UserApi userApi;

    @Override
    public Reservation createReservation(Reservation newReservation) {
        if (!userApi.getUserByID(newReservation.getUserId().toString()).getStatusCode().is2xxSuccessful()) {
            throw new BadRequestException("User not found");
        }

        return rentalRepository.save(newReservation);
    }

    @Override
    public void deleteReservation(String id) {

        Reservation reservation = rentalRepository.findById(new ObjectId(id))
                .orElseThrow(() -> new NotFoundException("Reservation not found"));

        rentalRepository.delete(reservation);
    }

    @Override
    public List<Reservation> getAllReservations(StatusEnum status) {
        List<Reservation> reservations = null;

        if (status != null) {
            reservations = rentalRepository.getAllByStatus(status.getValue());
        } else {
            reservations = rentalRepository.findAll();
        }

        return reservations;
    }

    @Override
    public Reservation getReservation(String id) {
        return rentalRepository.findById(new ObjectId(id))
                .orElseThrow(() -> new NotFoundException("Reservation not found"));
    }

    @Override
    public void updateReservation(String id, List<PatchDocument> patchDocuments) {
        // TODO: Patch
    }
}
