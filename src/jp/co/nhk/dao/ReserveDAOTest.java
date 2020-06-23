package jp.co.nhk.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.co.nhk.bean.ReserveBean;

class ReserveDAOTest extends ReserveDAO {

	/*
	@Test
	void test1() {
		//fail("まだ実装されていません");
		ReserveDAO reserveDAO = new ReserveDAO();
		List<ReserveBean> listReserve = new ArrayList<ReserveBean>();
		try {
			listReserve = reserveDAO.findAll();
	
			//			System.out.println(listReserve.get(0).getReservetime());
	
			//１と３行目をチェック
	
			//取り出してくるsqlのDate型データをString型に変換
			//１行目
			String reservedateStr1 = new SimpleDateFormat("yyyy-MM-dd").format(listReserve.get(0).getReservedate());
			String reservetimeStr1 = new SimpleDateFormat("hh:mm:ss").format(listReserve.get(0).getReservetime());
			String checkindateStr1 = new SimpleDateFormat("yyyy-MM-dd").format(listReserve.get(0).getCheckindate());
			String checkoutdateStr1 = new SimpleDateFormat("yyyy-MM-dd").format(listReserve.get(0).getCheckoutdate());
	
			//３行目
			String reservedateStr3 = new SimpleDateFormat("yyyy-MM-dd").format(listReserve.get(2).getReservedate());
			String reservetimeStr3 = new SimpleDateFormat("hh:mm:ss").format(listReserve.get(2).getReservetime());
			String checkindateStr3 = new SimpleDateFormat("yyyy-MM-dd").format(listReserve.get(2).getCheckindate());
			String checkoutdateStr3 = new SimpleDateFormat("yyyy-MM-dd").format(listReserve.get(2).getCheckoutdate());
	
			//レコード１→ 1 |       1 |         1 | 2020-06-01  | 12:18:52    | 2020-08-11  | 2020-08-12   |     1 |      2
			Assertions.assertEquals(1, listReserve.get(0).getPlanId());
			Assertions.assertEquals(1, listReserve.get(0).getMemberId());
			Assertions.assertEquals("2020-06-01", reservedateStr1);
			Assertions.assertEquals("12:18:52", reservetimeStr1);
			Assertions.assertEquals("2020-08-11", checkindateStr1);
			Assertions.assertEquals("2020-08-12", checkoutdateStr1);
			Assertions.assertEquals(1, listReserve.get(0).getRooms());
			Assertions.assertEquals(2, listReserve.get(0).getPeople());
	
			//レコード3→  3 |       1 |         3 | 2020-06-03  | 12:18:52    | 2020-08-11  | 2020-08-12   |     1 |      2
			Assertions.assertEquals(1, listReserve.get(2).getPlanId());
			Assertions.assertEquals(3, listReserve.get(2).getMemberId());
			Assertions.assertEquals("2020-06-03", reservedateStr3);
			Assertions.assertEquals("12:18:52", reservetimeStr3);
			Assertions.assertEquals("2020-08-11", checkindateStr3);
			Assertions.assertEquals("2020-08-12", checkoutdateStr3);
			Assertions.assertEquals(1, listReserve.get(2).getRooms());
			Assertions.assertEquals(2, listReserve.get(2).getPeople());
	
		} catch (
	
		DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			fail();
		}
	
	}
	*/

	/*
	@Test
	void test2() {
		//fail("まだ実装されていません");
		ReserveDAO reserveDAO = new ReserveDAO();
		ReserveBean reserveBean = new ReserveBean();
		try {
			reserveBean = reserveDAO.findBy(2);
	
			//レコード2をチェック
			//取り出してくるsqlのDate型データをString型に変換
			String reservedateStr1 = new SimpleDateFormat("yyyy-MM-dd").format(reserveBean.getReservedate());
			String reservetimeStr1 = new SimpleDateFormat("hh:mm:ss").format(reserveBean.getReservetime());
			String checkindateStr1 = new SimpleDateFormat("yyyy-MM-dd").format(reserveBean.getCheckindate());
			String checkoutdateStr1 = new SimpleDateFormat("yyyy-MM-dd").format(reserveBean.getCheckoutdate());
	
			//レコード2→ 2 |       1 |         2 | 2020-06-02  | 12:18:52    | 2020-08-11  | 2020-08-12   |     1 |      2
			Assertions.assertEquals(1, reserveBean.getPlanId());
			Assertions.assertEquals(2, reserveBean.getMemberId());
			Assertions.assertEquals("2020-06-02", reservedateStr1);
			Assertions.assertEquals("12:18:52", reservetimeStr1);
			Assertions.assertEquals("2020-08-11", checkindateStr1);
			Assertions.assertEquals("2020-08-12", checkoutdateStr1);
			Assertions.assertEquals(1, reserveBean.getRooms());
			Assertions.assertEquals(2, reserveBean.getPeople());
	
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			fail();
		}
	
	}
	*/

