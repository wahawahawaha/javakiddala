package action;

import java.util.ArrayList;

import dao.CustomerSearchDBAccess;
import model.Customer;
import model.OrderControlUtility;

public class CustomerSearchAction {
	String[] data;
	String [][] tableData;
    ArrayList<Customer> list = new ArrayList<Customer>();


		public String[][] execute(String[] data) throws Exception {

			try {


                  data[0] = data[0].replaceAll(" ","　");
                  data[1] = data[1].replaceAll(" ","　");  //スペース削除


			      if(!(data[0].equals(""))  && (data[1].equals(""))){
				     CustomerSearchDBAccess dao = new CustomerSearchDBAccess();
				     list =dao.searchCustomerByTel(data[0]);

				  //電話番号検索
			      }

				  if((data[0].equals(""))  && !(data[1].equals(""))) {
					 CustomerSearchDBAccess dao = new CustomerSearchDBAccess();
					 list = dao.searchCustomerByKana(data[1]);

					     	//名前検索
				  }
				  if(!(data[0].equals(""))  && !(data[1].equals(""))){
				    CustomerSearchDBAccess dao = new CustomerSearchDBAccess();
				    list = dao.searchCustomer(data[0],data[1]);
				    		  	//両方検索
			      }
			      if((list != null) && (list.size() !=0)) {
			    	  tableData = OrderControlUtility.customerToArray(list);

			    	  return tableData;

			      }else {
			    	  return tableData;

			      }

			}catch(Exception e) {

				return tableData;

			}
			}


	}



