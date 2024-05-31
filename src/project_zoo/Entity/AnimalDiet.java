package project_zoo.Entity;



public class AnimalDiet {
	private int id;
	private int animalId;
	private String breakfast;
	private String lunch;
	private String dinner;
	public AnimalDiet() {
		
	}
	
	public AnimalDiet(int id, int animalId, String breakfast, String lunch, String dinner) {
		this.id = id;
		this.animalId = animalId;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
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
	public String getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}
	public String getLunch() {
		return lunch;
	}
	public void setLunch(String lunch) {
		this.lunch = lunch;
	}
	public String getDinner() {
		return dinner;
	}
	public void setDinner(String dinner) {
		this.dinner = dinner;
	}
	
	
	
	
}
