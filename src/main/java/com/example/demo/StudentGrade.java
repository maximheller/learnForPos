package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StudentGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;
    private double grade;

    public StudentGrade() {}

    public StudentGrade(Student student, double grade) {
        this.student = student;
        this.grade = grade;
    }
}
