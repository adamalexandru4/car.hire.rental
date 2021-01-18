package ro.agilehub.javacourse.car.hire.rental.client.core.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.client.core.mapper.FleetDOMapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.FleetApi;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.CarDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.CarManager;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultFleetManager implements CarManager {

    private final FleetDOMapper fleetDOMapper;
    private final FleetApi fleetApi;

    @Override
    public Optional<CarDO> findByID(String id) {
        return Optional.ofNullable(fleetDOMapper.toCarDO(fleetApi.getCarByID(id).getBody()));
    }
}
