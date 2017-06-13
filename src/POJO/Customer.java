package POJO;

public class Customer {
	private String custName;

	public Customer() {
		super();
	}

	public Customer(String custName) {
		super();
		this.custName = custName;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}
	
}
