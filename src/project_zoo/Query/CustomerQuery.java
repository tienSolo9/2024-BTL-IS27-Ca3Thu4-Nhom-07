package project_zoo.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project_zoo.Entity.Customer;
import project_zoo.Utils.connectSql;

public class CustomerQuery {

    public static void add(Customer data) throws SQLException {
        StringBuilder sql = new StringBuilder("insert into customer(name, phone, dateOfBirth, gender,price,type) values (");
        sql.append("'" + data.getName() + "'" + ", ");
        sql.append("'" + data.getPhone() + "'" + ", ");
        sql.append("'" + data.getDateOfBirth() + "'" + ", ");
        sql.append("'" + data.getGender() + "'" + ", ");
        sql.append( data.getPrice()+ ", ");
        sql.append("'" + data.getType() + "'" + ")");

        Connection conn = connectSql.getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql.toString());
        System.out.println(sql.toString());
    }

    public static void delete(int id) throws SQLException {
        StringBuilder sql = new StringBuilder("delete from customer where id = " + id);

        Connection conn = connectSql.getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql.toString());
        System.out.println(sql.toString());
    }

    public static void update(Customer data) throws SQLException, Exception {
        StringBuilder sql = new StringBuilder("update customer set ");
        sql.append("name = " + "'" + data.getName() + "'" + ", ");
        sql.append("phone = " + "'" + data.getPhone() + "'" + ", ");
        sql.append("dateOfBirth = " + "'" + data.getDateOfBirth() + "'" + ", ");
        sql.append("entryDate = " + "'" + data.getEntryDate() + "'" + ", ");
        sql.append("type = " + "'" + data.getType() + "'" + ", ");
        sql.append("gender = " + "'" + data.getGender() + "'" + ",");
        sql.append("price = " + "'" + data.getPrice()+ "'");
        sql.append(" where id = " + data.getId());

        Connection conn = connectSql.getConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(sql.toString());
        System.out.println(sql);
    }

    public static List<Customer> getListCustomer() throws SQLException {
        StringBuilder sql = new StringBuilder("select * from customer");
        List<Customer> result = new ArrayList<>();

        Connection conn = connectSql.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql.toString());

        while (rs.next()) {
            Customer c = new Customer(null, null, null, 0, null, null, null);
            c.setId(rs.getInt("id"));
            c.setEntryDate(rs.getString("entryDate"));
            c.setPhone(rs.getString("phone"));
            c.setName(rs.getString("name"));
            c.setType(rs.getString("type"));
            c.setGender(rs.getString("gender"));
			if(c.getType().equals("người lớn")) {
				c.setPrice(100.0);
			}
			else {
				c.setPrice(50.0);
			}
            c.setDateOfBirth(rs.getString("dateOfBirth"));
            result.add(c);
        }

        return result;
    }
    
    public static List<String> getAllPriceTicket(String month, String year){
    	int qTicket=0, qTicketAdult=0, qTicketChild=0;
    	double total=0;
    	List<String> result = new ArrayList<>();
    	
    	if(month.length() == 1) {
        	month = "0" + month;
        }
    	String sql = "select type, price From customer where entrydate like '%" + year +"-" + month+"%'";

    	try {
            Connection conn = connectSql.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
				total += rs.getDouble(2);
				if(rs.getString(1).equals("người lớn")) {
					qTicketAdult++;
				}
				else {
					qTicketChild++;
				}
            }
			qTicket = qTicketAdult + qTicketChild;
			result.add(qTicket+"");
			result.add(qTicketChild+"");
			result.add(qTicketAdult+"");
			result.add(total+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return result;
    }

}