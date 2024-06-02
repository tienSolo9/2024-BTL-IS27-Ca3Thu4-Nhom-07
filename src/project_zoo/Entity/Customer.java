package project_zoo.Entity;

import java.util.Date;

public class Customer extends Person{
	private Integer id;
	private String entryDate;
	private String type;
	private Double price;
	
	public Customer() {
		super();
	}
	public Customer(String name, String phone, String dateOfBirth, int id, String gender, String entryDate, String type) {
		super(name, phone, dateOfBirth,gender);
		this.id = id;
		this.entryDate = entryDate;
		this.type = type;
		this.price = 0.0;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
		
		if(type != null) {
			if(type.equals("người lớn")) {
				this.price = 100.0;
			}
			else {
				this.price = 50.0;
			}
		}
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}
