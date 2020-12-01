/**
 * クラス名：	OrderRegisterDBAccess
 * 概要　　：	注文情報登録DAO
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import model.Customer;
import model.Item;
import model.OrderDetail;
import model.Tax;

public class OrderRegisterDBAccess extends ControlDBAccess {
	public void registerOrder(ArrayList<OrderDetail> list) throws Exception {
		Connection con = super.createConnection();
		PreparedStatement pstmt = null;
		Customer customer;
		Item item;
		Tax tax;
		try {
			if (con != null) {
				for (OrderDetail orderDetail : list) {
					customer = orderDetail.getCustomer();
					item = orderDetail.getItem();
					tax = orderDetail.getTax();
					String sql = "INSERT INTO ORDERDETAIL (CUSTID,ITEMID,ORDERDATE,QUANTITY,TAXID,STATUS" +
						") VALUES (" +
						"'" + customer.getCustId() + "', " +
						"'" + item.getItemId() + "', " +
						"'" + orderDetail.getOrderDate() + "', " +
						"'" + orderDetail.getQuantity() + "', " +
						"'" + tax.getTaxId() + "', " +
						"'1'" +
						");";
					pstmt = con.prepareStatement(sql);
					pstmt.executeUpdate();
				}
			}
		}catch(Exception e) {
			throw new Exception("注文情報登録処理に失敗しました！");
		}finally {
			super.closeConnection(con);
		}
	}
}
