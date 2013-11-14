package br.com.estacio.test.factorys;

import java.util.concurrent.atomic.AtomicLong;

import br.com.estacio.model.Client;

public class ClientFactory implements ModelFactory<Client> {
	
	private static AtomicLong atomicLong = new AtomicLong(0);

	@Override
	public Client createValid() {
		Client client = new Client( atomicLong.incrementAndGet() );
		client.setName( "Nome " + client.getId() );
		client.setPhone("88888888" + client.getId() );
		client.setCellPhone("88888888" + client.getId());
		return client;
	}

	@Override
	public Client createInvalid() {
		Long id = atomicLong.incrementAndGet();
		Client client = new Client();
		client.setName( "Nome " + id );
		client.setPhone("88888888" + id );
		client.setCellPhone("88888888" + id );
		return client;
	}
	
	
	
	
}
