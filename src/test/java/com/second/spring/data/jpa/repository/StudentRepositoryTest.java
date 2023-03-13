package com.second.spring.data.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.second.spring.data.jpa.entity.Guardian;
import com.second.spring.data.jpa.entity.Student;

@SpringBootTest
class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void saveStudent() {
		Student student = Student.builder().emailId("sai1@gmail.com").firstName("sai").lastName("esh")
				//.guardianName("sri")
				//.guardianEmail("sri@gmail.com")
				//.guardianMobile("1234567890")
				.build();
		studentRepository.save(student);
	}
	
	@Test
	public void printAllStudent() {
		List<Student> studentList = studentRepository.findAll();
		System.out.println(studentList);
	}

	
	@Test
	public void saveStudentWithGuardianDetails() {
	     
	    Guardian guardian =  Guardian.builder().email("sri@gmail.com").mobile("1234567890").name("sri").build();
        Student student = Student.builder().emailId("sai2@gmail.com").firstName("sai2").lastName("esh2").guardian(guardian).build();
	   studentRepository.save(student);
	
	}
	
	@Test
	public void printStudentByFirstName() {
		List<Student> studentList = studentRepository.findByFirstName("sai");
		System.out.println(studentList);
	}
	
	@Test
	public void printStudentByFirstNameContaining() {
		List<Student> studentList = studentRepository.findByFirstNameContaining("sai");
		System.out.println(studentList);
	}
	
	@Test
	public void printStudentByGuardianName() {
		List<Student> studentList = studentRepository.findByGuardianName("sri");
		System.out.println(studentList);
	}
	
	@Test
	public void printStudentByEmailAddress() {
		Student student = studentRepository.getStudentEmailAddress("sai@gmail.com");
		System.out.println(student);
	}
	
	
	@Test
	public void printStudentFirstNameByEmailAddress() {
		String student = studentRepository.getStudentFirstNameEmailAddress("sai@gmail.com");
		System.out.println(student);
	}
	
	@Test
	public void printStudentByEmailAddressNative() {
		Student student = studentRepository.getStudentEmailAddressNative("sai@gmail.com");
		System.out.println(student);
	}
	
	@Test
	public void printStudentByEmailAddressNativeNameParam() {
		Student student = studentRepository.getStudentEmailAddressNativeNameParam("sai@gmail.com");
		System.out.println(student);
	}
	
	@Test
	public void updateStudentNameByEmalId() {

		Integer student = studentRepository.updateStudentNameByEmailId("saiUpdated","sai@gmail.com");
		System.out.println(student);
	}
	
}
