package jp.co.nhk.bean;

public class ReserveBean {
	private int id;
	private int planId;
	private int memberId;
	private String reservedate;

	public String getReservedate() {
		return reservedate;
	}

	public String getReservetime() {
		return reservetime;
	}

	public String getCheckindate() {
		return checkindate;
	}

	public String getCheckoutdate() {
		return checkoutdate;
	}

	private String reservetime;
	private String checkindate;
	private String checkoutdate;
	private int rooms;
	private int people;
	private int hotelId;
	private String hotelname;

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public ReserveBean(int id, int hotelId, int planId, int memberId, String reservedate, String reservetime,
			String checkindate,
			String checkoutdate, int rooms, int people) {
		this.id = id;
		this.hotelId = hotelId;
		this.planId = planId;
		this.memberId = memberId;
		this.reservedate = reservedate;
		this.reservetime = reservetime;
		this.checkindate = checkindate;
		this.checkoutdate = checkoutdate;
		this.rooms = rooms;
		this.people = people;

	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public void setReservedate(String reservedate) {
		this.reservedate = reservedate;
	}

	public void setReservetime(String reservetime) {
		this.reservetime = reservetime;
	}

	public void setCheckindate(String checkindate) {
		this.checkindate = checkindate;
	}

	public void setCheckoutdate(String checkoutdate) {
		this.checkoutdate = checkoutdate;
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
