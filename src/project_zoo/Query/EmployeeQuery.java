package project_zoo.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import project_zoo.Entity.Employee;
import project_zoo.Utils.connectSql;
public class EmployeeQuery {
	public static void add(Employee data) throws SQLException{
		StringBuilder sql = new StringBuilder(" insert into employee(name, phone, dateOfBirth, shift, dateOfJoining, designation, username,password,gender) values (");
		sql.append("'" + data.getName() + "'" + ", ");
		sql.append("'" + data.getPhone() + "'" + ", ");
		sql.append("'" + data.getDateOfBirth() + "'" + ", ");
		sql.append("'" + data.getShift() + "'" + ",");
		sql.append("'" + data.getDateOfJoining() + "'" + ",");
		sql.append("'" + data.getDesignation() + "'" + ",");
		sql.append("'" + data.getUsername() + "'" + ",");
		sql.append("'" + data.getPassword() + "'" + ",");
		sql.append("'" + data.getGender() + "'" + ")");
				
		
			Connection conn = connectSql.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql.toString());
			System.out.println(sql.toString());
	}
	
	public static void delete(int id) throws SQLException {
			StringBuilder sql = new StringBuilder("Delete From employee Where id = " + id);	
			Connection conn = connectSql.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql.toString());
			System.out.println(sql.toString());
	}
	public static void update(Employee data) throws SQLException  , Exception{
		StringBuilder sql = new StringBuilder("Update employee Set ");
		sql.append(" name = " + "'" + data.getName() + "'" + ", ");
		sql.append(" phone = " + "'" + data.getPhone() + "'" + ", ");
		sql.append(" dateOfBirth = " + "'" + data.getDateOfBirth() + "'" + ", ");
		sql.append(" shift = " + "'" + data.getShift() + "'" + ",");
		sql.append(" dateOfJoining = " + "'" + data.getDateOfJoining() + "'" + ",");
		sql.append(" designation = " + "'" + data.getDesignation() + "'" + ",");
		sql.append(" username = " + "'" + data.getUsername() + "'" + ",");
		sql.append(" gender = " + "'" + data.getGender() + "'" + ",");
		sql.append(" password = " + "'" + data.getPassword() + "'");
		
		sql.append(" Where id = " + data.getId());
		
			Connection conn = connectSql.getConnection();
			Statement st = conn.createStatement();
			st.executeUpdate(sql.toString());
			System.out.println(sql);
	}
	
	public static List<Employee> getListEmployee(Employee data) throws SQLException{
		StringBuilder sql = new StringBuilder("Select * From employee where 1");
		List<Employee> result = new ArrayList<>();
		
		if(data.getName() != null) {
			sql.append(" and " + "name like '%"  + data.getName() + "%'");
		}
		if(data.getPhone() != null) {
			sql.append(" and " + "phone like '%"  + data.getPhone() + "%'");
		}
		if(data.getShift() != null) {
			sql.append(" and " + "shift like '%"  + data.getShift() + "%'");
		}
		if(data.getDesignation() != null) {
			sql.append(" and " + "designation like '%"  + data.getDesignation() + "%'");
		}
			Connection conn = connectSql.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql.toString());
			
			 
			while(rs.next()) {
				Employee e = new Employee(null, null, null, 0, null, null, null, null, null, null);
				e.setId(rs.getInt("id"));
				e.setShift(rs.getString("shift"));
				e.setDateOfBirth(rs.getString("dateofbirth"));
				e.setDateOfJoining(rs.getString("dateofjoining"));
				e.setPhone(rs.getString("phone"));
				e.setName(rs.getString("name"));
				e.setDesignation(rs.getString("designation"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				e.setGender(rs.getString("gender"));
				e.setSalary(rs.getDouble("salary"));
				result.add(e);
			}
		
		return result;
	}
	
	public static String getListEnclosureManagedById(int id) throws SQLException{
		String sql = "Select enclosureid from employee_enclosure where employeeid = " + id;
		Connection conn = connectSql.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		String result="";
		while(rs.next()) {
			result += rs.getString("enclosureid") + ",";
		}
		if(result.length() >0) {
			result = result.substring(0, result.length()-2);
		}
		
		return result;
	}
	
	public static void isExists(int id) throws Exception{
		String sql = "Select * From employee where id = " + id;
		
		Connection conn = connectSql.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(!rs.next()) {
			throw new Exception();
		}
	}
	public static List<String> getAllSalaryAndCount(String month, String year){
		List<String> result = new ArrayList<>();
		String sql = "select count(id), sum(salary) From employee";
		try {
			Connection conn = connectSql.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				result.add(rs.getInt(1)+"");
				result.add(rs.getInt(2)+"");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}