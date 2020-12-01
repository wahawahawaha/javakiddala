/**
 * クラス名：	DeliveryConfirmDBAccess
 * 概要　　：	配達確認DAO
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
import java.util.ArrayList;

import model.Customer;
import model.Item;
import model.OrderDetail;
import model.Tax;

public class DeliveryConfirmDBAccess extends ControlDBAccess {

	public ArrayList<OrderDetail> searchDeliveryByCustId(int custId) throws Exception {
		Connection con = super.createConnection();
		PreparedStatement pstmt = null, pstmt2 = null, pstmt3 = null, pstmt4 = null;
		ResultSet rs = null, rs2 = null, rs3 = null, rs4 = null;
		ArrayList<OrderDetail> list = new ArrayList<>();
		Customer customer = new Customer();

		try {
			String sql = "Select * From ORDERDETAIL Where CUSTID = " + custId + " AND STATUS = 1;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			sql = "Select * From CUSTOMER Where CUSTID = " + custId + ";";
			pstmt2 = con.prepareStatement(sql);
			rs2 = pstmt2.executeQuery();
			while (rs2.next()) {
				customer.setCustId(rs2.getInt("CUSTID"));
				customer.setCustName(rs2.getString("CUSTNAME"));
				customer.setKana(rs2.getString("KANA"));
				customer.setTel(rs2.getString("TEL"));
				customer.setAddress(rs2.getString("ADDRESS"));
			}
			while (rs.next()) {
				sql = "Select * From ITEM Where ITEMID = '" + rs.getString("ITEMID") + "' ;";
				pstmt3 = con.prepareStatement(sql);
				rs3 = pstmt3.executeQuery();
				sql = "Select * From TAX Where TAXID = " + rs.getInt("TAXID") + ";";
				pstmt4 = con.prepareStatement(sql);
				rs4 = pstmt4.executeQuery();
				while (rs3.next() && rs4.next()) {
					Item item = new Item(rs3.getString("ITEMID"), rs3.getString("ITEMNAME"),
							rs3.getString("SIZE"), rs3.getInt("PRICE"));
					Tax tax = new Tax(rs4.getInt("TAXID"), rs4.getDouble("RATE"), rs4.getString("ENDDATE"));

					long no = rs.getLong("NO");
					String orderDate = rs.getString("ORDERDATE");
					int quantity = rs.getInt("QUANTITY");
					int status = rs.getInt("STATUS");
					OrderDetail od = new OrderDetail(no, customer, item, orderDate, quantity, tax, status);
					list.add(od);
				}
			}

			return list;
		} catch (SQLException e) {
			throw new Exception("配達情報検索処理に失敗しました！");
		} finally {
			super.closeConnection(con);
		}
	}
}
