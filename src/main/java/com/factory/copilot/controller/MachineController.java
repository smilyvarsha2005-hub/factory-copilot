package com.factory.copilot.controller;

import com.factory.copilot.entity.Machine;
import com.factory.copilot.repository.MachineRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/machines")
@CrossOrigin(origins = "*")
public class MachineController {

    private final MachineRepository repository;

    public MachineController(MachineRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Machine> getAllMachines() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Machine> getMachineById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/code/{machineCode}")
    public ResponseEntity<Machine> getMachineByCode(@PathVariable String machineCode) {
        return repository.findByMachineCode(machineCode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Machine createMachine(@RequestBody Machine machine) {
        return repository.save(machine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Machine> updateMachine(
            @PathVariable Long id,
            @RequestBody Machine updatedMachine) {

        return repository.findById(id)
                .map(existing -> {
                    existing.setMachineCode(updatedMachine.getMachineCode());
                    existing.setMachineName(updatedMachine.getMachineName());
                    existing.setModel(updatedMachine.getModel());
                    existing.setProductionLine(updatedMachine.getProductionLine());
                    existing.setLocation(updatedMachine.getLocation());
                    existing.setStatus(updatedMachine.getStatus());
                    existing.setTemperature(updatedMachine.getTemperature());
                    existing.setHumidity(updatedMachine.getHumidity());
                    existing.setVibration(updatedMachine.getVibration());
                    existing.setOperatingHours(updatedMachine.getOperatingHours());

                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMachine(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}