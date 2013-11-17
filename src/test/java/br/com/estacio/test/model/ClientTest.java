package br.com.estacio.test.model;

import java.util.logging.Logger;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClientTest {
	
  private Logger logger = Logger.getLogger(ClientTest.class.getSimpleName());
	
  
//  @BeforeTest
//  public void init(){
//	  logger.info("Chamado uma vez por classe");
//  }
//  
//  @BeforeMethod
//  public void initMethods(){
//	  logger.info("Chaado uma vez por metodo");
//  }
//  
//  /* 
//   * Aqui eu digo que quero chamar esse metodo
//   *  antes dos testes do grupo invalid ser chamado
//   */
//  @BeforeGroups( groups = { "invalid"} ) 
//  public void initGroupInvalid(){
//	  logger.info("Chamado 1 vez por grupo");
//  }
//	
//  @Test( testName = "ValidClient" ,  groups = { "valid" } )
//  public void clientShouldBeValid() {
//	  logger.info("Teste 1 ");
//  }
//  
//  @Test( testName = "Invalid Client Name"  ,  groups = { "invalid" })
//  public void clientShouldBeInvalid(){
//	  logger.info("Chamando metodo clientShouldBeInvalid");
//  }
//  
//  @Test( testName = "Invalid Client Name"  ,  groups = { "invalid" })
//  public void clientShouldBeInvalid2(){
//	  logger.info("Chamando metodo clientShouldBeInvalid2");
//  }
	
}
