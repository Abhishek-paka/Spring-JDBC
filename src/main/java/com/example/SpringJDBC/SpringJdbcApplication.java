package com.example.SpringJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.SpringJDBC.model.Student;
import com.example.SpringJDBC.repo.StudentDAO;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		
		Student student = context.getBean(Student.class);
		student.setId(501);
		student.setName("Franklin");
		student.setTech("Java");
		
		StudentDAO dao = context.getBean(StudentDAO.class);
		
		dao.save(student);
		
		System.out.println(dao.findAll());
	}

}
