package ro.agilehub.javacourse.car.hire.rental.service.manager;

import ro.agilehub.javacourse.car.hire.rental.service.domain.ReservationDO;

public interface RentalManager {

    ReservationDO save(ReservationDO reservation);
}
