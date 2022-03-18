package model.composition;

import javax.persistence.Embeddable;

/*
 * A anotação @embeddable permitirá que os atributos listados nesta classe sejam
 * automaticamente jogados dentro das tabelas: Empregados e Fornecedores sem que
 * seja necessário usar outra anotação para mapear. 
 */

@Embeddable
public class Address {

	private String logradouro;
	
	private String complemento;
	
	// completar depois com cidade, bairro, cep, etc.

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}	
	
}
