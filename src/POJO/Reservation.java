package POJO;

public class Reservation {
	private String custName;
	private int resvType;
	private int resvKey;
	private String detail;
	
	public Reservation() {
		super();
	}
	public Reservation(String custName, int resvType, int resvKey, String detail) {
		super();
		this.custName = custName;
		this.resvType = resvType;
		this.resvKey = resvKey;
		this.detail = detail;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public int getResvType() {
		return resvType;
	}
	public void setResvType(int resvType) {
		this.resvType = resvType;
	}
	public int getResvKey() {
		return resvKey;
	}
	public void setResvKey(int resvKey) {
		this.resvKey = resvKey;
	}
	
	
}
