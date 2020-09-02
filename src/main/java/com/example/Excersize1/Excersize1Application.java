package com.example.Excersize1;

import java.util.UUID;

import com.example.Excersize1.Model.Student;
import com.example.Excersize1.Repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Excersize1Application implements CommandLineRunner {

	@Autowired
	private StudentRepository _studentRepo;

	public static void main(String[] args) {
		SpringApplication.run(Excersize1Application.class, args);
		System.out.println("ABC");
	}

	@Override
	public void run(String... args) throws Exception {
		var student1 = new Student();
		student1.Id = UUID.randomUUID();
		student1.Name = "Peter";
		student1.Age = 1;
		student1.CompanyName = "World";

		var student2 = new Student();
		student2.Id = UUID.randomUUID();
		student2.Name = "Tom";
		student2.Age = 2;
		student2.CompanyName = "Sun";

		var student3 = new Student();
		student3.Id = UUID.randomUUID();
		student3.Name = "Sarah";
		student3.Age = 1;
		student3.CompanyName = "Atech";

		_studentRepo.save(student1);
		_studentRepo.save(student2);
		_studentRepo.save(student3);
	}
}
