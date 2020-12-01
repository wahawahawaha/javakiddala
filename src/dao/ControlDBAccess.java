package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ControlDBAccess {

		protected Connection createConnection() throws Exception{
			Connection con=null;

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(
						"jdbc:mysql://localhost:65534/kidda_la?serverTimezone=JST",
						"user1",
						"pass1");

			}catch(SQLException e) {
				throw new Exception("DB接続処理に失敗しました。①");
			}
			return con;
		}
		protected void closeConnection(Connection con) throws Exception{
			try {
				if(con!=null) {
					con.close();
				}
			}catch(SQLException e) {
				throw new Exception("DB接続処理に失敗しました。ちなcolse");
			}
		}

}