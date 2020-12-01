/**
 * クラス名：	TaxSearchDBAccess
 * 概要　　：	消費税検索DAO
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

import model.Tax;
public class TaxSearchDBAccess extends ControlDBAccess{
	public Tax searchCurrentTax() throws Exception{
		Connection con = super.createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Tax tax = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM TAX WHERE ENDDATE IS NULL;");
			rs = pstmt.executeQuery();
				while (rs.next()) {
					int 	taxId =  rs.getInt("TAXID");
					double rate = rs.getDouble("RATE");
					String endDate = rs.getString("ENDDATE");
					tax = new Tax(taxId, rate, endDate);
			}
			return tax;
		}catch(SQLException e) {
			throw new Exception("DB接続処理に失敗しました！");
		}finally {
			super.closeConnection(con);
		}

		}



}