package com.example.dao;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.CourseSession;

public interface CourseSessionRepository extends JpaRepository<CourseSession, Long>{
	
	@Query("select crs from CourseSession crs where crs.startDate<=:d and crs.endDate>=:d")
	public Page<CourseSession> findByDate(@Param("d")LocalDate date,Pageable pageable);
	@Query("select crs from Location lo join lo.courseSessions crs where lo.city like :c")
	public Page<CourseSession> findByCity(@Param("c")String city,Pageable pageable);
	@Query("select count(cs) from CourseSession cs JOIN cs.clients where cs.id = :idCourseSession")
	public int sumClient(@Param("idCourseSession")Long idCourseSession);

}
