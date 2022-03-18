package test.basic.muitospramuitos;

import Infra.DAO;
import model.muitospramuitos.Nephew;
import model.muitospramuitos.Uncle;

public class NewUncleNephew {

	public static void main(String[] args) {
		
		Uncle uncle1 = new Uncle("José Carlos Labre");
		Uncle uncle2 = new Uncle("Pedro Henrique Labre");
		
		Nephew nephew1 = new Nephew("Gustavo Labre Silva");
		Nephew nephew2 = new Nephew("Miguel Ximenes Labre");
		
		// relacionamento bidirecional: Tio 1 com os dois sobrinhos
		uncle1.getNephews().add(nephew1);
		nephew1.getUncles().add(uncle1);
		
		uncle1.getNephews().add(nephew2);
		nephew2.getUncles().add(uncle1);
		
		// relacionamento bidirecional: Tio 2 com os dois sobrinhos
		uncle2.getNephews().add(nephew1);
		nephew1.getUncles().add(uncle2);
		
		uncle2.getNephews().add(nephew2);
		nephew2.getUncles().add(uncle2);
		
		// persinstindo os dados no banco:
		DAO<Object> dao = new DAO<>();
		
		dao.openTransaction().addEntity(uncle1)
							 .addEntity(uncle2)
							 .addEntity(nephew1)
							 .addEntity(nephew2)
							 .closeTransaction().close();
		
		
	}
}
