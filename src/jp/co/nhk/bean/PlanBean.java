package jp.co.nhk.bean;

import java.io.Serializable;

public class PlanBean implements Serializable {
	private int id;
	private int hotel_id;
	private String name;
	private String detail;
	private int price;
	private int maxrooms;

	public PlanBean(int id, int hotel_id, String name, String detail, int price, int maxrooms) {
		this.id = id;
		this.hotel_id = hotel_id;
		this.name = name;
		this.detail = detail;
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
		return this.hotel_id;
	}

	public void setHotelId(int hotelId) {
		this.hotel_id = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetail() {
		return name;
	}

	public void setDetail(String name) {
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
