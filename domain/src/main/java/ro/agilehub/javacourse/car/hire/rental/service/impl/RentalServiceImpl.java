package ro.agilehub.javacourse.car.hire.rental.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.rental.service.RentalService;
import ro.agilehub.javacourse.car.hire.rental.service.domain.PatchDocumentDO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.ReservationDO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.StatusEnumDO;
import ro.agilehub.javacourse.car.hire.rental.service.manager.CarManager;
import ro.agilehub.javacourse.car.hire.rental.service.manager.RentalManager;
import ro.agilehub.javacourse.car.hire.rental.service.manager.UserManager;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final UserManager userManager;
    private final CarManager carManager;
    private final RentalManager rentalManager;

    @Override
    public ReservationDO createReservation(ReservationDO newReservation) {
        var user = userManager.findByID(newReservation.getUserId());
        var car = carManager.findByID(newReservation.getCarId());

        if (user.isPresent() && car.isPresent()) {
            return rentalManager.save(newReservation);
        }

        throw new NoSuchElementException();
    }

    @Override
    public void deleteReservation(String id) {

//        Reservation reservation = getReservation(id);
//        rentalRepository.delete(reservation);
    }

    @Override
    public List<ReservationDO> getAllReservations(StatusEnumDO status) {
        List<ReservationDO> reservations = null;

//        if (status != null) {
//            reservations = rentalRepository.getAllByStatus(status.getValue());
//        } else {
//            reservations = rentalRepository.findAll();
//        }

        return reservations;
    }

    @Override
    public ReservationDO getReservation(String id) {
//        return rentalRepository.findById(new ObjectId(id))
//                .orElseThrow(() -> new NotFoundException("Reservation not found"));

        return new ReservationDO();
    }

    @Override
    public void updateReservation(String id, List<PatchDocumentDO> patchDocuments) {
        // TODO: Patch
    }
}
