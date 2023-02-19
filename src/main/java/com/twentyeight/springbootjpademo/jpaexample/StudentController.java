package com.twentyeight.springbootjpademo.jpaexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa")
public class StudentController {

    @Autowired
    StudentJpaRepository studentJpaRepository;

    @GetMapping("/students")
    public List<Student> getAll() {
        return studentJpaRepository.findAll();
    }

    @PostMapping("/student")
    public ResponseEntity<Object> createStudent(@Valid @RequestBody Student student) {
        Student student1 = studentJpaRepository.save(student);
        return ResponseEntity.ok().body(student1);
    }

    @GetMapping("/student/{id}")
    public Student findUserById(@PathVariable Long id) {
        Optional<Student> optionalStudent = studentJpaRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    @DeleteMapping("/student/{id}")
    public String deleteUserById(@PathVariable Long id) {
        studentJpaRepository.deleteById(id);
        return "Deleted student id: " + id;
    }
}
