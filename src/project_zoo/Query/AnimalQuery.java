package project_zoo.Query;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import project_zoo.Entity.Animal;
import project_zoo.Entity.Enclosure;
import project_zoo.Utils.connectSql;

public class AnimalQuery {
	public static void add(Animal data) throws Exception {
		StringBuilder sql = new StringBuilder(" insert into animal(name, gender, source, dateofbirth, enclosureid, category) values (");
		sql.append("'" + data.getName() + "'" + ", ");
		sql.append("'" + data.getGender() + "'" + ", ");
		sql.append("'" + data.getSource() + "'" + ", ");
		sql.append("'" + data.getDateOfBirth() + "'" + ", ");
		sql.append( data.getEnclosureid() + ", ");
		sql.append("'" + data.getCategory() + "'" + ")");
		
		System.out.println(sql.toString());
		Connection conn = connectSql.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql.toString());
	}
	public static void delete(int id, String typeId) throws SQLException {
		StringBuilder sql = new StringBuilder("Delete From animal Where " + typeId + " = " + id);
		System.out.println(sql);
		Connection conn = connectSql.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql.toString());
	}
	public static void update(Animal data) throws Exception{
		StringBuilder sql = new StringBuilder("Update animal Set ");
		sql.append(" name = " + "'" + data.getName() + "'" + ", ");
		sql.append(" gender = " + "'" + data.getGender() + "'" + ", ");
		sql.append(" source = " + "'" + data.getSource() + "'" + ", ");
		sql.append(" category = " + "'" + data.getCategory() + "'" + ", ");
		sql.append(" dateofbirth = " + "'" + data.getDateOfBirth() + "', ");
		sql.append(" enclosureid = " + data.getEnclosureid());
		sql.append(" Where id = " + data.getId());
		System.out.println(sql);
			Connection conn = connectSql.getConnection();
			Statement st = conn.createStatement();
			st.executeUpdate(sql.toString());
			
	}

	public static List<Animal> getListAnimal(Animal data) throws Exception {
		StringBuilder sql = new StringBuilder("Select * From animal where 1");
		List<Animal> result = new ArrayList<>();
		
		
		Field[] fields = Animal.class.getDeclaredFields();
		for(Field x : fields) {
			x.setAccessible(true);
			String key = x.getName();
			String value = "";
			if(x.get(data) != null) {
				value = x.get(data).toString();	
			}
			if(value != null && !value.equals("")) {
				if(!key.equals("id") && !value.equals("0")) {
					sql.append(" and " + key + " like '%" + value + "%'");
				}
			}
		}
		
		System.out.println(sql);
		Connection conn = connectSql.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql.toString());
		while(rs.next()) {
			Animal animal = new Animal();
			animal.setId(rs.getInt("id"));
			animal.setCategory(rs.getString("category"));
			animal.setDateOfBirth(rs.getString("dateofbirth"));
			animal.setGender(rs.getString("gender"));
			animal.setName(rs.getString("name"));
			animal.setSource(rs.getString("source"));
			animal.setEnclosureid(rs.getInt("enclosureid"));
			result.add(animal);
		}
		return result;
	}
	
	public static List<Animal> getListAnimalByIdAndTypeId(int id, String typeId) throws SQLException{
		StringBuilder sql = new StringBuilder("Select * From animal where " + typeId + " = " + id );
		List<Animal> result = new ArrayList<>();

		Connection conn = connectSql.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql.toString());
		
			while(rs.next()) {
				Animal animal = new Animal();
				animal.setId(rs.getInt("id"));
				animal.setCategory(rs.getString("category"));
				animal.setDateOfBirth(rs.getString("dateofbirth"));
				animal.setGender(rs.getString("gender"));
				animal.setName(rs.getString("name"));
				animal.setSource(rs.getString("source"));
				animal.setEnclosureid(rs.getInt("enclosureid"));
				result.add(animal);
			}
		
		return result;
	}

}
