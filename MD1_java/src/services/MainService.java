package services;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import enumerators.BusCategory;
import enumerators.City;
import models.Employee;
import models.BusDriver;
import models.Cashier;
import models.Station;
import models.Ticket;
import models.BusTrip;

public class MainService {

	public static ArrayList<BusTrip> busTripList = new ArrayList<>();
	public static ArrayList<Employee> employeeList = new ArrayList<>();
	public static ArrayList<Station> stationList = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		addCashier(new Cashier());
		addCashier(new Cashier("John", "Doe", "091002-20782", LocalDate.now()));
		deleteCashier("091002-20782");
		System.out.println(getCashier("091002-20782"));
		System.out.println(employeeList);
		
		Station station = new Station(City.Jelgava, "Title", "19:00-23:59");
		System.out.println(station);
	}
	
	public static boolean addCashier(Cashier cashier) {
		for (int i = 0; i < employeeList.size(); i++) {
			if (cashier.getPersonCode() == employeeList.get(i).getPersonCode()) {
				return false;
			}
		}
		employeeList.add(cashier);
		return true;
	}
	public static Cashier getCashier(String personCode) {
		for (int i = 0; i < employeeList.size(); i++) {
			if (personCode == employeeList.get(i).getPersonCode()) {
				return (Cashier) employeeList.get(i);
			}
		}
		return null;
	}
	public static boolean editCashier(String personCode, String name, String surname) {
		for (int i = 0; i < employeeList.size(); i++) {
			if (personCode == employeeList.get(i).getPersonCode()) {
				employeeList.get(i).setName(name);
				employeeList.get(i).setSurname(surname);
				return true;
			}
		}
		return false;
	}
	public static boolean deleteCashier(String personCode) {
		for (int i = 0; i < employeeList.size(); i++) {
			if (personCode == employeeList.get(i).getPersonCode()) {
				employeeList.remove(i);
				return true;
			}
		}
		return false;
	}
}
