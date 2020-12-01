/**
 * クラス名：	ItemMenuDisplayAction
 * 概要　　：	商品情報表示アクション
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package action;
import java.util.ArrayList;

import dao.ItemMenuDisplayDBAccess;
import dao.TaxSearchDBAccess;
import model.Item;
import model.OrderControlUtility2;
import model.Tax;
public class ItemMenuDisplayAction {

	public String[][] execute() throws Exception {

		ArrayList<Item> list = new ArrayList<>();
		ItemMenuDisplayDBAccess itMDB = new ItemMenuDisplayDBAccess();
		list = itMDB.searchAllItem();

		TaxSearchDBAccess tsDB = new TaxSearchDBAccess();
		Tax tax = tsDB.searchCurrentTax();
		double rate = tax.getRate();

		 String[][] tableData = null;
		 tableData = OrderControlUtility2.itemToArray(list);

		for(int i = 0;i<tableData.length;i++){

			int ra = Integer.parseInt(tableData[i][4]);
			ra = (int)(ra + ra * rate);

			tableData[i][4] = String.valueOf(String.format("%1$,d", ra));
		}
		 return tableData;
	}
}