	/*
	@Test
	void test3() {
		//updateメソッドのすべての列の変更の場合をテスト
		ReserveDAO reserveDAO = new ReserveDAO();
		ReserveBean reserveBean = new ReserveBean();
	
		int id = 1;
		int planId = 2;
		int memberId = 10;
		Date reservedate = Date.valueOf("2020-06-10");
		Time reservetime = Time.valueOf("22:18:52");
		Date checkindate = Date.valueOf("2020-08-21");
		Date checkoutdate = Date.valueOf("2020-08-22");
		int rooms = 2;
		int people = 4;
	
		//		System.out.println(reservetime);
		try {
	
			//データベース1行目を変更
			reserveDAO.updateData(id, planId, memberId, reservedate, reservetime, checkindate, checkoutdate, rooms,
					people);
			reserveBean = reserveDAO.findBy(1);
	
			//変更したレコード1をチェック
			//取り出してくるsqlのDate型データをString型に変換
			String reservedateStr1 = new SimpleDateFormat("yyyy-MM-dd").format(reserveBean.getReservedate());
			String reservetimeStr1 = new SimpleDateFormat("HH:mm:ss").format(reserveBean.getReservetime());
			//hhは12時間制。HHは24時間制。DBに合わせてHHにする必要がある。
			String checkindateStr1 = new SimpleDateFormat("yyyy-MM-dd").format(reserveBean.getCheckindate());
			String checkoutdateStr1 = new SimpleDateFormat("yyyy-MM-dd").format(reserveBean.getCheckoutdate());
	
			//			System.out.println(reservetimeStr1);
			//変更したレコード1をチェック
			//変更前→ 1 |       1 |         1 | 2020-06-01  | 12:18:52    | 2020-08-11  | 2020-08-12   |     1 |      2
			//変更後→ 1 |       2 |         10 | 2020-06-10  | 22:18:52    | 2020-08-21  | 2020-08-22   |     2 |      4
			Assertions.assertEquals(2, reserveBean.getPlanId());
			Assertions.assertEquals(10, reserveBean.getMemberId());
			Assertions.assertEquals("2020-06-10", reservedateStr1);
			Assertions.assertEquals("22:18:52", reservetimeStr1);
			Assertions.assertEquals("2020-08-21", checkindateStr1);
			Assertions.assertEquals("2020-08-22", checkoutdateStr1);
			Assertions.assertEquals(2, reserveBean.getRooms());
			Assertions.assertEquals(4, reserveBean.getPeople());
	
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			fail();
		}
	
	}
	*/

	/*
	@Test
	void test4() {
		//updateDataメソッドのテスト
		//一つだけ変更
		//それ以外はdate型、time型の引数にはnullを入れ、int型引数に0を入れたパターン
		ReserveDAO reserveDAO = new ReserveDAO();
		ReserveBean reserveBean = new ReserveBean();
	
		int id = 1;
		int planId = 0;
		int memberId = 4;
	
		Date reservedate = null;
		Time reservetime = null;
		Date checkindate = null;
		Date checkoutdate = null;
	
		int rooms = 0;
		int people = 0;
	
		try {
	
			//データベース1行目を変更
			reserveDAO.updateData(id, planId, memberId, reservedate, reservetime, checkindate, checkoutdate, rooms,
					people);
			reserveBean = reserveDAO.findBy(1);
	
			//変更したレコード1をチェック
			//取り出してくるsqlのDate型データをString型に変換
			String reservedateStr1 = new SimpleDateFormat("yyyy-MM-dd").format(reserveBean.getReservedate());
			String reservetimeStr1 = new SimpleDateFormat("HH:mm:ss").format(reserveBean.getReservetime());
			//hhは12時間制。HHは24時間制。DBに合わせてHHにする必要がある。
			String checkindateStr1 = new SimpleDateFormat("yyyy-MM-dd").format(reserveBean.getCheckindate());
			String checkoutdateStr1 = new SimpleDateFormat("yyyy-MM-dd").format(reserveBean.getCheckoutdate());
	
			//			System.out.println(reservetimeStr1);
			//変更したレコード1をチェック
			//変更前→ 1 |       2 |         10 | 2020-06-10  | 22:18:52    | 2020-08-21  | 2020-08-22   |     2 |      4
			//変更後→ 1 |       2 |         11 | 2020-06-10  | 22:18:52    | 2020-08-21  | 2020-08-22   |     2 |      4
			Assertions.assertEquals(2, reserveBean.getPlanId());
			Assertions.assertEquals(11, reserveBean.getMemberId());
			Assertions.assertEquals("2020-06-10", reservedateStr1);
			Assertions.assertEquals("22:18:52", reservetimeStr1);
			Assertions.assertEquals("2020-08-21", checkindateStr1);
			Assertions.assertEquals("2020-08-22", checkoutdateStr1);
			Assertions.assertEquals(2, reserveBean.getRooms());
			Assertions.assertEquals(4, reserveBean.getPeople());
	
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			fail();
		}
	
	}
	*/

