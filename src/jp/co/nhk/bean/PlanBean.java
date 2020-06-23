package jp.co.nhk.bean;

import java.io.Serializable;

public class PlanBean implements Serializable {
	private int id;
	private int hotelId;
	private String name;
	private int price;
	private int maxrooms;

	public PlanBean(int id, int hotelId, String name, int price, int maxrooms) {
		this.id = id;
		this.hotelId = hotelId;
		this.name = name;
		this.price = price;
		this.maxrooms = maxrooms;
	}

	public PlanBean() {
	}

	public int getId() {
		return this.id;
	}

	public void setCode(int code) {
		this.id = code;
	}

	public int getHotelId() {
		return this.hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setAge(int price) {
		this.price = price;
	}

	public int getMaxrooms() {
		return this.maxrooms;
	}

	public void setTel(int maxrooms) {
		this.maxrooms = maxrooms;
	}

}
