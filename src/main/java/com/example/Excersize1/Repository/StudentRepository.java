package com.example.Excersize1.Repository;

import java.util.UUID;

import com.example.Excersize1.Model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, UUID> {

}