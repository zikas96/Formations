package com.example;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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
		clientRepository.save(new Client("NAJI", "Omar", "26 rue province", "0667107800", "omar.naji@utbm.fr"));
		LocationRepository locationMetier=ctx.getBean(LocationRepository.class);
		Location loc=new Location("Belfort");
		locationMetier.save(loc);
		Location loc1 = new Location("Mulhouse");
		Location loc2 = new Location("Strasbourg");
		Location loc3 = new Location("Versailles");
		Location loc4 = new Location("Montbélliard");
		locationMetier.save(loc1);
		locationMetier.save(loc2);
		locationMetier.save(loc3);
		locationMetier.save(loc4);
		locationMetier.save(new Location("Besancon"));
		locationMetier.save(new Location("Metz"));
		Course c22=new Course("21FE19", "SQL/PLSQL Web Toolkit");
		Course c3=new Course("21FE16", "formation en big data");
		Course c4 = new Course("21FE17", "formation en Web service");
		Course c5 = new Course("21FE18", "Administration Oracle");
		CourseRepository courseRepostory = ctx.getBean(CourseRepository.class);
		courseRepostory.save(c3);
		courseRepostory.save(c4);
		courseRepostory.save(c5);
		courseRepostory.save(c22);
		Course c1=new Course("21FE15", "formation en java et j2ee");
		courseRepostory.save(c1);
		CourseSessionRepository courseSessionRepository = ctx.getBean(CourseSessionRepository.class);
		CourseSession cs1 = new CourseSession(LocalDate.of(2017, 1, 13), LocalDate.of(2018, 1, 13), 50, loc, c1);
		courseSessionRepository.save(new CourseSession(LocalDate.of(2019, 1, 13), LocalDate.of(2019, 5, 13), 50, loc1, c22));
		courseSessionRepository.save(new CourseSession(LocalDate.of(2019, 4, 1), LocalDate.of(2019, 4, 20), 50, loc1, c22));
		courseSessionRepository.save(new CourseSession(LocalDate.of(2019, 06, 15), LocalDate.of(2019, 12, 15), 50, loc4, c22));
		courseSessionRepository.save(new CourseSession(LocalDate.of(2019, 3, 13), LocalDate.of(2019, 6, 13), 50, loc2, c3));
		courseSessionRepository.save(new CourseSession(LocalDate.of(2019, 8, 1), LocalDate.of(2019, 10, 15), 50, loc3, c4));

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
		
		courseSessionRepository.cherchertout("Belfort", LocalDate.of(2017, 1, 13), "java", new PageRequest(0, 5));
		
		
		
		
	
	}

}
