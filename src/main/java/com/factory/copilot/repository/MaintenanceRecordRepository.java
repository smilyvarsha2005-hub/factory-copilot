package com.factory.copilot.repository;

import com.factory.copilot.entity.MaintenanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaintenanceRecordRepository
        extends JpaRepository<MaintenanceRecord, Long> {

    List<MaintenanceRecord> findByMachineId(Long machineId);
}