package project_zoo.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import project_zoo.Entity.Enclosure;
import project_zoo.Utils.connectSql;

public class EnclosureQuery {
	public static List<Enclosure> getAllEnclosure() throws Exception{
		String sql = "Select * From enclosure";
		
		Connection connect = connectSql.getConnection();
		Statement st = connect.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		System.out.println(sql);
		List<Enclosure> result = new ArrayList<>();
		while(rs.next()) {
			Enclosure a = new Enclosure();
			a.setArea(rs.getDouble("area"));
			a.setId(rs.getInt("id"));
			a.setName(rs.getString("name"));
			a.setCategory(rs.getString("category"));
			a.setStatus(rs.getString("status"));
			result.add(a);
		}
		return result;
	}
	
	public static void add(Enclosure data) throws Exception{
		String sql = "insert into enclosure(name,area,category,status) value(";
		sql += "'" + data.getName() + "'" + ", ";
		sql += "" + data.getArea() + "" + ", ";
		sql += "'" + data.getCategory() + "'" + ", ";
		sql += "'" + data.getStatus() + "'" + ") ";
		System.out.println(sql);
		Connection conn = connectSql.getConnection();
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
	}
	
	public static void Update(Enclosure data) throws Exception{
		String sql = "update enclosure set ";
		sql += " name = " + "'" + data.getName() + "'" + ", ";
		sql += " area = " + "'" + data.getArea() + "'" + ", ";
		sql += " category = " + "'" + data.getCategory() + "'" + ", ";
		sql += " status = " + "'" + data.getStatus() + "' where id = " + data.getId();
		System.out.println(sql);
		Connection conn = connectSql.getConnection();
		Statement st = conn.createStatement();
		st.executeUpdate(sql);
	}
	public static void delete(int id) throws Exception{
		String sql = "Delete From enclosure where id = " + id;
		
		//xoa kn
		AnimalQuery.delete(id,"enclosureid");
		EmployeeEnclosureQuery.delete(id, "enclosureid");
		System.out.println(sql);
		Connection conn = connectSql.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql.toString());
	}
	
	public static void isExists(int id) throws Exception{
		String sql = "Select * From enclosure where id = " + id;
		
		Connection conn = connectSql.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(!rs.next()) {
			throw new Exception();
		}
	}

}