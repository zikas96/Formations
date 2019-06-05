package com.example.metier;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entities.Course;

public interface CourseMetier {
	public Page<Course> SearchByTitle(String title,Pageable pageable);
	public List<Course> all();	
	
}
