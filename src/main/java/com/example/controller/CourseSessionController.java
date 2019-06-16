package com.example.controller;

import java.time.LocalDate;
import java.util.Collection;

import java.util.HashSet;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.entities.Client;
import com.example.entities.CourseSession;

import com.example.entities.Location;
import com.example.metier.ClientMetier;
import com.example.metier.CourseSessionMetier;
import com.example.metier.LocationMetier;

@SuppressWarnings({"deprecation"})
@Controller
@RequestMapping(value="/Session")
public class CourseSessionController {
	

	
	@Autowired
	private CourseSessionMetier courseSessionMetier;
	
	@Autowired
	private LocationMetier locationMetier;
	

	@Autowired
	private ClientMetier clientMetier;
	
	@Autowired
    public JavaMailSender emailSender;
	
	
	@GetMapping("/listcs")
	public String listCourse(Model model,
			@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="city",defaultValue="") String city,
			@RequestParam(name="name",defaultValue="") String mc,
			@RequestParam(name="date",required=false) @DateTimeFormat(iso = ISO.DATE) LocalDate date) {
			
			if (date==null) {
				Page<CourseSession> pageCourseSessions = courseSessionMetier.SearchWithoutDate("%"+city+"%","%"+mc+"%", new PageRequest(p, 5));
				int pagesCount = pageCourseSessions.getTotalPages();
				int [] pages=new int[pagesCount];
				for(int i=0;i<pagesCount;i++) pages[i] =i;
				model.addAttribute("pages", pages);
				model.addAttribute("pageCourseSessions",pageCourseSessions);
				model.addAttribute("pageCourante",p);
				model.addAttribute("city", city);
				model.addAttribute("date", date);
				model.addAttribute("name", mc);
				
			}
			else{
				Page<CourseSession> pageCourseSessions = courseSessionMetier.SearchByAll("%"+city+"%","%"+mc+"%", date, new PageRequest(p, 5));
				int pagesCount = pageCourseSessions.getTotalPages();
				int [] pages=new int[pagesCount];
				for(int i=0;i<pagesCount;i++) pages[i] =i;
				model.addAttribute("pages", pages);
				model.addAttribute("pageCourseSessions",pageCourseSessions);
				model.addAttribute("pageCourante",p);
				model.addAttribute("city", city);
				model.addAttribute("date", date);
				model.addAttribute("name", mc);
			}
			model.addAttribute("clientId", clientMetier.findByEmail((String)clientMetier.getLoggedClient().get("username")));
		List<Location> locations= locationMetier.listLocation();
		model.addAttribute("locations", locations);
		return "listcs";
	}
	
	@GetMapping("/inscription")
	public String inscription(Model model, @RequestParam(name="codeS",defaultValue="")Long codeS){
			Client client= clientMetier.findByEmail((String)clientMetier.getLoggedClient().get("username"));
			Collection<CourseSession> collections= new HashSet<>();
			CourseSession cs = courseSessionMetier.findById(codeS).get();
			collections.add(cs);
			client.setCourseSessions(collections);
			clientMetier.addClient(client);
			//sendEmailInscription(client, cs);
		return "redirect:listcs";
	}
	

	
	@GetMapping("/sumClient")
	public int sum(@RequestParam(name="idCourseSession",defaultValue="")Long idCourseSession){
		return courseSessionMetier.sumClient(idCourseSession);
		 
	}
	
	
	public void sendEmailInscription(Client cl, CourseSession cs) {
	    	
	        // Create a Simple MailMessage.
	        SimpleMailMessage message = new SimpleMailMessage();
	         
	        message.setTo(cl.getEmail());
	        message.setSubject("Inscription Session");
	        message.setText("Bonjour \n Nous vous confirmons votre inscription dans la formation N° " + cs.getId()
	        +"\n La date de début sera le : "+cs.getStartDate());
	 
	        // Send Message!
	        this.emailSender.send(message);
	 
	        
	    }
	
	

}
