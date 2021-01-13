package ro.agilehub.javacourse.car.hire.rental.rental.mapper;

import org.mapstruct.Mapper;
import ro.agilehub.javacourse.car.hire.rental.api.model.StatusEnum;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    default StatusEnum toEnum(String value) {
        if (value == null) {
            return null;
        }
        return StatusEnum.valueOf(value);
    }

    default String toEnum(StatusEnum enumValue) {
        if (enumValue == null) {
            return null;
        }
        return enumValue.getValue();
    }
}
