package com.example.metierImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.dao.CourseRepository;
import com.example.entities.Course;
import com.example.metier.CourseMetier;

@Service
public class CourseMetierImpl implements CourseMetier{
	
	@Autowired
	private CourseRepository courseRepository ;
	
	
	@Override
	public Page<Course> SearchByTitle(String title,Pageable pageable) {
		return courseRepository.findByTitle("%"+title+"%", pageable);
	}


	@Override
	public List<Course> all() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}




	

}
