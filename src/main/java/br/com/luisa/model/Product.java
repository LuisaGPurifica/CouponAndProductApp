package br.com.luisa.model;

import java.math.BigDecimal;

public class Product {

	private int id;
	private String name;
	private String description;
	private BigDecimal price;
	private String couponCode;

	public Product() {
	}

	public Product(int id, String name, String description, BigDecimal price, String couponCode) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.couponCode = couponCode;
	}

	@Override
	public String toString() {
		return "Product\nID: " + id + "\nName: " + name + "\nDescription: " + description + "\nPrice: " + price
				+ "\nCoupon code: " + couponCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

}
