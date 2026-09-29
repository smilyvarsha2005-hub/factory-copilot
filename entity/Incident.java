package com.factory.copilot.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "incidents")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "machine_id", nullable = false)
    private Machine machine;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    private Technician technician;

    @Enumerated(EnumType.STRING)
    private IncidentType type;

    @Enumerated(EnumType.STRING)
    private IncidentSeverity severity;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String resolution;

    private LocalDateTime reportedAt;

    private String memoryDocId;

    public Incident() {
    }

    public Incident(Machine machine,
                    Technician technician,
                    IncidentType type,
                    IncidentSeverity severity,
                    String description,
                    String resolution,
                    LocalDateTime reportedAt,
                    String memoryDocId) {

        this.machine = machine;
        this.technician = technician;
        this.type = type;
        this.severity = severity;
        this.description = description;
        this.resolution = resolution;
        this.reportedAt = reportedAt;
        this.memoryDocId = memoryDocId;
    }

    public Long getId() {
        return id;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public IncidentType getType() {
        return type;
    }

    public void setType(IncidentType type) {
        this.type = type;
    }

    public IncidentSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(IncidentSeverity severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public LocalDateTime getReportedAt() {
        return reportedAt;
    }

    public void setReportedAt(LocalDateTime reportedAt) {
        this.reportedAt = reportedAt;
    }

    public String getMemoryDocId() {
        return memoryDocId;
    }

    public void setMemoryDocId(String memoryDocId) {
        this.memoryDocId = memoryDocId;
    }
}