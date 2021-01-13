package ro.agilehub.javacourse.car.hire.rental.rental.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.agilehub.javacourse.car.hire.rental.api.model.NewReservationDTO;
import ro.agilehub.javacourse.car.hire.rental.api.model.ResourceCreatedDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.rental.service.RentalService;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {

    private final UserApi userApi;

    @Override
    public ResourceCreatedDTO createReservation(NewReservationDTO newReservationDTO) {
        var getUserResponseEntity = userApi.getUserByID("5ffedb0e70d4c67cbf157000");
        return new ResourceCreatedDTO().id(getUserResponseEntity.getBody().getId());
    }
}
