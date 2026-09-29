package com.factory.copilot.controller;

import com.factory.copilot.entity.Incident;
import com.factory.copilot.repository.IncidentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
@CrossOrigin(origins = "*")
public class IncidentController {

    private final IncidentRepository repository;

    public IncidentController(IncidentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Incident> getAllIncidents() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incident> getIncidentById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/machine/{machineId}")
    public List<Incident> getIncidentsByMachine(
            @PathVariable Long machineId) {
        return repository.findByMachineId(machineId);
    }

    @GetMapping("/technician/{technicianId}")
    public List<Incident> getIncidentsByTechnician(
            @PathVariable Long technicianId) {
        return repository.findByTechnicianId(technicianId);
    }

    @PostMapping
    public Incident createIncident(@RequestBody Incident incident) {
        return repository.save(incident);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncident(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}