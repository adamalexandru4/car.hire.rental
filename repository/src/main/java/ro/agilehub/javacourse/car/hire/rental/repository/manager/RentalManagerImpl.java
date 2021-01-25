package ro.agilehub.javacourse.car.hire.rental.repository.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.repository.mapper.RentalMapperRepository;
import ro.agilehub.javacourse.car.hire.rental.repository.RentalRepository;
import ro.agilehub.javacourse.car.hire.rental.service.domain.ReservationDO;
import ro.agilehub.javacourse.car.hire.rental.service.manager.RentalManager;

@Component
@RequiredArgsConstructor
public class RentalManagerImpl implements RentalManager {

    private final RentalRepository rentalRepository;
    private final RentalMapperRepository rentalMapperRepository;

    @Override
    public ReservationDO save(ReservationDO reservationDO) {
        var reservation = rentalMapperRepository.mapToEntity(reservationDO);
        rentalRepository.save(reservation);

        return rentalMapperRepository.mapToDO(reservation);
    }
}
