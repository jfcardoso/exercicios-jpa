package test.basic.umpramuitos;

import Infra.DAO;
import model.umpramuitos.ItemRequest;
import model.umpramuitos.Request;

public class GetRequest {
	
	public static void main(String[] args) {
		
		DAO<Request> daoRequest = new DAO<>(Request.class);
		Request request = daoRequest.getEntityByID(1L);
		
		// temos aqui a relação "pra muitos"
		for(ItemRequest itens : request.getItensRequests()) {
			System.out.println("Produto: " + itens.getProduct().getNome()
					+ ", quantidade: " + itens.getQuantity()
					+ ", valor unitário: R$ " + itens.getPrice());
		}
		
		daoRequest.close();
	}

}
