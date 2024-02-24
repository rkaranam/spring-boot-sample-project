package com.codeoncloud.springbootdemo.controllers;

import com.codeoncloud.springbootdemo.domains.Student;
import com.codeoncloud.springbootdemo.exceptions.StudentNotFoundException;
import com.codeoncloud.springbootdemo.repositories.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public List<Student> retrieveAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student retrieveStudent(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) throw new StudentNotFoundException("id: " + id);
        return student.get();
    }
}
