package jp.co.nhk.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.nhk.bean.HotelBean;

public class HotelDAO {

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

	public List<HotelBean> findAll() throws DAOException {

		//SQL文の作成
		String sql = "select * from hotel";
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			List<HotelBean> list = new ArrayList<HotelBean>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String intro = rs.getString("intro");
				String address = rs.getString("address");
				Date checkin = rs.getDate("checkin");
				Date checkout = rs.getDate("checkout");
				String tel = rs.getString("tel");
				HotelBean bean = new HotelBean(id, name, intro, address, checkin, checkout, tel);
				list.add(bean);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。", e);
		}
	}

	public HotelBean findBy(int id) throws DAOException {

		//SQL文の作成
		String sql = "select * from hotel WHERE id = ?";
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			List<HotelBean> list = new ArrayList<HotelBean>();
			while (rs.next()) {
				if (id == rs.getInt("id")) {
					String name = rs.getString("name");
					String intro = rs.getString("intro");
					String address = rs.getString("address");
					Date checkin = rs.getDate("checkin");
					Date checkout = rs.getDate("checkout");
					String tel = rs.getString("tel");
					HotelBean bean = new HotelBean(id, name, intro, address, checkin, checkout, tel);
					return bean;
				}
			}
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。", e);
		}
	}

	public void updateData(int id, String name, String intro, String address, Date checkin, Date checkout, String tel)
			throws DAOException {

		String sql = "SELECT * FROM hotel Where id=" + id;
		PreparedStatement st = null;
		ResultSet rs = null;
		try (Connection con = getConnection();) {
			String sql2 = "UPDATE hotel SET name=?,intro=?,address=?,checkin=?,checkout=?,tel=? WHERE id = ?";

			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			rs.next();
			if (name == null || name.isEmpty()) {
				name = rs.getString("name");
			}

			if (intro == null || intro.isEmpty()) {
				intro = rs.getString("intro");
			}
			if (address == null || address.isEmpty()) {
				address = rs.getString("address");
			}
			if (checkin == null || checkin.equals("")) {
				checkin = rs.getDate("tcheckin");
			}
			if (checkout == null || checkout.equals("")) {
				checkout = rs.getDate("checkout");
			}

			if (tel == null || tel.isEmpty()) {
				tel = rs.getString("tel");
			}

			st = con.prepareStatement(sql2);
			st.setString(1, name);
			st.setString(2, intro);
			st.setString(3, address);
			st.setDate(4, checkin);
			st.setDate(5, checkout);
			st.setString(6, tel);

			//System.out.println(st.toString());

			//プレースホルダーに値を入れる
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

	public void insert(String name, String intro, String address, Date checkin, Date checkout, String tel)
			throws DAOException {

		PreparedStatement st1 = null;
		PreparedStatement st2 = null;

		ResultSet rs = null;

		try (Connection con = getConnection();) {
			//SQL文の作成
			String sql1 = "insert into hotel(id,name,intro,address,checkin,checkout,tel) values(?,?,?,?,?,?,?)";

			//現在の最終行codeを持ってくる
			String sql2 = "select * from hotel order by id desc";
			st2 = con.prepareStatement(sql2);
			rs = st2.executeQuery();
			rs.next();
			int codeMax = rs.getInt("id");

			//PreparedStatementオブジェクトの取得
			st1 = con.prepareStatement(sql1);
			st1.setInt(1, codeMax + 1);
			st1.setString(2, name);
			st1.setString(3, intro);
			st1.setString(4, address);

			st1.setDate(5, checkin);
			st1.setDate(6, checkout);
			st1.setString(7, tel);

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
		String sql = "delete from emp where code = ?" + id;

		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {

			int rows = st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの削除に失敗しました。", e);
		}
	}
}
