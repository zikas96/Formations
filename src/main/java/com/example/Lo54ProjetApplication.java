package com.example;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import com.example.dao.ClientRepository;
import com.example.dao.CourseRepository;
import com.example.dao.CourseSessionRepository;
import com.example.dao.LocationRepository;
import com.example.dao.RoleRepository;
import com.example.entities.Client;
import com.example.entities.Course;
import com.example.entities.CourseSession;
import com.example.entities.Location;
import com.example.entities.Role;


@SpringBootApplication
public class Lo54ProjetApplication {

	public static void main(String[] args) {
		
		ApplicationContext ctx=SpringApplication.run(Lo54ProjetApplication.class, args);
		ClientRepository clientRepository=ctx.getBean(ClientRepository.class);
		RoleRepository roleRepository = ctx.getBean(RoleRepository.class);
		Role role=new Role("USER", "");
		roleRepository.save(role);
		clientRepository.save(new Client("NAJI", "Zakaria", "3 Rue Gaston DEFFERRE", "0769117954", "zakaria.naji@utbm.fr"));
		LocationRepository locationMetier=ctx.getBean(LocationRepository.class);
		Location loc=new Location("Belfort");
		locationMetier.save(loc);
		CourseRepository courseRepostory = ctx.getBean(CourseRepository.class);
		courseRepostory.save(new Course("21FE15", "formation en big data"));
		Course c1=new Course("21FE15", "formation en java et j2ee");
		courseRepostory.save(c1);
		CourseSessionRepository courseSessionRepository = ctx.getBean(CourseSessionRepository.class);
		CourseSession cs1 = new CourseSession(LocalDate.of(2017, 1, 13), LocalDate.of(2018, 1, 13), 50, loc, c1);
		courseSessionRepository.save(cs1);
		Client c2=clientRepository.findById((long) 1).get();
		System.out.println(c2.getFirstName());
		Collection<CourseSession> cs= new HashSet<>();
		cs.add(cs1);
		c2.setCourseSessions(cs);
		c2.setRole(role);
		c2.setPassword("1234");
		c2.setActived(true);
		clientRepository.save(c2);
		
		int i = courseSessionRepository.sumClient((long) 3);
		System.out.println(i);
		
		
		
		

		
	
	}

}
