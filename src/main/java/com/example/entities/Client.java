package com.example.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@SuppressWarnings({"serial"})
@Entity
public class Client implements Serializable{
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long id;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="ADDRESS")
	private String adresse;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="EMAIL")
	private String email;
	
	private boolean actived;
	private String password;
	
	@ManyToOne
	@JoinColumn(name="role_client")
	private Role role;
	
	@ManyToMany
	@JoinTable(name="Sessions_Clients")
	private Collection<CourseSession> courseSessions;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String lastName, String firstName, String adresse, String phone, String email) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.adresse = adresse;
		this.phone = phone;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<CourseSession> getCourseSessions() {
		return courseSessions;
	}

	public void setCourseSessions(Collection<CourseSession> courseSessions) {
		this.courseSessions = courseSessions;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	
	
	
	

}
