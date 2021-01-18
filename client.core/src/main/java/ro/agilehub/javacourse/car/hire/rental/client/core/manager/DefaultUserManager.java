package ro.agilehub.javacourse.car.hire.rental.client.core.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.agilehub.javacourse.car.hire.rental.client.core.mapper.UserDOMapper;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;
import ro.agilehub.javacourse.car.hire.rental.rental.service.domain.UserDO;
import ro.agilehub.javacourse.car.hire.rental.rental.service.manager.UserManager;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultUserManager implements UserManager {

    private UserApi userApi;
    private UserDOMapper userDOMapper;

    @Override
    public Optional<UserDO> findByID(String id) {
        return Optional.ofNullable(userDOMapper.toUserDO(userApi.getUserByID(id).getBody()));
    }
}
