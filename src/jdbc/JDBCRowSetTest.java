package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JDBCRowSetTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver") ; 
		RowSetFactory factory = RowSetProvider.newFactory() ;
		try (
				JdbcRowSet jr = factory.createJdbcRowSet() ; 
			){
			jr.setUrl("jdbc:mysql://127.0.0.1:3306/test");
			jr.setUsername("root");
			jr.setPassword("0029");
			jr.setCommand("select * from emp where id = ?;");
			jr.setString(1,"1 or 1 = 1" );
			jr.execute();
			jr.beforeFirst();
			while(jr.next()){
				System.out.println(	jr.getString(1)+"\t"+
						jr.getString(2)+"\t"+
						jr.getString(3)+"\t"+
						jr.getString(4)+"\t"+
						jr.getString(5)+"\t" ) ;
			}
			//jr.last();
			//jr.updateString(5, "343");
			//jr.updateRow();
			
			
		} catch (SQLException e) {
			e.printStackTrace() ;
		}
	}
}
