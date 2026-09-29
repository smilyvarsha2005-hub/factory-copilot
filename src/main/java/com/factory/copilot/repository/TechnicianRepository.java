package com.factory.copilot.repository;

import com.factory.copilot.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {

    Optional<Technician> findByEmployeeCode(String employeeCode);
}