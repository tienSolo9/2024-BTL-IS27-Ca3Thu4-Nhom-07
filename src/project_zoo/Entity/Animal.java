package project_zoo.Entity;

public class Animal{
	private int id;
	private int enclosureid;
	private String gender;
	private String name;
	private String source;
	private String category;
	private String dateOfBirth;
	
	public Animal() {
		
	}
	
	
	public Animal(int id, int enclosureid, String gender, String name, String source, String category,
			String dateOfBirth) {
		super();
		this.id = id;
		this.enclosureid = enclosureid;
		this.gender = gender;
		this.name = name;
		this.source = source;
		this.category = category;
		this.dateOfBirth = dateOfBirth;
	}


	public int getEnclosureid() {
		return enclosureid;
	}


	public void setEnclosureid(int enclosureid) {
		this.enclosureid = enclosureid;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Animal [id=" + id + ", gender=" + gender + ", name=" + name + ", source=" + source + ", category="
				+ category + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}
