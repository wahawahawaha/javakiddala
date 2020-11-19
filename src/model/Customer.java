/**
 * クラス名： Customer
 * 概要　　：
 * 作成者名：辻
 * 作成日　：11/12
 * 修正者名：辻
 * 修正日　：11/12
 */
package model;

import java.io.Serializable;

public class Customer implements Serializable{

	private int custId;
	private String custName;
	private String kana;
	private String tel;
	private String address;
	public Customer(int custId,String custName,String kana,String tel,String address) {
		setCustId(custId);
		setCustName(custName);
		setKana(kana);
		setTel(tel);
		setAddress(address);


	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public void setCustName(String custName) {
		this.custName=custName;
	}
	public void setKana(String kana) {
		this.kana=kana;
	}
	public void setTel(String tel) {
		this.tel=tel;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public int  getCustId() {
		return custId;
	}
	public String getCustName() {
		return custName;

	}
	public String getKana() {
		return kana;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}

}