	/*
	@Test
	void test5() {
		//insertメソッドのテスト
	
		ReserveDAO reserveDAO = new ReserveDAO();
		ReserveBean reserveBean = new ReserveBean();
	
		int id = 1;
		int planId = 1;
		int memberId = 4;
		Date reservedate = Date.valueOf("2020-06-04");
		Time reservetime = Time.valueOf("12:18:52");
		Date checkindate = Date.valueOf("2020-08-11");
		Date checkoutdate = Date.valueOf("2020-08-12");
		int rooms = 1;
		int people = 2;
		try {
	
			//データベース1行目を変更
			reserveDAO.insert(planId, memberId, reservedate, reservetime, checkindate, checkoutdate, rooms,
					people);
			reserveBean = reserveDAO.findBy(4);
	
			//変更したレコード1をチェック
			//取り出してくるsqlのDate型データをString型に変換
			String reservedateStr1 = new SimpleDateFormat("yyyy-MM-dd").format(reserveBean.getReservedate());
			String reservetimeStr1 = new SimpleDateFormat("HH:mm:ss").format(reserveBean.getReservetime());
			//hhは12時間制。HHは24時間制。DBに合わせてHHにする必要がある。
			String checkindateStr1 = new SimpleDateFormat("yyyy-MM-dd").format(reserveBean.getCheckindate());
			String checkoutdateStr1 = new SimpleDateFormat("yyyy-MM-dd").format(reserveBean.getCheckoutdate());
	
			//レコード４→ 1 |       1 |         4 | 2020-06-04  | 12:18:52    | 2020-08-11  | 2020-08-12   |     1 |      2
			Assertions.assertEquals(1, reserveBean.getPlanId());
			Assertions.assertEquals(4, reserveBean.getMemberId());
			Assertions.assertEquals("2020-06-04", reservedateStr1);
			Assertions.assertEquals("12:18:52", reservetimeStr1);
			Assertions.assertEquals("2020-08-11", checkindateStr1);
			Assertions.assertEquals("2020-08-12", checkoutdateStr1);
			Assertions.assertEquals(1, reserveBean.getRooms());
			Assertions.assertEquals(2, reserveBean.getPeople());
	
		} catch (
	
		DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			fail();
		}
	
	}
	*/

	///*
	@Test
	void test6() {
		//deleteDataメソッドのテスト

		ReserveDAO reserveDAO = new ReserveDAO();
		ReserveBean reserveBean = new ReserveBean();

		try {

			reserveDAO.deleteData(1);

			//削除できたかをDBで確認
			//ここではdeleteDataが例外を出さないことを確認

		} catch (

		DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			fail();
		}

	}
	//*/

	/*
	@BeforeEach
	void delete() {
		String url = "jdbc:postgresql:sample";
		String user = "student";
		String pass = "himitu";
	
		//String sql = "'\'i inn.sql";
		String sql = "delete from reservation";
	
		String sql2 = "INSERT INTO reservation (hotel_id,name,detail,price,maxrooms) VALUES(1,'山の幸プラン１','野菜たくさん',8000,12)";
		String sql3 = "INSERT INTO reservation (hotel_id,name,detail,price,maxrooms) VALUES(1,'山の幸プラン２','野菜たくさん',8000,12)";
		String sql4 = "INSERT INTO reservation (hotel_id,name,detail,price,maxrooms) VALUES(1,'山の幸プラン２','野菜たくさん',8000,12)";
	
		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				PreparedStatement st2 = con.prepareStatement(sql2);
				PreparedStatement st3 = con.prepareStatement(sql3);
				PreparedStatement st4 = con.prepareStatement(sql4);) {
	
			st.executeUpdate();
			st2.executeUpdate();
			st3.executeUpdate();
			st4.executeUpdate();
	
		} catch (
	
		SQLException e) {
			e.printStackTrace();
		}
	
	}
	*/

}
