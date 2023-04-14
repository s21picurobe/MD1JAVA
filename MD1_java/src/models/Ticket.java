package models;

import java.time.LocalDateTime;

public class Ticket {
	//variables
	private static int idCounter = 1;
	private int uniqueId;
	private LocalDateTime purchaseDateTime;
	private int discount;
	private boolean vip;
	private float price;
	private Cashier cashier;
	
	//constructors
	public Ticket() {
		setCashier(new Cashier());
		setPrice(0);
		setDiscount(0);
		setVip(false);
		uniqueId = idCounter++;
		purchaseDateTime = LocalDateTime.now();
	}
	public Ticket(float price, int discount, boolean vip, Cashier cashier) {
		setCashier(cashier);
		setPrice(price);
		setDiscount(discount);
		setVip(vip);
		uniqueId = idCounter++;
		purchaseDateTime = LocalDateTime.now();
	}
	
	//setters
	public void setCashier(Cashier cashier) {
		if (cashier != null) {
			this.cashier = cashier;
		} else {
			this.cashier = new Cashier();
		}
	}
	public void setPrice(float price) {
		if (price > 0) {
			this.price = price;
		}
	}
	public void setDiscount(int discount) {
		if (discount > 0) {
			this.discount = discount;
		}
	}
	public void setVip(boolean vip) {
		this.vip = vip;
	}
	
	//getters
	public Cashier getCashier() {
		return cashier;
	}
	public LocalDateTime getPurchaseDateTime() {
		return purchaseDateTime;
	}
	public double getPrice() {
		return price;
	}
	public int getDiscount() {
		return discount;
	}
	public boolean isVip() {
		return vip;
	}
	public int getId() {
		return uniqueId;
	}
	
	//toString
	public String toString() {
		return "Ticket:{" + price + ", " + discount + ", " + vip + ", \u001b[31m" + uniqueId + "\u001b[0m, " + purchaseDateTime + ", " + cashier + "}";
	}
}
