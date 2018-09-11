package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataTest {

	public static void main(String[] args) {
		try (
				Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "0029") ;
				Statement smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet res =  smt.executeQuery("select * from emp");
			){
			ResultSetMetaData rsmd = res.getMetaData() ; 
			for(int i = 0 ; i < rsmd.getColumnCount() ; i++ ){
				System.out.print(rsmd.getColumnLabel(i+1)+"\t");
			}
			System.out.println();
			while(res.next()){
				for(int i = 0 ; i < rsmd.getColumnCount() ; i++ ){
					System.out.print(res.getString(i+1)+"\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace() ;
		}
		
	}

}
