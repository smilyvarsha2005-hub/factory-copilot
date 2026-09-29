package com.factory.copilot.repository;

import com.factory.copilot.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Long> {

    List<Incident> findByMachineId(Long machineId);

    List<Incident> findByTechnicianId(Long technicianId);
}