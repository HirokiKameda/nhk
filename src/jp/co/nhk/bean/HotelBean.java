package jp.co.nhk.bean;

import java.util.Date;

public class HotelBean {
	private int id;
	private String name;
	private String intro;
	private String address;
	private Date checkin;
	private Date checkout;
	private String tel;

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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public HotelBean(int id, String name, String intro, String address, Date checkin, Date checkout, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.intro = intro;
		this.address = address;
		this.checkin = checkin;
		this.checkout = checkout;
		this.tel = tel;
	}

}
