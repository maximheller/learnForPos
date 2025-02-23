package com.example.demo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {

    private final StudentRepository studentRepository;
    private final ElectiveSubjectRepository electiveSubjectRepository;
    private final StudentGradeRepository studentGradeRepository;
    private final StudentPriorityRepository studentPriorityRepository;

    public StudentService(StudentRepository studentRepository, ElectiveSubjectRepository electiveSubjectRepository, StudentGradeRepository studentGradeRepository, StudentPriorityRepository studentPriorityRepository) {
        this.studentRepository = studentRepository;
        this.electiveSubjectRepository = electiveSubjectRepository;
        this.studentGradeRepository = studentGradeRepository;
        this.studentPriorityRepository = studentPriorityRepository;
    }

    public List<Student> StudentsPerElectiveSubject()
    {
        // An application which takes the described input data and outputs a
        // list of assigned students per elective subject.
        // * The required basic classes to hold data of elective subjects, students, grades, ...
        // * The required service class implementing the assignment algorithm
        // * Any helper classes
        // * Tests to ensure the correctness of the project
        //
        // TODO: Implementation



        return null;
    }

    public Map<String, Integer> electiveSubjectsWithNumberOfSeats() {

//        private Long id;
//        private String name;
//        private int availableSeats;
        return electiveSubjectRepository.findAll().stream()
                .collect(Collectors
                        .toMap(ElectiveSubject::getName, ElectiveSubject::getAvailableSeats));
    }

    public List<Student> listOfStudents() {
        return studentRepository.findAll();
    }


//    public Optional<Dive> findLongestDive() {
//        return diveRep.findAll().stream()
//                .max((o1, o2) -> o1.getDiverProfile().getDuration().compareTo(o2.getDiverProfile().getDuration()));
//    }
//
//    //helper for prioritizedListOfElectiveSubjects()
//    public List<ElectiveSubject> getElectiveSubjects(Student student) {
//        return studentRepository.findById(student.getId()).stream()
//                .flatMap(s-> s.getPriorities().stream())
//                .sorted((m1,m2)->m1.getPriority().compareTo())
//    }
//
//
//    //return a map of student name and elective subjects of that student in the priority order
//    public Map<String, List<ElectiveSubject>> prioritizedListOfElectiveSubjectsOld() {
//
//        studentRepository.findAll().stream()
//                .collect(Collectors
//                        .toMap(Student::getName, student->student.getPriorities().))
//    }


    public Map<String, List<ElectiveSubject>> prioritizedListOfElectiveSubjects() {
        return studentRepository.findAll().stream()
                .collect(Collectors.toMap(
                        Student::getName,
                        student -> student.getPriorities().stream()
                                .sorted(Comparator.comparingInt(StudentPriority::getPriority)) // Sort by priority
                                .map(StudentPriority::getElectiveSubject) // Extract ElectiveSubject
                                .collect(Collectors.toList()) // Collect as a list
                ));
    }

}
