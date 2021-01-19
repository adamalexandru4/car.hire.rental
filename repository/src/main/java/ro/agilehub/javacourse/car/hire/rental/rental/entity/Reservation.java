package ro.agilehub.javacourse.car.hire.rental.rental.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.StatusEnumDO;

import java.time.OffsetDateTime;

@Data
@EqualsAndHashCode(of = "id")
@Document("reservations")
public class Reservation {

    @Id
    @Field("_id")
    private ObjectId id;

    private ObjectId userId;
    private ObjectId carId;

    private OffsetDateTime startDateTime;
    private OffsetDateTime endDateTime;
    private StatusEnumDO status;

    @CreatedBy
    private String          createdBy;
    @CreatedDate
    private DateTime createdAt;
    @LastModifiedBy
    private String          lastModifiedBy;
    @LastModifiedDate
    private DateTime        lastModifiedAt;

}
