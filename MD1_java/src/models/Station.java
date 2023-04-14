package models;
import enumerators.City;

public class Station {
	//variables
	private static int idCounter = 1;
	private int uniqueId;
	private City city = City.Default;
	private String title;
	private String workingHours;
	
	//constructors
	public Station() {
		setCity(City.Default);
		setTitle("Default");
		setWorkingHours("00:00-00:00");
		uniqueId = idCounter++;
	}
	public Station(City city, String title, String workingHours) {
		setCity(city);
		setTitle(title);
		setWorkingHours(workingHours);
		uniqueId = idCounter++;
	}
	
	//setters
	public void setCity(City city) {
		if(city != null) {
			this.city = city;
		}
	}
	public void setTitle(String title) {
		if (title != null && title.matches("[A-ZĀĒŪĪŠĢĶĻŽŅČ][a-zāēūīšģķļžņč]+")) {
			this.title = title;
		}
	}
	public void setWorkingHours(String workingHours) {
		if (workingHours != null && workingHours.matches("[0,1,2]((?<=2)[0,1,2,3]|(?<!2)[\\d])[\\:][0-5][0-9][\\-][0,1,2]((?<=2)[0,1,2,3]|(?<!2)[\\d])[\\:][0-5][0-9]")) {
			this.workingHours = workingHours;
		} else {
			this.workingHours = "00:00-00:00";
		}
	}
	
	//getters
	public City getCity() {
		return city;
	}
	public String getTitle() {
		return title;
	}
	public String getWorkingHours() {
		return workingHours;
	}
	public int getId() {
		return uniqueId;
	}
	
	//toString
	public String toString() {
		return "Station:{" + city + ", " + title + ", " + workingHours + ", " + uniqueId + "}";
	}
	
	
	
}
