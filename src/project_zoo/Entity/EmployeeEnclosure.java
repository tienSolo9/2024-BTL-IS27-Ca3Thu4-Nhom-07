package project_zoo.Entity;

public class EmployeeEnclosure {
	private int id;
	private int enclosureid;
	private int employeeid;
	private String startDate;
	private String EndDate;
	public EmployeeEnclosure() {
		
	}
	public EmployeeEnclosure(int id, int enclosureid, int employeeid, String startDate, String endDate) {
		super();
		this.id = id;
		this.enclosureid = enclosureid;
		this.employeeid = employeeid;
		this.startDate = startDate;
		EndDate = endDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEnclosureid() {
		return enclosureid;
	}
	public void setEnclosureid(int enclosureid) {
		this.enclosureid = enclosureid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	
	
}
