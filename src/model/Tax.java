/**
 * クラス名：	Tax
 * 概要　　：	消費税情報
 * 作成者名：
 * 作成日　：
 * 修正者名：
 * 修正日　：
 */

package model;


import java.io.Serializable;

public class Tax implements Serializable{
	private int taxId;
	private double rate;
	private String endDate;

	public Tax() {
	}
	public Tax(int taxId,double rate,String endDate) {
		this.taxId = taxId;
		this.rate = rate;
		this.endDate = endDate;
	}
	public void setTaxId(int taxId){
		this.taxId = taxId;
	}
	public int getTaxId() {
		return taxId;
	}
	public void setRate(double rate){
		this.rate = rate;
	}
	public double getRate() {
		return rate;
	}
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
	public String getEndDate() {
		return endDate;
	}

}
