package com.second.spring.data.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.second.spring.data.jpa.entity.Course;
import com.second.spring.data.jpa.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialTest {


	@Autowired
	private CourseMaterialRepository courseMaterialRepository; 

	@Test
	public void saveCourseMaterial() {
		
		Course course = Course.builder().title("DS").credit(4).build();
		CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com").course(course).build();
		courseMaterialRepository.save(courseMaterial);
	}

	
	@Test
	public void printAllCourseMaterials() {
		
		List<CourseMaterial> courseMaterial = courseMaterialRepository.findAll();
		System.out.println(courseMaterial);
	}
}
