package ro.agilehub.javacourse.car.hire.rental.rental.controller.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.rental.api.model.NewReservationDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.ReservationDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.ResourceCreatedDTO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.ReservationDO;

@Mapper(componentModel = "spring", uses = {StatusMapper.class})
public interface RentalMapper {

    ResourceCreatedDTO mapToResourceCreatedDTO(ReservationDO reservation);

    ReservationDO mapToReservationDO(NewReservationDTO newReservation);

    ReservationDTO mapToReservationDTO(ReservationDO reservation);
}
