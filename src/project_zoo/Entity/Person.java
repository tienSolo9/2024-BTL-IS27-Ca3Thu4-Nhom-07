package project_zoo.Entity;

import java.util.Date;

public class Person {
	private String name;
	private String phone;
	private String dateOfBirth;
	private String gender;
	

	public Person(String name, String phone, String dateOfBirth, String gender) {
		this.name = name;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", phone=" + phone + ", dateOfBirth=" + dateOfBirth + "]";
	}

	
}
