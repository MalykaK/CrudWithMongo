package org.malyka.student.controller;

import org.malyka.student.model.Student;
import org.malyka.student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController()
@RequestMapping("api")
public class StudentController {
    @Autowired
    StudentRepo studentRepo;

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student)
    {
        studentRepo.save(student);
    }

    @PostMapping("/addStudents")
    public void addStudents(@RequestBody List<Student> students) {
        studentRepo.saveAll(students);

    }

    @GetMapping("/getStudents")
    public List<Student> getStudents() {
        List<Student> students;
        students = studentRepo.findAll();
        return students;
    }

    @GetMapping("/getByStudentId/{studentId}")
    public ResponseEntity<Student> getByStudentId(@PathVariable String studentId)
    {
        Student student;
        student = studentRepo.findById(studentId).orElse(null);
        if(student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<>(student, HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteByStudentId/{studentId}")
    public ResponseEntity deleteByStudentId(@PathVariable String studentId)
    {
        studentRepo.deleteById(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
