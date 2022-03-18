package test.basic;

import Infra.DAO;
import model.basic.Product;

public class NewProduct {
	
	public static void main(String[] args) {
		
		Product produto = new Product("Impressora Epson L3150", 1299.65);
		
		//resolvendo o Generics com a instância:
		DAO<Product> dao = new DAO<>(Product.class);
		
		dao.addEntityWithTransaction(produto).close();
		
		System.out.println("Produto: " + produto.getNome() + " cadastrado(a)"
				+ " com sucesso.");
	}
	
	

}
