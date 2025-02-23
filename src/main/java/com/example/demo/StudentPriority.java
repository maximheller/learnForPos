package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StudentPriority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private ElectiveSubject electiveSubject;
    private int priority;

    public StudentPriority() {}

    public StudentPriority(Student student, ElectiveSubject electiveSubject, int priority) {
        this.student = student;
        this.electiveSubject = electiveSubject;
        this.priority = priority;
    }
}
