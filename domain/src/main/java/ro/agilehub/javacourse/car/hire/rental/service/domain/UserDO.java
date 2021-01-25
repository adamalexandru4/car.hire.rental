package ro.agilehub.javacourse.car.hire.rental.service.domain;

import lombok.Data;

@Data
public class UserDO {
    private String id;
    private String username;
    private String firstname;
    private String lastname;
    private String countryOfResidence;
    private String driverLicense;
    private StatusEnumDO status;
}
