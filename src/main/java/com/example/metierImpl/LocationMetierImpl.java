package com.example.metierImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.LocationRepository;
import com.example.entities.Location;
import com.example.metier.LocationMetier;

@Service
public class LocationMetierImpl implements LocationMetier {
	
	@Autowired
	LocationRepository locationRepository;
	
	@Override
	public List<Location> listLocation() {
		// TODO Auto-generated method stub
		return locationRepository.findAll();
	}
	
}
