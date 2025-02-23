package com.example.demo;

//import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void testPrioritizedListOfElectiveSubjectsWorks() {

        ElectiveSubject electiveSubject1 = ElectiveSubject.builder().id(1L).name("SOS").availableSeats(10).build();
        ElectiveSubject electiveSubject2 = ElectiveSubject.builder().id(2L).name("OPS").availableSeats(8).build();

        StudentPriority studentPriority1 = StudentPriority.builder()
                .student(null).electiveSubject(electiveSubject1).priority(1).build();

        StudentPriority studentPriority2 = StudentPriority.builder()
                .student(null).electiveSubject(electiveSubject2).priority(2).build();

        Student student = Student.builder()
                .name("Max").priorities(List.of(studentPriority2,studentPriority1)).build();

        when(studentRepository.findAll()).thenReturn(List.of(student));
        var x = studentService.prioritizedListOfElectiveSubjects();

        System.out.println(x);

        Map<String, List<ElectiveSubject>> map = new HashMap<>();
        map.put("Max", List.of(electiveSubject1, electiveSubject2));
        assertThat(x).isNotNull();
        assertThat(x).isEqualTo(map);

    }

}