/**
 * クラス名：	OrderInputDisplayAction
 * 概要　　：	注文情報入力画面表示アクション
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package action;

import dao.OrderInputDisplayDBAccess;
import model.Customer;

public class OrderInputDisplayAction { //oida

	public Customer execute(String custId) throws Exception {
		int id = Integer.parseInt(custId);

		OrderInputDisplayDBAccess  oidb = new OrderInputDisplayDBAccess() ;
		Customer customer =oidb.searchCustomerById(id);


		return customer;
	}
}
