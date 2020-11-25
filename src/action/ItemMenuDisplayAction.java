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
import model.Item;

public class ItemMenuDisplayAction {

	public ArrayList<Item> execute()  throws Exception {
		 ItemMenuDisplayDBAccess  imdb = new  ItemMenuDisplayDBAccess();

		 imdb.searchAllItem();
		return imdb.searchAllItem();
	}
}
