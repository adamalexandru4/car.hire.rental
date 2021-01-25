package ro.agilehub.javacourse.car.hire.rental.repository.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.rental.repository.entity.Reservation;
import ro.agilehub.javacourse.car.hire.rental.service.domain.ReservationDO;

@Mapper(componentModel = "spring", uses = { ObjectIdMapper.class})
public interface RentalMapperRepository {

    Reservation mapToEntity(ReservationDO newReservation);

    ReservationDO mapToDO(Reservation reservation);
}
