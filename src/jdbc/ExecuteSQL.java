package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteSQL {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver") ; 
		try (
				Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "0029") ;
			){
			Statement smt = conn.createStatement();
			boolean hasResultSet = smt.execute("select count(*) from emp ;") ; 
			System.out.println(hasResultSet);
			ResultSet res = smt.getResultSet()  ; //smt.getUpdateCount();
			res.first() ; 
			System.out.println(res.getString(1));
		} catch (SQLException e) {
			e.printStackTrace() ;
		}
		
		
	}

}
