package jp.co.nhk.bean;

import java.util.Date;

public class MemberBean {

	private int id;
	private String name;
	private Date birthday;
	private String tel;
	private String address;
	private String email;
	private String password;

	public MemberBean() {

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MemberBean(int id, String name, Date birthday, String address, String tel, String email, String password) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.password = password;

	}

}
