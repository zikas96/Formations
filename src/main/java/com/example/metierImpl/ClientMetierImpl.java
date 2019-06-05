package com.example.metierImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Service;

import com.example.dao.ClientRepository;
import com.example.entities.Client;
import com.example.metier.ClientMetier;

@Service
public class ClientMetierImpl implements ClientMetier {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private HttpServletRequest httpServletRequest;

	@Override
	public Client addClient(Client client) {
		return clientRepository.save(client);
	}


	@Override
	public List<Client> listClient() {
		return clientRepository.findAll();
	}


	@Override
	public Client findByEmail(String email) {
		// TODO Auto-generated method stub
		return clientRepository.findByEmail(email);
	}


	@Override
	public Map<String, Object> getLoggedClient() {
		HttpSession httpsession=httpServletRequest.getSession();
		SecurityContext securityContext=(SecurityContext) httpsession.getAttribute("SPRING_SECURITY_CONTEXT");
		String username=securityContext.getAuthentication().getName();
		List<String> roles=new ArrayList<>();
		for(GrantedAuthority ga:securityContext.getAuthentication().getAuthorities()){
			roles.add(ga.getAuthority());
		}
		Map<String,Object> params=new HashMap<>();
		params.put("username", username);
		params.put("roles", roles);
		return params;
	}


	
	
}
