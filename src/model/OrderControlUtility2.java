/**
 * クラス名：	OrderControlUtility2
 * 概要　　：	注文管理用ユーティリティ
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package model;

import java.util.ArrayList;

public class OrderControlUtility2 {

	public static String[][] itemToArray(ArrayList<Item> list) {
		int listSize = list.size();
		String[][] tableData = new String[listSize][5];
		for(int i = 0; i < listSize; i++) {

			Item item = list.get(i);
			tableData[i][0] = item.getItemId();
			tableData[i][1] = item.getItemName();
			tableData[i][2] = item.getSize();
			tableData[i][3] = Integer.toString(0);

			tableData[i][4] = Integer.toString(item.getPrice());

		}

		return tableData;

	}

	public static String[][] orderToArray(ArrayList<OrderDetail> orderDetailList) {
		return null;
	}

	public static String getDate() {
		return null;
	}
}