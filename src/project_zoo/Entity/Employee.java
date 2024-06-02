package project_zoo.Entity;

public class Employee extends Person{
	private int id;
	private String shift;
	private String dateOfJoining;
	private String designation;
	private String username;
	private String password;
	private double salary;

	public Employee(){
		super();
	}
	public Employee(String name, String phone, String dateOfBirth, int id, String shift,
			String dateOfJoining, String designation, String username, String password, String gender) {
		super(name, phone, dateOfBirth,gender);
		this.id = id;
		this.shift = shift;
		this.dateOfJoining = dateOfJoining;
		this.designation = designation;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}


	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", shift=" + shift + ", dateOfJoining=" + dateOfJoining + ", designation="
				+ designation + ", username=" + username + ", password=" + password + "]";
	}

	
}
