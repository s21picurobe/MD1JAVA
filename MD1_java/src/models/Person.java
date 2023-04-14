package models;

public class Person {
	//variables
	protected String name;
	protected String surname;
	protected String personCode;
	
	//constructors
	public Person() {
		setName("Default");
		setSurname("Default");
		setPersonCode("000000-00000");
	}
	public Person(String name, String surname, String personCode) { 
		setName(name);
		setSurname(surname);
		setPersonCode(personCode);
	}

	//setters
	public void  setName(String name) {
			if (name!= null && name.matches("[A-ZĀĒŪĪŠĢĶĻŽŅČ]{1}[a-zāēūīšģķļžņč]+[ ]?([A-ZĀĒŪĪŠĢĶĻŽŅČ]{1}[a-zāēūīšģķļžņč]+)?")) {
				this.name = name;
			} else {
				this.name = "Default";
			}
	}
	public void  setSurname(String surname) {
			if (surname != null && surname.length() > 0 && name.matches("[A-ZĀĒŪĪŠĢĶĻŽŅČ]{1}[a-zāēūīšģķļžņč]+([-][A-ZĀĒŪĪŠĢĶĻŽŅČ]{1}[a-zāēūīšģķļžņč]+)?")) {
				this.surname = surname;
			} else {
				this.surname = "Default";
			}
	}
	public void  setPersonCode(String personCode) {
		if (personCode != null && personCode.matches("([0-9]{6}[-][0-9]{5})")) {
			this.personCode = personCode;
		} else {
			this.personCode = "000000-00000";
		}
	}
	
	//getters
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getPersonCode() {
		return personCode;
	}
	
	//toString
	public String toString() {
		return "Person:{" + name + ", " + surname + ", " + personCode + "}";  
	}
}
