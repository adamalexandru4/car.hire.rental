package ro.agilehub.javacourse.car.hire.rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ro.agilehub.javacourse.car.hire.rental"})
public class CarHireRentalApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CarHireRentalApplication.class, args);
    }
}
