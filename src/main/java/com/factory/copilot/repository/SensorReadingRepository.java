package com.factory.copilot.repository;

import com.factory.copilot.entity.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorReadingRepository
        extends JpaRepository<SensorReading, Long> {

    List<SensorReading> findByMachineId(Long machineId);
}