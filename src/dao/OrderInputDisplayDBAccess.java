/**
 * クラス名：	OrderInputDisplayDBAccess
 * 概要　　：	注文情報入力画面表示DAO
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Customer;

public class OrderInputDisplayDBAccess extends Con_and_closeDBAccess{

	public Customer searchCustomerById(int custId) throws Exception {
		Connection con=createConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Customer customer = null;

		try {
			if(con!=null) {
				pstmt = con.prepareStatement("SELECT CUSTNAME, KANA, TEL, ADDRESS FROM CUSTOMER WHERE CUSTID = ?");
				pstmt.setInt(1, custId);

				rs=pstmt.executeQuery();
				while (rs.next()==true) {
					String custName=rs.getString("CUSTNAME");
					String kana=rs.getString("KANA");
					String address=rs.getString("ADDRESS");
					String tel =rs.getString("TEL");
				 customer = new Customer(custId, custName, kana, tel, address);
					}
				}
		}catch(SQLException e) {
			throw new Exception("DB接続処理に失敗しました。②");
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
			}catch(SQLException e) {
				throw new Exception("DB接続処理に失敗しました。③");
			}
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
			}catch(SQLException e) {
				throw new Exception("DB接続処理に失敗しました。④");
			}
     	}
		closeConnection(con);



		return customer;
	}
}
