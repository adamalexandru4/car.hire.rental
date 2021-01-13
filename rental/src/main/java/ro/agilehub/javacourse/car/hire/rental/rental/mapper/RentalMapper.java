package ro.agilehub.javacourse.car.hire.rental.rental.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.agilehub.javacourse.car.hire.rental.api.model.NewReservationDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.ReservationDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.ResourceCreatedDTO;
import ro.agilehub.javacourse.car.hire.rental.rental.entity.Reservation;

@Mapper(componentModel = "spring", uses = { ObjectIdMapper.class, StatusMapper.class})
public interface RentalMapper {

    @Mapping(target = "id", source = "id")
    ResourceCreatedDTO mapEntityToResourceCreatedDTO(Reservation reservation);

    @Mapping(target = "userId", source = "userID")
    @Mapping(target = "carId", source = "carID")
    @Mapping(target = "id", ignore = true)
    Reservation mapDTOToEntity(NewReservationDTO newReservation);


    @Mapping(target = "userID", source = "reservation.userId")
    @Mapping(target = "carID", source = "reservation.carId")
    ReservationDTO mapEntityToDTO(Reservation reservation);
}
