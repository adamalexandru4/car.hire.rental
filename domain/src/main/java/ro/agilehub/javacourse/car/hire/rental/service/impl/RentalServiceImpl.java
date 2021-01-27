package ro.agilehub.javacourse.car.hire.rental.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.rental.service.RentalService;
import ro.agilehub.javacourse.car.hire.rental.service.domain.ReservationDO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.StatusEnumDO;
import ro.agilehub.javacourse.car.hire.rental.service.exceptions.CustomException;
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
        var user = userManager.findByID(newReservation.getUserID())
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        var car = carManager.findByID(newReservation.getCarID())
                .orElseThrow(() -> new NoSuchElementException("Car not found"));

        if (car.getStatus() == StatusEnumDO.ACTIVE && user != null) {
            return rentalManager.save(newReservation);
        } else {
            throw new CustomException("Car is not available");
        }

    }

    @Override
    public void deleteReservation(String id) {

        ReservationDO reservation = getReservation(id);
        rentalManager.delete(reservation.getId());
    }

    @Override
    public List<ReservationDO> getAllReservations(StatusEnumDO status) {
        List<ReservationDO> reservations = null;

        if (status != null) {
            reservations = rentalManager.findAllByStatus(status);
        } else {
            reservations = rentalManager.findAll();
        }

        return reservations;
    }

    @Override
    public ReservationDO getReservation(String id) {
        return rentalManager.getById(id)
                .orElseThrow(() -> new NoSuchElementException("Reservation not found"));
    }

    @Override
    public void updateReservation(ReservationDO reservationDO) {
        rentalManager.save(reservationDO);
    }
}
