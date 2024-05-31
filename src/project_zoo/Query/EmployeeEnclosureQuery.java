package project_zoo.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project_zoo.Entity.EmployeeEnclosure;
import project_zoo.Utils.connectSql;

public class EmployeeEnclosureQuery {
	public static List<Integer> getByTypeId(int id, String typeId) throws SQLException{
		String sql = "Select * from employee_enclosure where " + typeId + " = " + id;
		Connection conn = connectSql.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		List<Integer> result = new ArrayList<>();
		System.out.println(sql);
		
		String idResult = "";
		if(typeId.equals("employeeid")) {
			idResult = "enclosureid";
		}
		else {
			idResult = "employeeid";
		}
		while(rs.next()) {
			EmployeeEnclosure a= new EmployeeEnclosure();;
			result.add(rs.getInt(idResult));
		}
		return result;
	}
//	public static List<Integer> getById(int id) throws SQLException{
//		String sql = "Select * from employee_enclosure where id = " + id;
//		Connection conn = connectSql.getConnection();
//		Statement st = conn.createStatement();
//		ResultSet rs = st.executeQuery(sql);
//		List<Integer> result = new ArrayList<>();
//		
//		while(rs.next()) {
//			EmployeeEnclosure a= new EmployeeEnclosure();;
//			result.add(rs.getInt(typeId));
//		}
//		return result;
//	}
	public static void add(EmployeeEnclosure data) throws Exception {
		StringBuilder sql = new StringBuilder("insert into employee_enclosure(employeeid, enclosureid) values(");
		sql.append(data.getEmployeeid() + ", ");
		sql.append(data.getEnclosureid() + ")");
		System.out.println(sql.toString());
		Connection conn = connectSql.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql.toString());
	}
	public static void delete(int id, String typeId) throws SQLException {
		
		StringBuilder sql = new StringBuilder("Delete From employee_enclosure Where "+ typeId + " = " + id);
		System.out.println(sql);
		Connection conn = connectSql.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql.toString());
	}

    public static String combine(List<Integer> data) {
    	String str="";
    	for(int x : data) {
    		str += x + ",";
    	}
		if(str.length() >0) {
			str = str.substring(0, str.length()-1);
		}
		return str;
    }
}
