package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver") ; 
		try (
				Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "0029") ;
			){
			Statement smt = conn.createStatement();
			ResultSet res =  smt.executeQuery("update emp set hashCode = 456 where id = 1;");

			res.first();
			do{
				System.out.println(	res.getString(1)+"\t"+
						res.getString(2)+"\t"+
						res.getString(3)+"\t"+
						res.getString(4)+"\t"+
						res.getString(5)+"\t" ) ;
			}while(res.next()) ; 
			
			System.out.println("-------------------------------------------------------------");
			res.beforeFirst();
			while(res.next()){
				System.out.println(	res.getString(1)+"\t"+
									res.getString(2)+"\t"+
									res.getString(3)+"\t"+
									res.getString(4)+"\t"+
									res.getString(5)+"\t" ) ;
			}
		} catch (SQLException e) {
			e.printStackTrace() ;
		}
		
		
	}
}
