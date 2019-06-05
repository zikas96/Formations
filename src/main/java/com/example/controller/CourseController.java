package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.entities.Course;
import com.example.metier.CourseMetier;

@SuppressWarnings({"deprecation"})
@Controller
@RequestMapping(value="/Course")
public class CourseController {
	
	@Autowired
	private CourseMetier courseMetier;
	
	
	@GetMapping("/listc")
	public String listCourse(Model model, 
			@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="name",defaultValue="") String mc) {
		Page<Course> pageCourses=courseMetier
				.SearchByTitle("%"+mc+"%",
						new PageRequest(p, 5));
		int pagesCount=pageCourses.getTotalPages();
		int [] pages=new int[pagesCount];
		for(int i=0;i<pagesCount;i++) pages[i] =i;
		model.addAttribute("pages", pages);
		model.addAttribute("pageCourses",pageCourses);
		model.addAttribute("pageCourante",p);
		model.addAttribute("name", mc);
		return "listc";
	}
	

}
