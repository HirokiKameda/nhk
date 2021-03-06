package jp.co.nhk.dao;

import java.sql.Connection;
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
				String checkin = rs.getString("checkin");
				String checkout = rs.getString("checkout");
				String tel = rs.getString("tel");
				String url = rs.getString("url");
				HotelBean bean = new HotelBean(id, name, intro, address, checkin, checkout, tel, url);
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
		String sql = "select * from hotel WHERE id = " + id;
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			List<HotelBean> list = new ArrayList<HotelBean>();
			while (rs.next()) {
				if (id == rs.getInt("id")) {
					String name = rs.getString("name");
					String intro = rs.getString("intro");
					String address = rs.getString("address");
					String checkin = rs.getString("checkin");
					String checkout = rs.getString("checkout");
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

	public void update(int id, String name, String intro, String address, String checkin, String checkout, String tel,
			String url)
			throws DAOException {

		String sql = "SELECT * FROM hotel Where id=?";
		PreparedStatement st = null;
		ResultSet rs = null;
		try (Connection con = getConnection();) {
			String sql2 = "UPDATE hotel SET name=?,intro=?,address=?,checkin=?,checkout=?,tel=?,url=? WHERE id = ?";

			st = con.prepareStatement(sql);
			st.setInt(1, id);
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
				checkin = rs.getString("checkin");
			}
			if (checkout == null || checkout.equals("")) {
				checkout = rs.getString("checkout");
			}

			if (tel == null || tel.isEmpty()) {
				tel = rs.getString("tel");
			}
			if (url == null || tel.isEmpty()) {
				url = rs.getString("tel");
			}

			st = con.prepareStatement(sql2);
			st.setString(1, name);
			st.setString(2, intro);
			st.setString(3, address);
			st.setString(4, checkin);
			st.setString(5, checkout);
			st.setString(6, tel);
			st.setString(7, url);
			st.setInt(8, id);

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

	public void insert(String name, String intro, String address, String checkin, String checkout, String tel,
			String url)
			throws DAOException {

		PreparedStatement st1 = null;
		PreparedStatement st2 = null;

		ResultSet rs = null;

		try (Connection con = getConnection();) {
			//SQL文の作成
			String sql1 = "insert into hotel(id,name,intro,address,checkin,checkout,tel,url) values(?,?,?,?,?,?,?,?)";

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

			//			SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss");
			//			java.util.Time date = sdf.parse(checkin);
			//			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			//			java.util.Date date2 = sdf.parse(checkout);
			//			java.sql.Date sqlDate2 = new java.sql.Date(date.getTime());
			st1.setString(5, checkin);
			st1.setString(6, checkout);
			st1.setString(7, tel);
			st1.setString(8, url);

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

	public void delete(int id) throws DAOException {

		//SQL文の作成
		String sql = "delete from hotel where id = " + id;
		String sql2 = "delete from plan where hotel_id = " + id;

		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);
				PreparedStatement st2 = con.prepareStatement(sql2);) {

			int rows = st.executeUpdate();
			int rows2 = st2.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの削除に失敗しました。", e);
		}
	}
}
