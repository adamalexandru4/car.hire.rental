package ro.agilehub.javacourse.car.hire.rental.rental.controller.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.rental.api.model.StatusEnum;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.StatusEnumDO;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    default StatusEnumDO toEnumDO(StatusEnum value) {
        if (value == null) {
            return null;
        }
        return StatusEnumDO.valueOf(value.getValue());
    }

    default StatusEnum toEnum(StatusEnumDO enumValue) {
        if (enumValue == null) {
            return null;
        }
        return StatusEnum.valueOf(enumValue.toString());
    }
}
