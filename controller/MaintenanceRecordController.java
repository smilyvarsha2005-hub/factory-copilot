package com.factory.copilot.controller;

import com.factory.copilot.entity.MaintenanceRecord;
import com.factory.copilot.repository.MaintenanceRecordRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance")
@CrossOrigin(origins = "*")
public class MaintenanceRecordController {

    private final MaintenanceRecordRepository repository;

    public MaintenanceRecordController(MaintenanceRecordRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MaintenanceRecord> getAllMaintenanceRecords() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceRecord> getMaintenanceById(
            @PathVariable Long id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/machine/{machineId}")
    public List<MaintenanceRecord> getMaintenanceByMachine(
            @PathVariable Long machineId) {

        return repository.findByMachineId(machineId);
    }

    @PostMapping
    public MaintenanceRecord createMaintenance(
            @RequestBody MaintenanceRecord maintenanceRecord) {

        return repository.save(maintenanceRecord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaintenance(
            @PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}