package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTest {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver") ; 
		try (
				Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "0029") ;
			){
			PreparedStatement pst = conn.prepareStatement("select * from emp where id = ? ;");
			pst.setString(1, "1");
			System.out.println(pst.toString());
			if(pst.execute()){
				ResultSet res = pst.getResultSet() ;
				while(res.next()){
					System.out.println(	res.getString(1)+"\t"+
										res.getString(2)+"\t"+
										res.getString(3)+"\t"+
										res.getString(4)+"\t"+
										res.getString(5)+"\t" ) ;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace() ;
		}
		
		
	}
}
