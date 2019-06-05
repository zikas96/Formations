package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

}
