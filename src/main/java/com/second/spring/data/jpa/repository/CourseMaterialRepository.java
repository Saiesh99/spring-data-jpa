package com.second.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.second.spring.data.jpa.entity.CourseMaterial;

@Repository
public interface CourseMaterialRepository  extends JpaRepository<CourseMaterial, Long>{

}
