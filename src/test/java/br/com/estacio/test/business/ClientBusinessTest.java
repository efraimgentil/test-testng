package br.com.estacio.test.business;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.ExpectedExceptions;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import br.com.estacio.business.ClientBusiness;
import br.com.estacio.exception.ClientNotFoundException;
import br.com.estacio.exception.InvalidClientException;
import br.com.estacio.model.Client;
import br.com.estacio.test.factorys.ClientFactory;
import static org.testng.AssertJUnit.*;

public class ClientBusinessTest {

	private Logger logger = Logger.getLogger(getClass());

	private ClientBusiness clientBusiness;

	private ClientFactory clientFactory;

	@BeforeClass
	public void initClass() {
		logger.info("Initializing class attributes");
		clientBusiness = new ClientBusiness();
		clientFactory = new ClientFactory();
		List<Client> clients = clientBusiness.getAllClients();
		clients.add(clientFactory.createValid());
		clients.add(clientFactory.createValid());
		clients.add(clientFactory.createValid());
	}

	@Test(enabled = true, description = "This test should successfull find a client")
	public void testSuccessfullFindClient() throws ClientNotFoundException {
		Client client = clientBusiness.find(1l);
		assertNotNull(client);
		assertSame(1l, client.getId());
	}

	@Test(enabled = true, description = "This test should capture the exception on not finding a client",
			expectedExceptions = { ClientNotFoundException.class })
	public void testFailureOnFindingAClient() throws ClientNotFoundException {
		clientBusiness.find(9999l);
	}

	@Test(enabled = true, description = "This test should successfull create a new client")
	public void testSuccessfullCreateAClient() throws InvalidClientException, ClientNotFoundException {
		Client client = new Client("New Client Name", "885588822", "88552244");

		clientBusiness.create(client);

		assertNotNull(client.getId());
		assertNotNull(clientBusiness.find(client.getId()));
	}
	
	@Test( enabled = true,
		 description = "This test should capture an exception of the invalid name from the client",
		 expectedExceptions = { InvalidClientException.class })
	public void testFailureOnCreateClientWithSmallName() throws InvalidClientException{
		Client client = new Client("YO", "885588822", "88552244");
		clientBusiness.create(client);
	}
	
	@Test( enabled = true,
		   description = "This test should capture an exception of the invalid null name from the client",
		   expectedExceptions = { InvalidClientException.class })
	public void testFailureOnCreateClientWithNullName() throws InvalidClientException{
		Client client = new Client( null , "885588822", "88552244");
		clientBusiness.create(client);
	}
	
	@Test( enabled = true,
		   description = "This test should capture an exception of the invalid null phone from the client",
		   expectedExceptions = { InvalidClientException.class } )
	public void testFailureOnCreateClientWithNullPhone() throws InvalidClientException{
		Client client = new Client( "Hello CLient" , null , "88552244");
		clientBusiness.create(client);
	}
	
	@Test( enabled = true,
		   description = "This test should capture an exception of the invalid phone number with less than 8 characters",
		   expectedExceptions = { InvalidClientException.class }  )
	public void testFailureOnCreateClientWithPhoneWithLessThanEightCharacters() throws InvalidClientException{
		Client client = new Client( "Hello CLient" , "889922" , "88552244");
		clientBusiness.create(client);
	}

}
