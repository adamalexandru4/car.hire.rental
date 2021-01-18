package ro.agilehub.javacourse.car.hire.rental.client.core.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarClassEnum;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.CarClassEnumDO;

@Mapper(componentModel = "spring")
public interface CarClassMapper {

     default CarClassEnum toEnum(CarClassEnumDO value) {
        if (value == null) {
            return null;
        }
        return CarClassEnum.valueOf(value.toString());
    }

    default CarClassEnumDO toEnum(CarClassEnum enumValue) {
        if (enumValue == null) {
            return null;
        }
        return CarClassEnumDO.valueOf(enumValue.toString());
    }
}
