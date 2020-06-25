package jp.co.nhk.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import jp.co.nhk.bean.ReserveBean;

public class ReserveDAO {

	private Connection con;

	public Connection getConnection() throws DAOException {
		try {

			// JDBCドライバの登録
			Class.forName("org.postgresql.Driver");

			// 初期設定
			String url = "jdbc:postgresql:sample";
			String user = "student";
			String pass = "himitu";

			// DBへの接続
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			throw new DAOException("接続に失敗", e);
		}
		return con;

	}

	public List<ReserveBean> findAll() throws DAOException {

		//SQL文の作成
		String sql = "select * from reservation";
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			List<ReserveBean> list = new ArrayList<ReserveBean>();
			while (rs.next()) {
				int id = rs.getInt("id");
				int hotelId = rs.getInt("hotel_id");
				int planId = rs.getInt("plan_id");
				int memberId = rs.getInt("member_id");
				String reservedate = rs.getString("reservedate");
				String reservetime = rs.getString("reservetime");
				String checkindate = rs.getString("checkindate");
				String checkoutdate = rs.getString("checkoutdate");
				int rooms = rs.getInt("rooms");
				int people = rs.getInt("people");

				ReserveBean bean = new ReserveBean(id, hotelId, planId, memberId, reservedate, reservetime, checkindate,
						checkoutdate,
						rooms, people);
				list.add(bean);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。", e);
		}
	}

	public ReserveBean findBy(int id) throws DAOException {

		//SQL文の作成
		String sql = "select * from reservation";
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			List<ReserveBean> list = new ArrayList<ReserveBean>();
			while (rs.next()) {
				if (id == rs.getInt("id")) {
					int planId = rs.getInt("plan_id");
					int hotelId = rs.getInt("hotel_id");
					int memberId = rs.getInt("member_id");
					String reservedate = rs.getString("reservedate");
					String reservetime = rs.getString("reservetime");
					String checkindate = rs.getString("checkindate");
					String checkoutdate = rs.getString("checkoutdate");
					int rooms = rs.getInt("rooms");
					int people = rs.getInt("people");

					ReserveBean bean = new ReserveBean(id, hotelId, planId, memberId, reservedate, reservetime,
							checkindate,
							checkoutdate,
							rooms, people);
					return bean;
				}
			}
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。", e);
		}
	}

	public List<ReserveBean> findByMember(int id) throws DAOException {

		//SQL文の作成
		String sql = "select * from reservation where member_id=" + id;
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			List<ReserveBean> list = new ArrayList<ReserveBean>();
			while (rs.next()) {
				if (id == rs.getInt("member_id")) {
					int planId = rs.getInt("plan_id");
					int hotelId = rs.getInt("hotel_id");
					int idx = rs.getInt("id");
					String reservedate = rs.getString("reservedate");
					String reservetime = rs.getString("reservetime");
					String checkindate = rs.getString("checkindate");
					String checkoutdate = rs.getString("checkoutdate");
					int rooms = rs.getInt("rooms");
					int people = rs.getInt("people");

					ReserveBean bean = new ReserveBean(idx, hotelId, planId, id, reservedate, reservetime,
							checkindate,
							checkoutdate,
							rooms, people);
					list.add(bean);
				}
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。", e);
		}
	}

	public void updateData(int id, int planId, int memberId, Date reservedate, Time reservetime, Date checkindate,
			Date checkoutdate,
			int rooms, int people)
			throws DAOException {

		String sql = "SELECT * FROM reservation Where id=?";
		PreparedStatement st = null;
		ResultSet rs = null;
		try (Connection con = getConnection();) {
			String sql2 = "UPDATE reservation SET plan_id=?,member_id=?, reservedate=?,reservetime=?,checkindate=?,checkoutdate=?,rooms=?,people=? WHERE id =?";

			st = con.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			rs.next();

			if (planId == 0) {
				planId = rs.getInt("plan_id");
			}
			if (memberId == 0) {
				memberId = rs.getInt("member_id");
			}

			if (reservedate == null || reservedate.equals("")) {
				reservedate = rs.getDate("reservedate");
			}

			if (reservetime == null || reservetime.equals("")) {
				reservetime = rs.getTime("reservetime");
			}

			if (checkindate == null || checkindate.equals("")) {
				checkindate = rs.getDate("checkindate");
			}

			if (checkoutdate == null || checkoutdate.equals("")) {
				checkoutdate = rs.getDate("checkoutdate");
			}

			if (rooms == 0) {
				rooms = rs.getInt("rooms");
			}

			if (people == 0) {
				people = rs.getInt("people");
			}

			st = con.prepareStatement(sql2);
			st.setInt(1, planId);
			st.setInt(2, memberId);
			st.setDate(3, reservedate);
			st.setTime(4, reservetime);
			st.setDate(5, checkindate);
			st.setDate(6, checkoutdate);
			st.setInt(7, rooms);
			st.setInt(8, people);

			st.setInt(9, id);

			//System.out.println(st.toString());

			//updateの実行。変更した件数を取得する。
			int rows = st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの変更に失敗しました。", e);
		} finally {
			try {
				//リソースの解放
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				close();

			} catch (Exception e) {
				throw new DAOException("リソースの解放に失敗しました。", e);
			}
		}
	}

	private void close() {
		// TODO 自動生成されたメソッド・スタブ
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			con = null;
		}
	}

	public void insert(int hotel_Id, int planId, int memberId, String reservedate, String reservetime,
			String checkindate,
			String checkoutdate,
			int rooms, int people)
			throws DAOException {

		PreparedStatement st1 = null;
		PreparedStatement st2 = null;

		ResultSet rs = null;

		try (Connection con = getConnection();) {
			//SQL文の作成
			String sql1 = "insert into reservation(id,hotel_id,plan_id,member_id, reservedate,reservetime,checkindate,checkoutdate,rooms,people) values(?,?,?,?,?,?,?,?,?,?)";

			//現在の最終行codeを持ってくる
			String sql2 = "select * from reservation order by id desc";
			st2 = con.prepareStatement(sql2);
			rs = st2.executeQuery();
			rs.next();
			int codeMax = rs.getInt("id");

			//PreparedStatementオブジェクトの取得
			st1 = con.prepareStatement(sql1);
			st1.setInt(1, codeMax + 1);
			st1.setInt(2, hotel_Id);
			st1.setInt(3, planId);
			st1.setInt(4, memberId);
			st1.setString(5, reservedate);
			st1.setString(6, reservetime);
			st1.setString(7, checkindate);
			st1.setString(8, checkoutdate);
			st1.setInt(9, rooms);
			st1.setInt(10, people);

			int rows = st1.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの追加に失敗しました。", e);
		} finally {
			try {
				//リソースの解放
				if (st1 != null) {
					st1.close();
				}
				if (st2 != null) {
					st2.close();
				}
				if (rs != null) {
					rs.close();
				}

				close();

			} catch (Exception e) {
				throw new DAOException("リソースの解放に失敗しました。", e);
			}
		}
	}

	public void deleteData(int id) throws DAOException {

		//SQL文の作成
		String sql = "delete from reservation where id = ?";

		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);) {
			st.setInt(1, id);
			int rows = st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの削除に失敗しました。", e);
		}
	}
}
