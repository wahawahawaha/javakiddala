/**
 * クラス名：	ItemMenuDisplayDBAccess
 * 概要　　：	商品情報表示DAO
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

import model.Item;

public class ItemMenuDisplayDBAccess extends ControlDBAccess{

	public ArrayList<Item> searchAllItem() throws Exception {
		Connection con=super.createConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Item>list=new ArrayList<Item>();
		Item item = null;


		try {

				pstmt=con.prepareStatement("SELECT   *  FROM ITEM;");
				rs=pstmt.executeQuery();
				while (rs.next()==true) {
					String itemId =rs.getString("ITEMID");
					String itemName =rs.getString("ITEMNAME");
					String size =rs.getString("SIZE");
					int price=rs.getInt("PRICE");
					item = new Item(itemId,itemName,size,price);
					list.add(item);



				}
				return list;
			}catch(SQLException e) {
				throw new Exception("DB接続処理に失敗しました。");
			}finally {
				closeConnection(con);
         	}
















	}
}
