package com.ajay.app.repository;


import com.ajay.app.module.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Car findByRegistrationNumber(String parkingNumber);
}
