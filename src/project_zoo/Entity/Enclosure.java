package project_zoo.Entity;

public class Enclosure {
	private int id;
	private String name;
	private	Double area;
	private String category;
	private String status;
	
	public Enclosure() {
		
	}
	
	public Enclosure(int id, String name, Double area, String category, String status) {
		super();
		this.id = id;
		this.name = name;
		this.area = area;
		this.category = category;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Enclosure [id=" + id + ", name=" + name + ", area=" + area + ", category=" + category + ", status="
				+ status + "]";
	}

	
}
