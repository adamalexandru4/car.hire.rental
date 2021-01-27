package ro.agilehub.javacourse.car.hire.rental.service.manager;

import ro.agilehub.javacourse.car.hire.rental.service.domain.ReservationDO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.StatusEnumDO;

import java.util.List;
import java.util.Optional;

public interface RentalManager {

    ReservationDO save(ReservationDO reservation);

    void delete(String id);

    List<ReservationDO> findAllByStatus(StatusEnumDO statusEnumDO);

    List<ReservationDO> findAll();

    Optional<ReservationDO> getById(String id);
}
