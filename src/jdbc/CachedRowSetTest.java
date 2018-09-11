package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		RowSetFactory factory = RowSetProvider.newFactory();
		try (	CachedRowSet res = factory.createCachedRowSet();
				Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "0029") ;
				Statement smt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs =  smt.executeQuery("select * from emp ;");
			) {
			res.populate(rs);
			rs.close();
			smt.close();
			conn.close();
			res.beforeFirst();
			while (res.next()) {
				System.out.println(	res.getString(1)+"\t"+
						res.getString(2)+"\t"+
						res.getString(3)+"\t"+
						res.getString(4)+"\t"+
						res.getString(5)+"\t" ) ;
			}
/*			res.last();
			res.updateString(5, "123");
			res.updateRow();
			Connection conn1 =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "0029");
			conn1.setAutoCommit(false);
			res.acceptChanges(conn1);*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
