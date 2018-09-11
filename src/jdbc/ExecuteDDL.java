package jdbc;
/**
 * 
 * @author Pouee
 * Data Definition Language including create alter drop 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteDDL {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver") ; 
		try (
				Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "0029") ;
			){
			Statement smt = conn.createStatement();
			int affectedRow  = smt.executeUpdate("create table if not exists temp(id int primary key) ; ") ; 
			System.out.println(affectedRow) ;
			affectedRow  = smt.executeUpdate("drop table if exists temp ; ") ; 
			System.out.println(affectedRow) ;
		} catch (SQLException e) {
			e.printStackTrace() ;
		}
		
		
	}
}

