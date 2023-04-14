package models;
import java.time.LocalDate;

public class Employee extends Person{
	//variables
	protected LocalDate contractDate;
	protected String contractNumber;
	
	//constructors
	public Employee() {
		super();
		setContractDate();
		setContractNumber();
	}
	public Employee(String name, String surname, String personCode, LocalDate contractDate) throws Exception {
		super(name, surname, personCode);
		setContractDate(contractDate);
		setContractNumber();
	}
	
	//setters (both variables should not be changed after the contract signing, thus the constructors are set private)
	private void setContractDate() {
		contractDate = LocalDate.now();
	}
	private void setContractDate(LocalDate contractDate) throws Exception {
		if (validateContractDate(contractDate)) {
			try {
				this.contractDate = contractDate;
				return;
			} catch(Exception DateTimeException) {
				throw DateTimeException;
			}
		} else {
			throw new Exception("Date must be after 2023-3-23 and not null, date set to " + LocalDate.now());
		}
	}
	private void setContractNumber() {
		contractNumber = "" + contractDate.getYear() + "_" + name.charAt(0) + "_" + surname.charAt(0); 
	}
	
	//getters
	public LocalDate getContractDate() { 
		return contractDate;
	}
	public String getContractNumber() {
		return contractNumber;
	}
	
	//misc functions
	public boolean validateContractDate(LocalDate contractDate) {
		if (contractDate != null) {
			int year = contractDate.getYear();
			int month = contractDate.getMonthValue();
			int day = contractDate.getDayOfMonth();
			if (year > 2023) {
				return true;
			} else  if (year < 2023) {
				return false;
			} else {
				if (month > 3) {
					return true;
				} else  if (month < 3) {
					return false;
				} else {
					if (day > 24) {
						return true;
					} else  if (day < 24) {
						return false;
					} else {
						return true;
					}
				}
			}
		} return false;
	}
	
	//toString
	public String toString() {
		return "Employee:{" + name + ", " + surname + ", " + personCode + ", " + contractDate + ", " + contractNumber + "}";  
	}
}
