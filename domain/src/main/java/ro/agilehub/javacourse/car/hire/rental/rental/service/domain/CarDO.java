package ro.agilehub.javacourse.car.hire.rental.rental.service.domain;

import lombok.Data;

@Data
public class CarDO {
    private String          id;
    private String          make;
    private String          model;
    private int             year;
    private int             mileage;
    private float           fuel;
    private CarClassEnumDO  carClass;
    private StatusEnumDO status;
}
