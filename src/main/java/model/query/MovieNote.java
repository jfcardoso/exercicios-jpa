package model.query;

public class MovieNote {
	
	//armazena o resultado da consulta da média dos filmes armazenados no DB.
	private double average;
	
	public MovieNote(double average) {
		this.average = average;
	}
	
	public double getAverage() {
		return average;
	}
	
	public void setAverage(double average) {
		this.average = average;
	}

}
