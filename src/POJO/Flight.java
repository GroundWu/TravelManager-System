package POJO;

public class Flight {
	private String filghtNum;
	private int price;
	private int numSeats;
	private int numAvail;
	private String FromCity;
	private String AvrivCity;
	
	public Flight(){
		super();
	}
	public Flight(String filghtNum, int price, int numSeats, int numAvail, String fromCity, String avrivCity) {
		super();
		this.filghtNum = filghtNum;
		this.price = price;
		this.numSeats = numSeats;
		this.numAvail = numAvail;
		FromCity = fromCity;
		AvrivCity = avrivCity;
	}
	
	public String getFilghtNum() {
		return filghtNum;
	}
	public void setFilghtNum(String filghtNum) {
		this.filghtNum = filghtNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNumSeats() {
		return numSeats;
	}
	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}
	public int getNumAvail() {
		return numAvail;
	}
	public void setNumAvail(int numAvail) {
		this.numAvail = numAvail;
	}
	public String getFromCity() {
		return FromCity;
	}
	public void setFromCity(String fromCity) {
		FromCity = fromCity;
	}
	public String getAvrivCity() {
		return AvrivCity;
	}
	public void setAvrivCity(String avrivCity) {
		AvrivCity = avrivCity;
	}
	
}
