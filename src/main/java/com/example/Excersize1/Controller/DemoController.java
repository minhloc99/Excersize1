package com.example.Excersize1.Controller;

import java.util.List;
import java.util.UUID;

import com.example.Excersize1.Model.Student;
import com.example.Excersize1.Repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class DemoController {

    @Autowired
    private StudentRepository _studentRepo;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return _studentRepo.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable UUID id) {
        return _studentRepo.findById(id).get();
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return _studentRepo.save(student);
    }

    @PutMapping("/students/{id}")
    public Object updateStudent(@PathVariable UUID id, @RequestBody Student student) {
        var existingStudent = _studentRepo.findById(id).get();

        if (existingStudent != null) {
            existingStudent.Name = student.Name;
            existingStudent.Age = student.Age;
            existingStudent.CompanyName = student.CompanyName;

            return _studentRepo.save(existingStudent);
        } else {
            return new Exception("Student is not found!");
        }
    }

    @DeleteMapping("/students/{id}")
    public Object deleteStudent(@PathVariable UUID id) {
        var existingStudent = _studentRepo.findById(id).get();

        if (existingStudent != null) {
            _studentRepo.delete(existingStudent);

            return "Deleted successfully";
        } else {
            return new Exception("Student is not found!");
        }
    }
}