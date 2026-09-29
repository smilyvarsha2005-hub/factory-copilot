package com.factory.copilot.config;

import com.factory.copilot.entity.Machine;
import com.factory.copilot.entity.MachineStatus;
import com.factory.copilot.entity.Technician;
import com.factory.copilot.repository.MachineRepository;
import com.factory.copilot.repository.TechnicianRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedData(
            MachineRepository machineRepository,
            TechnicianRepository technicianRepository) {

        return args -> {

            // =========================
            // SEED MACHINES
            // =========================

            if (machineRepository.count() == 0) {

                machineRepository.save(new Machine(
                        "PRESS-2018",
                        "Hydraulic Press",
                        "HP-800-2018",
                        "Line 1",
                        "Pressing Area",
                        MachineStatus.WARNING,
                        72.0,
                        68.0,
                        8.4,
                        8421L
                ));

                machineRepository.save(new Machine(
                        "CNC-204",
                        "CNC Machine",
                        "MX-204",
                        "Line 2",
                        "Machining Area",
                        MachineStatus.RUNNING,
                        58.0,
                        52.0,
                        2.4,
                        4120L
                ));

                machineRepository.save(new Machine(
                        "CONVEYOR-12",
                        "Transfer Conveyor",
                        "BC-12",
                        "Line 2",
                        "Transfer Area",
                        MachineStatus.WARNING,
                        44.0,
                        74.0,
                        5.6,
                        15230L
                ));

                machineRepository.save(new Machine(
                        "MILL-301",
                        "Industrial Mill",
                        "GM-301",
                        "Line 3",
                        "Milling Area",
                        MachineStatus.CRITICAL,
                        91.0,
                        41.0,
                        11.2,
                        22890L
                ));

                machineRepository.save(new Machine(
                        "PACKAGING-07",
                        "Packaging Machine",
                        "PK-07",
                        "Line 4",
                        "Packaging Area",
                        MachineStatus.RUNNING,
                        36.0,
                        48.0,
                        1.8,
                        2310L
                ));

                System.out.println("========================================");
                System.out.println("Factory machines seeded successfully!");
                System.out.println("Total machines: " + machineRepository.count());
                System.out.println("========================================");
            }


            // =========================
            // SEED TECHNICIANS
            // =========================

            if (technicianRepository.count() == 0) {

                technicianRepository.save(new Technician(
                        "Ravi Kumar",
                        "TECH-001",
                        "TECHNICIAN",
                        "ravi@factory.com",
                        "9000000001"
                ));

                technicianRepository.save(new Technician(
                        "Varsha",
                        "ENG-001",
                        "SENIOR_ENGINEER",
                        "varsha@factory.com",
                        "9000000002"
                ));

                technicianRepository.save(new Technician(
                        "Meera",
                        "OP-001",
                        "OPERATOR",
                        "meera@factory.com",
                        "9000000003"
                ));

                technicianRepository.save(new Technician(
                        "Arun",
                        "SUP-001",
                        "SUPERVISOR",
                        "arun@factory.com",
                        "9000000004"
                ));

                System.out.println("========================================");
                System.out.println("Factory technicians seeded successfully!");
                System.out.println("Total technicians: "
                        + technicianRepository.count());
                System.out.println("========================================");
            }
        };
    }
}