package com.pichincha.mvc.repository;

import com.pichincha.mvc.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByCarPlate(String carPlate);

    Optional<Vehicle> findByIdAndCarPlate(Long id, String carPlate);

    @Query(value = "SELECT * FROM vehicle v WHERE v.car_plate = ?1",
            nativeQuery = true)
    Optional<Vehicle> getCarByCarPlate(String carPlate);
}
