package model.heritage;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type",
		length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("SD")
public class Student2 {
	
	@Id
	private double matricula;
	
	private String name;
	
	
	public Student2() {
		
	}	
	
	public Student2(double matricula, String name) {
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


