package ro.agilehub.javacourse.car.hire.rental.client.core.impl;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;

import java.util.NoSuchElementException;

@FeignClient(name = "user", url = "http://localhost:8080")
public interface UserApiClient extends UserApi {

    String CORE = "core";
    String CORE_FALLBACK = "coreFallback";

    @Override
    @CircuitBreaker(name = CORE, fallbackMethod = CORE_FALLBACK)
    @RateLimiter(name = CORE)
    @GetMapping(value = "/user/{id}")
    ResponseEntity<UserDTO> getUserByID(@PathVariable("id") String id);

    default ResponseEntity<UserDTO> coreFallback(String id, CallNotPermittedException callNotPermittedException) {
        throw new NoSuchElementException();
    }

    default ResponseEntity<UserDTO> coreFallback(String id, Exception exception) {
        return ResponseEntity.ok(new UserDTO());
    }
}