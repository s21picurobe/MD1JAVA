package models;
import java.time.LocalDate;
import java.util.ArrayList;

import enumerators.BusCategory;

public class BusDriver extends Employee {
	//variables
	protected ArrayList<BusCategory> busCategories = new ArrayList<>();
	protected int experience;
	
	//constructors
	public BusDriver() {
		super();
		setExperience(-1);
	}
	public BusDriver(String name, String surname, String personCode, LocalDate contractDate, ArrayList<BusCategory> busCategories, int experience) throws Exception{
		super(name, surname, personCode, contractDate);
		setBusCategories(busCategories);
		setExperience(experience);
	}
	
	//setters
	public void setBusCategories(ArrayList<BusCategory> busCategories) {
		if (busCategories !=  null) {
			this.busCategories = busCategories;
		}
	}
	public void setExperience(int experience) {
		if (experience >= 0) {
			this.experience = experience;
		} else {
			this.experience = -1;
		}
	}
	
	//getters
	public LocalDate getContractDate() {
		return contractDate;
	}
	public ArrayList<BusCategory> getBusCategories() {
		return busCategories;
	}
	
	//misc functions
	public boolean addBusCategory(BusCategory busCategory) {
		if (busCategory != null) {
			if (!busCategories.contains(busCategory)) {
				busCategories.add(busCategory);
				return true;
			}
		} return false;
	}
	public boolean removeBusCategory(BusCategory busCategory) {
		try {
			busCategories.remove(busCategories.indexOf(busCategory));
			return true;
		} catch(Exception e){
			return false;
		}
	}
	
	//toString
	public String toString() {
		return "BusDriver:{" + name + ", " + surname + ", " + personCode + ", " + contractDate + ", " + contractNumber + ", " + busCategories + ", " + experience + "}";  
	}
}
