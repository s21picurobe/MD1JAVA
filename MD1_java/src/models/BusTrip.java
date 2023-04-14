package models;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

import enumerators.BusCategory;

public class BusTrip {
	//variables
	private static int idCounter = 1;
	private int uniqueId;
	private int seats;
	private int ticketCount = 0;
	public PriorityQueue<Ticket> tickets = new PriorityQueue<>(15, new TicketComparator());
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	private Station fromStation;
	private Station toStation;
	private BusDriver busDriver;
	
	//constructors
	public BusTrip() throws Exception {
		uniqueId = idCounter++;
		setSeats(30);
		setFromDateTime(LocalDateTime.now());
		setToDateTime(LocalDateTime.now());
		setFromStation(new Station());
		setToStation(new Station());
		setBusDriver(new BusDriver());

	}
	
	//setters
	public void setSeats(int seats) {
		if (seats > 0) {
			this.seats = seats;
		} else { 
			this.seats = 0;
		}
	}
	public void setFromDateTime(LocalDateTime fromDateTime) throws Exception {
		if (fromDateTime != null && LocalDateTime.now().plusDays(1).isBefore(fromDateTime)) {
			this.fromDateTime = fromDateTime;
		} else {
			this.fromDateTime = LocalDateTime.now().plusDays(1);
			try {
				throw(new Exception("Departure dateTime must be atleast 1 day from now and not null, departure dateTime set to " + this.fromDateTime));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	public void setToDateTime(LocalDateTime toDateTime) throws Exception {
		if (toDateTime != null && toDateTime.isAfter(fromDateTime)) {
			this.toDateTime = toDateTime;
		} else {
			this.toDateTime = fromDateTime.plusDays(1);
			try {
				throw(new Exception("Arrival dateTime must be after the departure dateTime and not null, arrival dateTime set to " + this.toDateTime));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	public void setFromStation(Station fromStation) {
		if (fromStation != null) {
			this.fromStation = fromStation;
		} else {
			this.fromStation = new Station();
		}
	}
	public void setToStation(Station toStation) {
		if (toStation != null && toStation.getId() != fromStation.getId()) {
			this.toStation = toStation;
		} else {
			this.toStation = new Station();
		}
	}
	public void setBusDriver(BusDriver busDriver) {
		if (busDriver != null) { 
			if (busDriver.getBusCategories().contains(BusCategory.largebus) || (busDriver.getBusCategories().contains(BusCategory.minibus) && seats < 30)) {
				this.busDriver = busDriver;
			} else {
				BusDriver tempBusDriver = new BusDriver();
				tempBusDriver.addBusCategory(BusCategory.largebus);
				this.busDriver = tempBusDriver;
			}
		}
	}
	
	//getters 
	public PriorityQueue<Ticket> getTickets() {
		return tickets;
	}
	
	//misc functions
	public void addTicket(Ticket ticket) {
		if (ticket != null && ticketCount < seats && !tickets.contains(ticket)) {
			tickets.add(ticket);
			ticketCount++;
		}
	}
	
	//toString()
	public String toString() {
		return "BusTrip{" + seats + ", " + fromDateTime + ", " + toDateTime + ", " + fromStation + ", " + toStation + ", " + busDriver + "}";
	}
	
	
}
