package com.second.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.second.spring.data.jpa.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long >{

	public List<Student> findByFirstName(String firstName);
	
	public List<Student> findByFirstNameContaining(String firstName);
	
	public List<Student> findByLastNameNotNull();
	
	public List<Student> findByGuardianName(String guardianName);
	
	//JPQL Query-->based on the class that we created
	@Query("select s from Student s where s.emailId = ?1")
	public Student getStudentEmailAddress(String emailId);
	
	@Query("select s.firstName from Student s where s.emailId = ?1")
	public String getStudentFirstNameEmailAddress(String emailId);
	
	//native queries--->based on the DB table
	@Query(value="select * from tbl_student where email_address = ?1",nativeQuery=true)
	public Student getStudentEmailAddressNative(String emailId);
	
	@Query(value="select * from tbl_student where email_address = :emailId",nativeQuery=true)
	public Student getStudentEmailAddressNativeNameParam(@Param("emailId") String emailId);
	
	@Modifying
	@Transactional
	@Query(value="update tbl_student set first_name=?1 where email_address=?2",nativeQuery = true)
	public Integer updateStudentNameByEmailId(String firstName, String emailId);
	
}
