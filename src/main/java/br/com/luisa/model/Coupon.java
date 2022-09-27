package br.com.luisa.model;

import java.math.BigDecimal;

public class Coupon {

	private int id;
	private String code;
	private BigDecimal discount;
	private String expDate;
	
	public Coupon() {
	}
	
	public Coupon(int id, String code, BigDecimal discount, String expDate) {
		this.id = id;
		this.code = code;
		this.discount = discount;
		this.expDate = expDate;
	}
	
	@Override
	public String toString() {
		return "Coupon\nID: " + id + "\nCode: " + code + "\nDiscount: " + discount + "\nExpiration Date: " + expDate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
		
}
