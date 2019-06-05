package com.example.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings({ "serial" })
@Entity
public class Course implements Serializable{
	@Id
	private String code;
	private String title;
	@JsonIgnore
	@OneToMany(mappedBy="courseId",fetch=FetchType.LAZY)
	private Collection<CourseSession> courseSessions;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(String code, String title) {
		super();
		this.code = code;
		this.title = title;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Collection<CourseSession> getCourseSessions() {
		return courseSessions;
	}
	public void setCourseSessions(Collection<CourseSession> courseSessions) {
		this.courseSessions = courseSessions;
	}
	

	

}
