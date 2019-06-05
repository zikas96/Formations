package com.example.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings({ "serial" })
@Entity
public class Role implements Serializable{
	@Id
	private String role;
	private String description;
	@JsonIgnore
	@OneToMany(mappedBy="role")
	private Collection<Client> clients;
	public Role(String role, String description) {
		super();
		this.role = role;
		this.description = description;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Collection<Client> getClients() {
		return clients;
	}
	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	

}
