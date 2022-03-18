package model.umpraum;

import Infra.DAO;

public class GetClientSeat {
	
	public static void main(String[] args) {
		
		DAO<Client> clientDAO = new DAO<>(Client.class);
		
		Client client = clientDAO.getEntityByID(1L);
		
		System.out.println("Cliente: " + client.getName()
					+ ", assento: " + client.getSeat().getName());
		
		clientDAO.close();
	}

}
