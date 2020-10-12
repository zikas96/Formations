package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Role;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, String>{

}
