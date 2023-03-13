package com.second.spring.data.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.second.spring.data.jpa.entity.Course;
import com.second.spring.data.jpa.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherrepository;

	@Test
	public void saveTeacher() {
		
		Course course = Course.builder().credit(5).title("DAA").build();
		Course course1 = Course.builder().credit(4).title("JAVA").build();

	//	Teacher teacher = Teacher.builder().firstName("virat").lastName("kohli").courseList(List.of(course,course1)).build();
		//teacherrepository.save(teacher);
		
	}

}
