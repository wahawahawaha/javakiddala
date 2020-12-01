/**
 * クラス名：	OrderRegisterAction
 * 概要　　：	注文情報登録アクション
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package action;

import java.util.ArrayList;

import dao.OrderConfirmDBAccess;
import dao.OrderInputDisplayDBAccess;
import dao.OrderRegisterDBAccess;
import dao.TaxSearchDBAccess;
import model.Customer;
import model.OrderDetail;
import model.Tax;

public class OrderRegisterAction {
	public ArrayList<OrderDetail> execute(ArrayList<OrderDetail> orderDetailList) throws Exception {
		//orderDetailListの一つを取り出し、CUSTIDが一致するCustomerを検索する。
		OrderDetail OD = orderDetailList.get(0);
		Customer customer = OD.getCustomer();
		int custId = customer.getCustId();
		OrderInputDisplayDBAccess oidDBA = new OrderInputDisplayDBAccess();
		customer = oidDBA.searchCustomerById(custId);

		//TaxSearchDBAccessを使い、Taxを検索する。
		TaxSearchDBAccess tsDBA = new TaxSearchDBAccess();
		Tax tax = tsDBA.searchCurrentTax();

		//検索したCustomerとTaxをorderDetailListに入れる。
		for (OrderDetail orderDetail : orderDetailList) {
			orderDetail.setCustomer(customer);
			orderDetail.setTax(tax);
		}

		//注文明細を追加する。
		OrderRegisterDBAccess orDBA = new OrderRegisterDBAccess();
		orDBA.registerOrder(orderDetailList);

		//見配達の注文明細のリストを表示する。
		OrderConfirmDBAccess ocDBA = new OrderConfirmDBAccess();
		orderDetailList = ocDBA.searchOrderByCustId(custId);
		return orderDetailList;
	}
}
