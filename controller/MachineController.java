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

    private final MachineRepository machineRepository;

    public MachineController(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    // Get all machines
    @GetMapping
    public List<Machine> getAllMachines() {
        return machineRepository.findAll();
    }

    // Get one machine by ID
    @GetMapping("/{id}")
    public ResponseEntity<Machine> getMachineById(@PathVariable Long id) {
        return machineRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get machine by machine code
    @GetMapping("/code/{machineCode}")
    public ResponseEntity<Machine> getMachineByCode(
            @PathVariable String machineCode) {

        return machineRepository.findByMachineCode(machineCode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Add a new machine
    @PostMapping
    public Machine createMachine(@RequestBody Machine machine) {
        return machineRepository.save(machine);
    }

    // Update a machine
    @PutMapping("/{id}")
    public ResponseEntity<Machine> updateMachine(
            @PathVariable Long id,
            @RequestBody Machine updatedMachine) {

        return machineRepository.findById(id)
                .map(machine -> {

                    machine.setMachineCode(updatedMachine.getMachineCode());
                    machine.setMachineName(updatedMachine.getMachineName());
                    machine.setModel(updatedMachine.getModel());
                    machine.setProductionLine(updatedMachine.getProductionLine());
                    machine.setLocation(updatedMachine.getLocation());
                    machine.setStatus(updatedMachine.getStatus());
                    machine.setTemperature(updatedMachine.getTemperature());
                    machine.setHumidity(updatedMachine.getHumidity());
                    machine.setVibration(updatedMachine.getVibration());
                    machine.setOperatingHours(updatedMachine.getOperatingHours());

                    return ResponseEntity.ok(machineRepository.save(machine));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a machine
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMachine(@PathVariable Long id) {

        if (!machineRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        machineRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}