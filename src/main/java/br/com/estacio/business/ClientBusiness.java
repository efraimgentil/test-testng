package br.com.estacio.business;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import br.com.estacio.exception.ClientNotFoundException;
import br.com.estacio.exception.InvalidClientException;
import br.com.estacio.model.Client;

public class ClientBusiness {
	
	
	private static AtomicLong atomicLong = new AtomicLong();
	private static final List<Client> CLIENTS = new ArrayList<>() ;
	
	public List<Client> getAllClients(){
		return CLIENTS;
	}
	
	public Client find(Long id) throws ClientNotFoundException{
		int index = CLIENTS.indexOf( new Client( id ) );
		if(index == -1)
			throw new ClientNotFoundException("Client not found");
		return (Client) CLIENTS.get(index).clone();
	}
	
	public void delete(Client client) throws ClientNotFoundException{
		if(!CLIENTS.remove(client) )
			throw new ClientNotFoundException("Client not found");
	}
	
	public void create(Client client) throws InvalidClientException{
		validaCliente(client);
		client.setId( atomicLong.incrementAndGet() );
		CLIENTS.add(client);
	}
	
	public void update(Client client) {
		CLIENTS.remove(client);
		CLIENTS.add(client);
	}
	
	public void validaCliente(Client client) throws InvalidClientException{
		if( client.getName() == null )
			throw new InvalidClientException("The client can't have a null name");
		if( client.getName().trim().length() < 3 )
			throw new InvalidClientException("The client can't have a name with less than 3 characters");
		if( client.getPhone() == null )
			throw new InvalidClientException("The client can't have a null phone");
		if( client.getPhone().replaceAll("\\D", "").length() < 8 )
			throw new InvalidClientException("The client can't have a phone with less than 8 digits");
	}
	
	
	
}
