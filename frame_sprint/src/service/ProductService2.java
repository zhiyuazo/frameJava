package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component("ps2")
public class ProductService2 {
	public void doSomeService() {
		System.out.println("----------------------------------");
	}
	
	public List<String> selectP() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (Exception e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://127.0.0.1:3306/frame_hibernate?characterEncoding=UTF-8";
		Connection c = DriverManager.getConnection(url,"root","admin");
		String sql = "select * from product_";
		List<String> res = new ArrayList<String>();
		
		try(Statement s = c.createStatement()){
			s.execute(sql);
			ResultSet  rs = s.getResultSet();
			while(rs.next()) {
				String tmp =rs.getString("name");
				res.add(tmp);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return res;
	}
	
	
}
