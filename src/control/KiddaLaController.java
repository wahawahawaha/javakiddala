/**
 * クラス名：KiddaLaController
 * 概要　　：
 * 作成者名：橘
 * 作成日　：11/13
 * 修正者名：橘
 * 修正日　：11/13
 */
package control;

import java.util.ArrayList;

import action.CustomerSearchAction;
import action.CustomerSearchDisplayAction;
import action.ItemMenuDisplayAction;
import action.MainMenuDisplayAction;
import action.OrderInputDisplayAction;
import action.PrintOutAction;
import model.Customer;
import model.OrderControlUtility2;
import model.OrderDetail;
import view.DeliveryConfirmFrame;

public class KiddaLaController {

	public static void customerSearchDisplay() {
		CustomerSearchDisplayAction action = new CustomerSearchDisplayAction();
		action.execute();
	}

	public static void mainMenuDisplay() {
		MainMenuDisplayAction action = new MainMenuDisplayAction();
		action.execute();
	}

	public static Customer orderInputDisplay(String custId) throws Exception {

		OrderInputDisplayAction oida =new OrderInputDisplayAction();
		Customer customer=oida.execute(custId);
		return customer;
	}

	public static String[][] itemMenuDisplay() throws Exception {
		ItemMenuDisplayAction imda = new ItemMenuDisplayAction();
		imda.execute();
		String [][]tableData = OrderControlUtility2.itemToArray(imda.execute());
		return tableData;
	}

	public static ArrayList<OrderDetail> deliveryConfirm(String custId)
			throws Exception {
		return null;
	}

	public static ArrayList<OrderDetail> orderRegister(
			ArrayList<OrderDetail> orderDetailList) throws Exception {
		return null;
	}

	public static int customerModify(Customer customer) throws Exception {
		return 0;
	}

	public static void printOut(DeliveryConfirmFrame frame) throws Exception {
		PrintOutAction action = new PrintOutAction();
		action.execute(frame);
	}

	public static int deliveryComplete(String custId) throws Exception {
		return 0;
	}
	public static String[][] customerSearch(String[] data) throws Exception {
		CustomerSearchAction action = new CustomerSearchAction();
		String[][] tableData = action.execute(data);
		return tableData;
	}

	}//1/12

