package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Client;
import com.example.metier.ClientMetier;

@Controller
@RequestMapping(value="/Client")
public class ClientController {
	
	@Autowired
    public JavaMailSender emailSender;
	
	
	@Autowired
	private ClientMetier clientMetier;
	
	@GetMapping("/registerClient")
	public String getFormClient(Model model) {
		model.addAttribute("client", new Client());
		return "registerClient";
	}
	
	@GetMapping("/registration")
	public String registerClient(Model model, @Valid Client cl,
			BindingResult bindingResult) {
		clientMetier.addClient(cl);
		return "redirect:/Session/listcs";
	}

	@GetMapping("/getLogged")
	public void getLogged() {
		
		System.out.println(clientMetier.getLoggedClient().get("username"));
	}
	
	@RequestMapping("/getPass")
	public String sendEmailPassword(Client cl) {
    	
        
        SimpleMailMessage message = new SimpleMailMessage();
        
        message.setTo(cl.getEmail());
        message.setSubject("Renitialisation de votre mot de passe");
        message.setText("Bonjour \n Votre mot de pass est : "+ clientMetier.findByEmail(cl.getEmail()).getEmail());
 
        
        emailSender.send(message);
        return "Redirect:/login";
        
    }

}
