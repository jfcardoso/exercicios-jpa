package model.heritage;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Student {
	
	@Id
	private double matricula;
	
	private String name;
	
	
	public Student() {
		
	}	
	
	public Student(double matricula, String name) {
		this.matricula = matricula;
		this.name = name;
	}

	public double getMatricula() {
		return matricula;
	}

	public void setMatricula(double matricula) {
		this.matricula = matricula;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
