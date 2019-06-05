package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	@Query("select cl from Client cl where cl.email like :x")
	public Client findByEmail(@Param("x")String email);

}
