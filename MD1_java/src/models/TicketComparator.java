package models;

import java.util.Comparator;

public class TicketComparator implements Comparator<Ticket>{
	@Override
	public int compare(Ticket t1, Ticket t2) {
		if (t1.isVip() && !t2.isVip()) {;
			return -1;
		}
		if (!t1.isVip() && t2.isVip()) {
			return 1;
		}
		return  0;
		
	}
}
