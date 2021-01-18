package ro.agilehub.javacourse.car.hire.rental.rental.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.rental.rental.entity.Reservation;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.ReservationDO;

@Mapper(componentModel = "spring", uses = { ObjectIdMapper.class})
public interface RentalMapper {

    Reservation mapToEntity(ReservationDO newReservation);

    ReservationDO mapToDO(Reservation reservation);
}
