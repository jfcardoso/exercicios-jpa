package test.basic.umpraum;

import Infra.DAO;
import model.umpraum.Client;
import model.umpraum.Seat;

public class NewClientSeat2 {
	
	public static void main(String[] args) {
		
		Seat seat = new Seat("4F");
		Client client = new Client("Pedro de Lara", seat);		
		DAO<Client> clientDAO = new DAO<>(Client.class);
		
		clientDAO.addEntityWithTransaction(client);
	}

}
