package ro.agilehub.javacourse.car.hire.rental.service;

import ro.agilehub.javacourse.car.hire.rental.service.domain.PatchDocumentDO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.ReservationDO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.StatusEnumDO;

import java.util.List;

public interface RentalService {

    ReservationDO createReservation(ReservationDO newReservation);

    void deleteReservation(String id);

    List<ReservationDO> getAllReservations(StatusEnumDO status);

    ReservationDO getReservation(String id);

    void updateReservation(String id, List<PatchDocumentDO> patchDocuments);
}
