package com.example.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@SuppressWarnings({ "serial" })
@Entity
public class CourseSession implements Serializable{
	@Id@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="START_DATE")
	private LocalDate startDate;
	
	@Column(name="END_DATE")
	private LocalDate endDate;
	
	@Column(name="MAX")
	private int number;

	@ManyToOne
	@JoinColumn(name="LOCATION_ID")
	private Location locationId;
	
	@ManyToOne
	@JoinColumn(name="COURSE_CODE")
	private Course courseId;
	
	
	@ManyToMany(mappedBy="courseSessions")
	private Collection<Client> clients;


	public CourseSession(LocalDate startDate, LocalDate endDate, int number, Location locationId, Course courseId) {
		super();
		
		this.startDate = startDate;
		this.endDate = endDate;
		this.number = number;
		this.locationId = locationId;
		this.courseId = courseId;
	}
	public CourseSession() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Location getLocationId() {
		return locationId;
	}
	public void setLocationId(Location locationId) {
		this.locationId = locationId;
	}
	public Course getCourseId() {
		return courseId;
	}
	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}
	public Collection<Client> getClients() {
		return clients;
	}
	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	
	
	

}
