package POJO;

public class Hotel {
	private String location;
	private int price;
	private int numRooms;
	private int numAvail;
	
	public Hotel() {
		super();
	}
	public Hotel(String location, int price, int numRooms, int numAvail) {
		super();
		this.location = location;
		this.price = price;
		this.numRooms = numRooms;
		this.numAvail = numAvail;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumRooms() {
		return numRooms;
	}
	public void setNumRooms(int numRooms) {
		this.numRooms = numRooms;
	}
	public int getNumAvail() {
		return numAvail;
	}
	public void setNumAvail(int numAvail) {
		this.numAvail = numAvail;
	}
	
	
}
