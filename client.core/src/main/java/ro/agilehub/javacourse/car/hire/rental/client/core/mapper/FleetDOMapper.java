package ro.agilehub.javacourse.car.hire.rental.client.core.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarDTO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.CarDO;

@Mapper(componentModel = "spring", uses = {StatusMapperCore.class, CarClassMapperCore.class})
public interface FleetDOMapper {

    CarDO toCarDO(CarDTO carDTO);

    CarDTO toCarDTO(CarDO carDO);
}
