package model.heritage;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SS")
public class ScholarshipStudent extends Student2 {	
	
	private double scholarshipAmount;
	
	public ScholarshipStudent() {
		
	}
	
	public ScholarshipStudent(double matricula, String name, double scholarshipAmount) {
		super(matricula, name);
		this.scholarshipAmount = scholarshipAmount;		
	}

	public double getScholarshipAmount() {
		return scholarshipAmount;
	}

	public void setScholarshipAmount(double scholarshipAmount) {
		this.scholarshipAmount = scholarshipAmount;
	}	
	
}
