package jp.co.nhk.bean;

import java.sql.Date;
import java.sql.Time;

public class ReserveBean {
	private int id;
	private int planId;
	private int memberId;
	private Date reservedate;
	private Time reservetime;
	private Date checkindate;
	private Date checkoutdate;
	private int rooms;
	private int people;

	public ReserveBean(int id, int planId, int memberId, Date reservedate, Time reservetime, Date checkindate,
			Date checkoutdate, int rooms, int people) {
		this.id = id;
		this.planId = planId;
		this.memberId = memberId;
		this.reservedate = reservedate;
		this.reservetime = reservetime;
		this.checkindate = checkindate;
		this.checkoutdate = checkoutdate;
		this.rooms = rooms;
		this.people = people;

	}

	public ReserveBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Date getReservedate() {
		return reservedate;
	}

	public void setReservedate(Date reservedate) {
		this.reservedate = reservedate;
	}

	public Time getReservetime() {
		return reservetime;
	}

	public void setReservetime(Time reservetime) {
		this.reservetime = reservetime;
	}

	public Date getCheckindate() {
		return checkindate;
	}

	public void setCheckindate(Date checkindate) {
		this.checkindate = checkindate;
	}

	public Date getCheckoutdate() {
		return checkoutdate;
	}

	public void setCheckoutdate(Date checkoutdate) {
		this.checkoutdate = checkoutdate;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

}
