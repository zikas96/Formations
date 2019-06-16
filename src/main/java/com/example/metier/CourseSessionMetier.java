package com.example.metier;
import com.example.entities.CourseSession;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


	

public interface CourseSessionMetier {
	public Page<CourseSession> SearchByDate(LocalDate date,Pageable pageable);
	public Page<CourseSession> SearchByCity(String city,Pageable pageable);
	public Page<CourseSession> listCourseSession(Pageable pageable);
	public Optional<CourseSession> findById(Long id);
	public int sumClient(Long idCourseSession);
	public Page<CourseSession> SearchByAll(String city,String mc,LocalDate date,Pageable pageable);
	public Page<CourseSession> SearchWithoutDate(String city,String mc,Pageable pageable);
}
