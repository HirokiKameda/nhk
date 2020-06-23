package jp.co.nhk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.nhk.bean.PlanBean;

public class PlanDAO {

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

	public List<PlanBean> findAll() throws DAOException {

		//SQL文の作成
		String sql = "select * from plan";
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			List<PlanBean> list = new ArrayList<PlanBean>();
			while (rs.next()) {
				int id = rs.getInt("id");
				int hotelId = rs.getInt("hotel_id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				int price = rs.getInt("price");
				int maxrooms = rs.getInt("maxrooms");

				PlanBean bean = new PlanBean(id, hotelId, name, detail, price, maxrooms);
				list.add(bean);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。", e);
		}
	}

	public PlanBean findBy(int id) throws DAOException {

		//SQL文の作成
		String sql = "select * from plan";
		try (Connection con = getConnection();
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {
			List<PlanBean> list = new ArrayList<PlanBean>();
			while (rs.next()) {
				if (id == rs.getInt("id")) {
					int hotelId = rs.getInt("hotel_id");
					String name = rs.getString("name");
					String detail = rs.getString("detail");
					int price = rs.getInt("price");
					int maxrooms = rs.getInt("maxrooms");

					PlanBean bean = new PlanBean(id, hotelId, name, detail, price, maxrooms);
					return bean;
				}
			}
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました。", e);
		}
	}

	public void updateData(int id, int hotelId, String name, String detail, int price, int maxrooms)
			throws DAOException {

		String sql = "SELECT * FROM plan Where id=?";
		PreparedStatement st = null;
		ResultSet rs = null;
		try (Connection con = getConnection();) {
			String sql2 = "UPDATE plan SET hotel_id=?,name=?,detail=?,price=?,maxrooms=? WHERE id = ?";

			st = con.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			rs.next();

			if (hotelId == 0) {
				hotelId = rs.getInt("hotel_id");
			}

			if (name == null || name.isEmpty()) {
				name = rs.getString("name");
			}

			if (detail == null || detail.isEmpty()) {
				detail = rs.getString("detail");
			}

			if (price == 0) {
				price = rs.getInt("price");
			}

			if (maxrooms == 0) {
				maxrooms = rs.getInt("maxrooms");
			}

			st = con.prepareStatement(sql2);
			st.setInt(1, hotelId);
			st.setString(2, name);
			st.setString(3, detail);
			st.setInt(4, price);
			st.setInt(5, maxrooms);
			st.setInt(6, id);

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

	public void insert(int id, int hotelId, String name, String detail, int price, int maxrooms)
			throws DAOException {

		PreparedStatement st1 = null;
		PreparedStatement st2 = null;

		ResultSet rs = null;

		try (Connection con = getConnection();) {
			//SQL文の作成
			String sql1 = "insert into plan(id,hotel_id,name,detail,price,maxrooms) values(?,?,?,?,?,?,?)";

			//現在の最終行codeを持ってくる
			String sql2 = "select * from plan order by id desc";
			st2 = con.prepareStatement(sql2);
			rs = st2.executeQuery();
			rs.next();
			int codeMax = rs.getInt("id");

			//PreparedStatementオブジェクトの取得
			st1 = con.prepareStatement(sql1);
			st1.setInt(1, codeMax + 1);
			st1.setInt(2, hotelId);
			st1.setString(3, name);
			st1.setString(4, detail);
			st1.setInt(5, price);
			st1.setInt(6, maxrooms);

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
		String sql = "delete from emp where code = ?";

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
