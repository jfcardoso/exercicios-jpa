package test.basic;

import java.util.List;

import Infra.ProductDAO;
import model.basic.Product;

public class GetProducts {
	
	public static void main(String[] args) {
	
		//Resolvendo o Generics através da Herança:
		ProductDAO dao =  new ProductDAO();
		List<Product> products = dao.getAllEntities();
		
		for(Product p : products) {
			
			System.out.println("Produto: "+ p.getNome() + ", Preço: R$ " 
						+ p.getPreco());
		}
		
		//somatório dos preços dos produtos da tabela
		double valorTotal = products.stream()
							   .map(p -> p.getPreco())
							   .reduce(0.0, (total, atual) -> total + atual)
							   .doubleValue();
		
		System.out.printf("Valor total: R$ %.2f", valorTotal);
		
		dao.close();
	}

}
