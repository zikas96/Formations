package com.example.metier;


import java.util.List;
import java.util.Map;



import com.example.entities.Client;

public interface ClientMetier {
	
	//ajouter client
	public Client addClient(Client client);
	
	//selection de la liste des clients
	public List<Client> listClient();
	
	//cherher par email
	public Client findByEmail(String email);
	
	public Map<String, Object> getLoggedClient();
	

	
	
}
