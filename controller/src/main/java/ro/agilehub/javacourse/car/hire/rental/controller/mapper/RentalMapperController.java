package ro.agilehub.javacourse.car.hire.rental.controller.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.rental.api.model.NewReservationDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.ReservationDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.ResourceCreatedDTO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.ReservationDO;

@Mapper(componentModel = "spring", uses = {StatusMapperController.class})
public interface RentalMapperController {

    ResourceCreatedDTO mapToResourceCreatedDTO(ReservationDO reservation);

    ReservationDO mapToReservationDO(NewReservationDTO newReservation);

    ReservationDTO mapToReservationDTO(ReservationDO reservation);
}
