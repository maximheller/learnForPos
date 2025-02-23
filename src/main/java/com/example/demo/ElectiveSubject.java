package com.example.demo;

import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ElectiveSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int availableSeats;

    public ElectiveSubject() {}

    public ElectiveSubject(String name, int availableSeats) {
        this.name = name;
        this.availableSeats = availableSeats;
    }
}
