package project_zoo.Entity;

import java.util.Date;

public class AnimalHealth {
	private int id;
	private int animalId;
	private int doctorId;
	private String dateOfCheckup;
	private String disease;
	private String medicine;
	
	public AnimalHealth() {
		
	}
	
	public AnimalHealth(int id, int animalId, int doctorId, String dateOfCheckup, String disease, String medicine) {
		this.id = id;
		this.animalId = animalId;
		this.doctorId = doctorId;
		this.dateOfCheckup = dateOfCheckup;
		this.disease = disease;
		this.medicine = medicine;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnimalId() {
		return animalId;
	}
	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDateOfCheckup() {
		return dateOfCheckup;
	}
	public void setDateOfCheckup(String dateOfCheckup) {
		this.dateOfCheckup = dateOfCheckup;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	
	
}
