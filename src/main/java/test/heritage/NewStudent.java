package test.heritage;

import Infra.DAO;
import model.heritage.ScholarshipStudent;
import model.heritage.Student2;

public class NewStudent {
	
	public static void main(String[] args) {
		
		DAO<Student2> studentDAO = new DAO<>();
		
		Student2 student = new Student2(1234,"Jefferson Cardoso");
		ScholarshipStudent felowStudent =
				new ScholarshipStudent(4321,"Heitor Labre", 700.00);
		
		studentDAO.addEntityWithTransaction(student);
		studentDAO.addEntityWithTransaction(felowStudent);
		
		studentDAO.close();
		
	}

}
