package ro.agilehub.javacourse.car.hire.rental.service.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;

@Data
@EqualsAndHashCode(of = "id")
public class ReservationDO {
    private String id;

    private String userID;
    private String carID;

    private OffsetDateTime startDateTime;
    private OffsetDateTime endDateTime;
    private StatusEnumDO status;
}
