package br.com.estacio.test.factorys;

public interface ModelFactory<Model> {

	public Model createValid();
	
	public Model createInvalid();
	
}
