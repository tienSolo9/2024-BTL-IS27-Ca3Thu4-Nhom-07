package project_zoo.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project_zoo.Entity.AnimalHealth;
import project_zoo.Utils.connectSql;

public class AnimalHealthQuery {
    public static void add(AnimalHealth data) throws SQLException {
        StringBuilder sql = new StringBuilder("insert into animal_health(animalId, doctorId, disease, medicine) values (");
        sql.append(data.getAnimalId() + ", ");
        sql.append(data.getDoctorId() + ", ");
        sql.append("'" + data.getDisease() + "'" + ", ");
        sql.append("'" + data.getMedicine() + "'" + ")");

        Connection conn = connectSql.getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql.toString());
        System.out.println(sql.toString());
    }

    public static void delete(int id, String typeId) throws SQLException {
        StringBuilder sql = new StringBuilder("delete from animal_health where "+ typeId + " = " + id);

        System.out.println(sql.toString());
        Connection conn = connectSql.getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql.toString());
        
    }

    public static void update(AnimalHealth data) throws SQLException {
        StringBuilder sql = new StringBuilder("update animal_health set ");
        sql.append("animalId = " + data.getAnimalId() + ", ");
        sql.append("doctorId = " + data.getDoctorId() + ", ");
        sql.append("disease = " + "'" + data.getDisease() + "'" + ", ");
        sql.append("medicine = " + "'" + data.getMedicine() + "'");

        sql.append(" where id = " + data.getId());

        Connection conn = connectSql.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(sql.toString());
        System.out.println(sql);
    }

    public static List<AnimalHealth> getListAnimalHealth() throws SQLException {
        StringBuilder sql = new StringBuilder("select * from animal_health");
        List<AnimalHealth> result = new ArrayList<>();

        Connection conn = connectSql.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql.toString());

        while (rs.next()) {
            AnimalHealth ah = new AnimalHealth();
            ah.setId(rs.getInt("id"));
            ah.setAnimalId(rs.getInt("animalId"));
            ah.setDoctorId(rs.getInt("doctorId"));
            ah.setDateOfCheckup(rs.getString("dateOfCheckup"));
            ah.setDisease(rs.getString("disease"));
            ah.setMedicine(rs.getString("medicine"));
            result.add(ah);
        }

        return result;
    }
    public static List<String> getPriceAndCount(String month, String year) throws SQLException{
    	 StringBuilder sql = new StringBuilder("select count(a.id), sum(b.price) from animal_health a join medicine b on a.medicine = b.id "
    	 		+ "and a.dateofcheckup like '%" + year +"-" + month+"%'");
         List<String> result = new ArrayList<>();

         Connection conn = connectSql.getConnection();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql.toString());
         while(rs.next()) {
        	 result.add(rs.getInt(1)+"");
        	 result.add(rs.getInt(2)+"");
         }
         return result;
    }
}