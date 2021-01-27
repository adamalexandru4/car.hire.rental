package ro.agilehub.javacourse.car.hire.rental.repository.manager;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.repository.mapper.RentalMapperRepository;
import ro.agilehub.javacourse.car.hire.rental.repository.RentalRepository;
import ro.agilehub.javacourse.car.hire.rental.service.domain.ReservationDO;
import ro.agilehub.javacourse.car.hire.rental.service.domain.StatusEnumDO;
import ro.agilehub.javacourse.car.hire.rental.service.manager.RentalManager;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RentalManagerImpl implements RentalManager {

    private final RentalRepository rentalRepository;
    private final RentalMapperRepository rentalMapperRepository;

    @Override
    public ReservationDO save(ReservationDO reservationDO) {
        var reservation = rentalMapperRepository.mapToEntity(reservationDO);
        rentalRepository.save(reservation);

        return rentalMapperRepository.mapToDO(reservation);
    }

    @Override
    public void delete(String id) {
        ObjectId reservationId = new ObjectId(id);

        if (rentalRepository.existsById(reservationId)) {
            rentalRepository.deleteById(reservationId);
        }
    }

    @Override
    public List<ReservationDO> findAllByStatus(StatusEnumDO statusEnumDO) {
        return rentalRepository.findAllByStatus(statusEnumDO.getValue())
                .stream().map(rentalMapperRepository::mapToDO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservationDO> findAll() {
        return rentalRepository.findAll()
                .stream().map(rentalMapperRepository::mapToDO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ReservationDO> getById(String id) {
        return rentalRepository.findById(new ObjectId(id))
                .map(rentalMapperRepository::mapToDO);
    }
}
