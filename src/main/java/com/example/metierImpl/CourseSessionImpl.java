package com.example.metierImpl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.dao.CourseSessionRepository;
import com.example.entities.CourseSession;
import com.example.metier.CourseSessionMetier;

@Service
public class CourseSessionImpl implements CourseSessionMetier {

	@Autowired
	CourseSessionRepository courseSessionRepository;
	
	@Override
	public Page<CourseSession> SearchByDate(LocalDate date, Pageable pageable) {
		// TODO Auto-generated method stub
		return courseSessionRepository.findByDate(date, pageable);
	}

	@Override
	public Page<CourseSession> SearchByCity(String city, Pageable pageable) {
		// TODO Auto-generated method stub
		return courseSessionRepository.findByCity("%"+city+"%", pageable);
	}

	@Override
	public Page<CourseSession> listCourseSession(Pageable pageable) {
		// TODO Auto-generated method stub
		return courseSessionRepository.findAll(pageable);
	}

	@Override
	public Optional<CourseSession> findById(Long id) {
		// TODO Auto-generated method stub
		return courseSessionRepository.findById(id);
	}

	@Override
	public int sumClient(Long idCourseSession) {
		// TODO Auto-generated method stub
		return courseSessionRepository.sumClient(idCourseSession);
	}

}
