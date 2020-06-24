package jp.co.nhk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.nhk.bean.MemberBean;

public class MemberDAO {

	private Connection con;

	public MemberDAO() throws Exception {
		getConnection();
	}

	public void getConnection() throws Exception {
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
			throw new Exception("接続に失敗", e);
		}

	}

	private void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}

	public List<MemberBean> findAll() throws Exception {
		if (con == null) {
			getConnection();
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//SQL文の作成
			String sql = "select * from member";

			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			List<MemberBean> list = new ArrayList<MemberBean>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				String password = rs.getString("password");
				MemberBean bean = new MemberBean(id, name, birthday, address, tel, email, password);
				list.add(bean);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("レコードの取得に失敗しました。", e);
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
				throw new Exception("リソースの解放に失敗しました。", e);
			}
		}
	}

	public int addData(String name, String birthday, String address, String tel, String email, String password)
			throws Exception {
		if (con == null) {
			getConnection();
		}

		PreparedStatement st1 = null;
		PreparedStatement st2 = null;

		ResultSet rs = null;

		try {
			//SQL文の作成
			String sql1 = "insert into member(id,name,birthday,address,tel,email,password) values(?,?,?,?,?,?,?)";

			//現在の最終行idを持ってくる
			String sql2 = "select * from member order by id desc";
			st2 = con.prepareStatement(sql2);
			rs = st2.executeQuery();
			rs.next();
			int idMax = rs.getInt("id");

			//PreparedStatementオブジェクトの取得
			st1 = con.prepareStatement(sql1);
			st1.setInt(1, idMax + 1);
			st1.setString(2, name);
			st1.setString(3, birthday);
			st1.setString(4, tel);
			st1.setString(5, address);
			st1.setString(6, email);
			st1.setString(7, password);

			int rows = st1.executeUpdate();
			return idMax + 1;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("レコードの追加に失敗しました。", e);
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
				throw new Exception("リソースの解放に失敗しました。", e);
			}
		}
	}

	public int deleteData(int id) throws Exception {
		if (con == null) {
			getConnection();
		}

		PreparedStatement st = null;
		try {
			//SQL文の作成
			String sql = "delete from member where id = ?";

			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// 削除するid番号の設定
			st.setInt(1, id);

			int rows = st.executeUpdate();
			return rows;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("レコードの削除に失敗しました。", e);
		} finally {
			try {
				//リソースの解放
				if (st != null) {
					st.close();
				}
				close();
			} catch (Exception e) {
				throw new Exception("リソースの解放に失敗しました。", e);
			}
		}
	}

	public MemberBean findById(int idx) throws Exception {
		if (con == null) {
			getConnection();
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			//SQL文の作成
			String sql = "select * from member where id = ?";

			//PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// 年齢のセット
			st.setInt(1, idx);
			// SQL実行
			rs = st.executeQuery();
			// 結果の取得
			List<MemberBean> list = new ArrayList<MemberBean>();
			//			while (rs.next()) {
			//				int id = rs.getInt("id");
			//				String name = rs.getString("name");
			//				String birthday = rs.getString("birthday");
			//				String address = rs.getString("address");
			//				String tel = rs.getString("tel");
			//				String email = rs.getString("email");
			//				String password = rs.getString("password");
			//				MemberBean bean = new MemberBean(id, name, birthday, address, tel, email, password);
			//				list.add(bean);
			//			}
			//			return list;
			rs.next();

			MemberBean member = new MemberBean();
			member.setId(rs.getInt("id"));
			member.setName(rs.getString("name"));
			member.setBirthday(rs.getString("birthday"));
			member.setAddress(rs.getString("address"));
			member.setTel(rs.getString("tel"));
			member.setEmail(rs.getString("email"));
			member.setPassword(rs.getString("password"));

			return member;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("レコードの検索に失敗しました。", e);
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
				throw new Exception("リソースの解放に失敗しました。", e);
			}
		}
	}

	public int updateData(int id, String name, String birthday, String address, String tel, String email,
			String password)
			throws Exception {
		ResultSet rs = null;

		if (con == null) {
			getConnection();
		}

		PreparedStatement st = null;
		try {
			String sql = "SELECT * FROM member Where id=?";
			String sql2 = "UPDATE member SET name=?,birthday=?,address=?,tel=?,email=?,password=? WHERE id = ?";

			//オブジェクトの取得
			st = con.prepareStatement(sql);
			st.setInt(1, id);

			//SQLの実行
			rs = st.executeQuery();

			rs.next();
			if (name == null || name.isEmpty()) {
				name = rs.getString("name");
			}

			if (birthday == null || birthday.isEmpty()) {
				birthday = rs.getString("birthday");
			}
			if (address == null || address.isEmpty()) {
				address = rs.getString("address");
			}

			if (tel == null || tel.isEmpty()) {
				tel = rs.getString("tel");
			}
			if (email == null || email.isEmpty()) {
				email = rs.getString("email");
			}
			if (password == null || password.isEmpty()) {
				password = rs.getString("password");
			}

			st = con.prepareStatement(sql2);

			st.setString(1, name);
			st.setString(2, birthday);
			st.setString(3, tel);
			st.setString(4, address);
			st.setString(5, email);
			st.setString(6, password);
			st.setInt(7, id);

			System.out.println(st.toString());

			//プレースホルダーに値を入れる
			int rows = st.executeUpdate();
			return rows;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("レコードの削除に失敗しました。", e);
		} finally {
			try {
				//リソースの解放
				if (st != null) {
					st.close();
				}
				close();
			} catch (Exception e) {
				throw new Exception("リソースの解放に失敗しました。", e);
			}
		}
	}

}