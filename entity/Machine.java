package com.factory.copilot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "machines")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String machineCode;

    @Column(nullable = false)
    private String machineName;

    private String model;
    private String productionLine;
    private String location;

    @Enumerated(EnumType.STRING)
    private MachineStatus status;

    private Double temperature;
    private Double humidity;
    private Double vibration;
    private Long operatingHours;

    public Machine() {
    }

    public Machine(String machineCode, String machineName, String model,
                   String productionLine, String location,
                   MachineStatus status, Double temperature,
                   Double humidity, Double vibration, Long operatingHours) {

        this.machineCode = machineCode;
        this.machineName = machineName;
        this.model = model;
        this.productionLine = productionLine;
        this.location = location;
        this.status = status;
        this.temperature = temperature;
        this.humidity = humidity;
        this.vibration = vibration;
        this.operatingHours = operatingHours;
    }

    public Long getId() {
        return id;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProductionLine() {
        return productionLine;
    }

    public void setProductionLine(String productionLine) {
        this.productionLine = productionLine;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public MachineStatus getStatus() {
        return status;
    }

    public void setStatus(MachineStatus status) {
        this.status = status;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getVibration() {
        return vibration;
    }

    public void setVibration(Double vibration) {
        this.vibration = vibration;
    }

    public Long getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(Long operatingHours) {
        this.operatingHours = operatingHours;
    }
}