package com.example.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Course;

public interface CourseRepository extends JpaRepository<Course, String>{
	
	@Query("select cr from Course cr where cr.title like :x")
	public Page<Course> findByTitle(@Param("x")String title,Pageable pageable);

}
