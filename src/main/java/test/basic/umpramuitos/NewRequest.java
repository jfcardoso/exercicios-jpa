package test.basic.umpramuitos;

import Infra.DAO;
import model.basic.Product;
import model.umpramuitos.ItemRequest;
import model.umpramuitos.Request;

public class NewRequest {

	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<>();
		
		// cria um pedido com a data atual
		Request request = new Request();
		
		// instancia um novo produto
		Product product = new Product("Geladeira", 3545.9);
		
		// adiciona uma quantidade X do produto ao pedido
		ItemRequest item = new ItemRequest(request, product, 10);
		
		dao.openTransaction()
		   .addEntity(product)
		   .addEntity(request)
		   .addEntity(item)
		   .closeTransaction().close();		
		
	}
}
