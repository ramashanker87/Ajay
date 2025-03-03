package com.ajay.app.repository;

import com.ajay.app.module.ParkingStart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingStartRepository extends JpaRepository<ParkingStart, Integer> {
    ParkingStart findByParkingNo(String parkingNumber);
}
