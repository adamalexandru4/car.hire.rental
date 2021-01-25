package ro.agilehub.javacourse.car.hire.rental.client.core.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.StatusEnum;
import ro.agilehub.javacourse.car.hire.rental.service.domain.StatusEnumDO;

@Mapper(componentModel = "spring")
public interface StatusMapperCore {

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
