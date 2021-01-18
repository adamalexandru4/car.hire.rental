package ro.agilehub.javacourse.car.hire.rental.rental.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.rental.mapper.RentalMapper;
import ro.agilehub.javacourse.car.hire.rental.rental.repository.RentalRepository;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.ReservationDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.RentalManager;

@Component
@RequiredArgsConstructor
public class DefaultRentalManager implements RentalManager {

    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;

    @Override
    public ReservationDO save(ReservationDO reservationDO) {
        var reservation = rentalMapper.mapToEntity(reservationDO);
        rentalRepository.save(reservation);

        return rentalMapper.mapToDO(reservation);
    }
}
