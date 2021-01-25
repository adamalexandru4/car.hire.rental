package ro.agilehub.javacourse.car.hire.rental.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.agilehub.javacourse.car.hire.rental.repository.entity.Reservation;

import java.util.List;

@Repository
public interface RentalRepository extends MongoRepository<Reservation, ObjectId> {
    List<Reservation> getAllByStatus(String value);
}
