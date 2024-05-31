package project_zoo.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project_zoo.Entity.AnimalDiet;
import project_zoo.Utils.connectSql;

public class AnimalDietQuery {
    public static void add(AnimalDiet data) throws SQLException {
        StringBuilder sql = new StringBuilder("insert into animal_diet(animalId, breakfast, lunch, dinner) values (");
        sql.append(data.getAnimalId() + ", ");
        sql.append("'" + data.getBreakfast() + "'" + ", ");
        sql.append("'" + data.getLunch() + "'" + ", ");
        sql.append("'" + data.getDinner() + "'" + ")");

        Connection conn = connectSql.getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql.toString());
        System.out.println(sql.toString());
    }

    public static void delete(int id, String typeId) throws SQLException {
        StringBuilder sql = new StringBuilder("delete from animal_diet where " + typeId + "=" + id);
        System.out.println(sql.toString());
        Connection conn = connectSql.getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql.toString());        
    }

    public static void update(AnimalDiet data) throws SQLException {
        StringBuilder sql = new StringBuilder("update animal_diet set ");
        sql.append("animalId = " + data.getAnimalId() + ", ");
        sql.append("breakfast = " + "'" + data.getBreakfast() + "'" + ", ");
        sql.append("lunch = " + "'" + data.getLunch() + "'" + ", ");
        sql.append("dinner = " + "'" + data.getDinner() + "'");

        sql.append(" where id = " + data.getId());

        Connection conn = connectSql.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(sql.toString());
        System.out.println(sql);
    }

    public static List<AnimalDiet> getListAnimalDiet() throws SQLException {
        StringBuilder sql = new StringBuilder("select * from animal_diet");
        List<AnimalDiet> result = new ArrayList<>();

        Connection conn = connectSql.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql.toString());

        while (rs.next()) {
            AnimalDiet ad = new AnimalDiet();
            ad.setId(rs.getInt("id"));
            ad.setAnimalId(rs.getInt("animalId"));
            ad.setBreakfast(rs.getString("breakfast"));
            ad.setLunch(rs.getString("lunch"));
            ad.setDinner(rs.getString("dinner"));
            result.add(ad);
        }

        return result;
    }
    public static double getPrice(String type, String month, String year) throws SQLException, Exception{
    	if(month.length() == 1) {
        	month = "0" + month;
        }
        String sql = "select sum(b.price) as sum from animal_diet a join food b On a." + type + " = b.id"
        		+ " where a.time like '%" + year + "-" +month+"%'";
            
        Connection conn = connectSql.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        double result=0;
        while(rs.next()) {
        	result += rs.getDouble("sum");
        }	
        return result;
    }
    public static double getAllPrice(String month, String year) throws SQLException, Exception{
    	double breakfast = getPrice("breakfast",month,year);
    	double lunch = getPrice("lunch",month,year);
    	double dinner = getPrice("dinner",month,year);
    	double total = breakfast + lunch + dinner;
    	return total;
    }
}