package com.factory.copilot.controller;

import com.factory.copilot.entity.Technician;
import com.factory.copilot.repository.TechnicianRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technicians")
@CrossOrigin(origins = "*")
public class TechnicianController {

    private final TechnicianRepository repository;

    public TechnicianController(TechnicianRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Technician> getAllTechnicians() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Technician> getTechnicianById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Technician createTechnician(@RequestBody Technician technician) {
        return repository.save(technician);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Technician> updateTechnician(
            @PathVariable Long id,
            @RequestBody Technician updatedTechnician) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setName(updatedTechnician.getName());
                    existing.setEmployeeCode(updatedTechnician.getEmployeeCode());
                    existing.setRole(updatedTechnician.getRole());
                    existing.setEmail(updatedTechnician.getEmail());
                    existing.setPhone(updatedTechnician.getPhone());

                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnician(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}