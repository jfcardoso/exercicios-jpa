package test.basic.umpraum;

import Infra.DAO;
import model.umpraum.Client;
import model.umpraum.Seat;

public class NewClientSeat1 {
	
	public static void main(String[] args) {
		
		//Escolhendo o assento:
		Seat seat = new Seat("23F");
		
		//Associando o assento ao cliente:
		Client client =  new Client("Ronald Reagan", seat);
		
		//agora persistindo os dados no DB:
		// uma opção é usar um DAO Genérico:
		DAO<Object> dao = new DAO<>();
		
		dao.openTransaction()
		   .addEntity(seat)
		   .addEntity(client)
		   .closeTransaction()
		   .close();
	}

}
