package models;

import java.time.LocalDate;

public class Cashier extends Employee {
	//variables
	private static int idCounter = 1;
	private int uniqueId;
	
	//constructors
	public Cashier() {
		super();
		uniqueId = idCounter++;
	}
	
	public Cashier(String name, String surname, String personCode, LocalDate contractDate) throws Exception {
		super(name, surname, personCode, contractDate);
		uniqueId = idCounter++;
	}
	
	//getters
	public int getId() {
		return uniqueId;
	}
	//toString
	public String toString() {
		return "Employee:{" + name + ", " + surname + ", " + personCode + ", " + contractDate + ", " + contractNumber + ", " + uniqueId + "}";  
	}
}
