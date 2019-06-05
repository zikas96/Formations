package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entities.Client;

@Controller
@RequestMapping
public class mainController {
	
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	@RequestMapping(value="/Mdp",method=RequestMethod.GET)
	public String renitialiserMdp(Model model){
		Client cl = new Client();
		model.addAttribute("client",cl);
		return "newPass";
	}
	

}
