package com.second.spring.data.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.second.spring.data.jpa.entity.Course;
import com.second.spring.data.jpa.entity.CourseMaterial;
import com.second.spring.data.jpa.entity.Student;
import com.second.spring.data.jpa.entity.Teacher;

@SpringBootTest
class CourseTest {


	@Autowired
	private CourseRepository courseRepository; 

//	@Test
//	public void saveCourseMaterial() {
//		
//		Course course = Course.builder().title("DS").credit(4).build();
//		CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com").course(course).build();
//		courseMaterialRepository.save(courseMaterial);
//	}

	
	@Test
	public void printAllCourses() {
		
		List<Course> course = courseRepository.findAll();
		System.out.println(course);
	}
	
	@Test
	public void saveCourseWithTeacher() {
		
		Teacher teacher= Teacher.builder().firstName("smrithi").lastName("mandhana").build();
		Course course = Course.builder().title("python").credit(10).teacher(teacher).build();
		courseRepository.save(course);	
		System.out.println(course);
	}
	
	
	@Test
	public void findAllPagination() {
		
		Pageable pageWithThree = PageRequest.of(0, 3);
		Pageable pageWithTwo = PageRequest.of(1, 2);
		
	
		List<Course> courses = courseRepository.findAll(pageWithTwo).getContent();
		Long totalElements = courseRepository.findAll(pageWithTwo).getTotalElements();
		int totalPages =  courseRepository.findAll(pageWithTwo).getTotalPages();
		
		
		System.out.println(courses);
		System.out.println(totalElements);
		System.out.println(totalPages);
	}
	
	@Test
	public void findAllPaginationWithSorting() {
		
		Pageable pageWithThree = PageRequest.of(0, 3, Sort.by("title"));
		Pageable pageWithTwo = PageRequest.of(1, 2,Sort.by("credit").descending());
		
	
		List<Course> courses = courseRepository.findAll(pageWithThree).getContent();
		Long totalElements = courseRepository.findAll(pageWithThree).getTotalElements();
		int totalPages =  courseRepository.findAll(pageWithThree).getTotalPages();
		
		
		System.out.println(courses);
		System.out.println(totalElements);
		System.out.println(totalPages);
	}
	
	@Test
	public void findByTitleContaining() {
		
		Pageable firstPageRecords = PageRequest.of(0, 10 );

		
	
		List<Course> courses = courseRepository.findByTitleContaining("DAA",firstPageRecords);
		System.out.println(courses);

	}
	
	
	@Test
	public void saveCourseWithStudentAndTeacher() {
		
		Teacher teacher= Teacher.builder().firstName("smrithi1").lastName("mandhana1").build();
		Course course = Course.builder().title("AI").credit(11).teacher(teacher).build();
		Student student = Student.builder().emailId("sai5@gmail.com").firstName("sai5").lastName("esh5").build();
		course.addStudents(student);
        courseRepository.save(course);
		System.out.println(course);

	}
	
}


