test-testng
===========

This repository was created to test the framework of unit test TestNG

# Configure dependencies

First add the testng dependencies to your pom file, or get the jars and put into your porject libraries

```xml
<dependency>
	  <groupId>org.testng</groupId>
	  <artifactId>testng</artifactId>
  	<version>6.1.1</version>
	  <scope>test</scope>
</dependency>
```

# Do a simple test

It is pretty simple, looks exactly like jUnit but whit more options to customize yours tests, see this example.
You can add a description to the test, with that it will be more readable and will give the intention of the test, you can also enable or diable tests with the 'enabled' option, or you can simple use @Test annotation without any option is also valid.

```java
@Test(enabled = true, description = "This test should successfull find a client")
public void testSuccessfullFindClient() throws ClientNotFoundException {
		Client client = clientDao.find(1l);
		
		assertNotNull(client);
		assertSame( 1l , client.getId() );
}
```

