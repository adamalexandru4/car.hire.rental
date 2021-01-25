package ro.agilehub.javacourse.car.hire.rental.service.manager;

import ro.agilehub.javacourse.car.hire.rental.service.domain.UserDO;

import java.util.Optional;

public interface UserManager {

    /**
     * This method should throw a NoSuchElementException if no element was found
     * @param id
     * @return
     */
    Optional<UserDO> findByID(String id);
}
