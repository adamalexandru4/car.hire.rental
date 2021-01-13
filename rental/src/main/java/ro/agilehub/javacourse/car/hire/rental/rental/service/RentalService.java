package ro.agilehub.javacourse.car.hire.rental.rental.service;

import ro.agilehub.javacourse.car.hire.rental.api.model.PatchDocument;
import ro.agilehub.javacourse.car.hire.rental.api.model.StatusEnum;
import ro.agilehub.javacourse.car.hire.rental.rental.entity.Reservation;

import java.util.List;

public interface RentalService {

    Reservation createReservation(Reservation newReservation);

    void deleteReservation(String id);

    List<Reservation> getAllReservations(StatusEnum status);

    Reservation getReservation(String id);

    void updateReservation(String id, List<PatchDocument> patchDocuments);
}
