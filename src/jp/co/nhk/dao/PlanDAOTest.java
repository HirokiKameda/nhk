package jp.co.nhk.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import jp.co.nhk.bean.PlanBean;

class PlanDAOTest extends PlanDAO {

	/*
	@Test
	void test() {
		//fail("まだ実装されていません");
		PlanDAO planDAO = new PlanDAO();
		List<PlanBean> listPlan = new ArrayList<PlanBean>();
		try {
			listPlan = planDAO.findAll();
	
			//１と３行目をチェック
			//1行目→1,'山の幸プラン１','野菜たくさん',8000,12
			Assertions.assertEquals(1, listPlan.get(0).getHotelId());
			Assertions.assertEquals("山の幸プラン１", listPlan.get(0).getName());
			Assertions.assertEquals("野菜たくさん", listPlan.get(0).getDetail());
			Assertions.assertEquals(8000, listPlan.get(0).getPrice());
			Assertions.assertEquals(12, listPlan.get(0).getMaxrooms());
	
			//３行目→1,'山の幸プラン３','野菜たくさん',8000,12
			Assertions.assertEquals(1, listPlan.get(2).getHotelId());
			Assertions.assertEquals("山の幸プラン３", listPlan.get(2).getName());
			Assertions.assertEquals("野菜たくさん", listPlan.get(2).getDetail());
			Assertions.assertEquals(8000, listPlan.get(2).getPrice());
			Assertions.assertEquals(12, listPlan.get(2).getMaxrooms());
	
		} catch (DAOException e) {
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
		PlanDAO planDAO = new PlanDAO();
		PlanBean planBean = new PlanBean();
		try {
			planBean = planDAO.findBy(2);
	
			//2行目をチェック
			//2行目→1,'山の幸プラン２','野菜たくさん',8000,12
			Assertions.assertEquals(1, planBean.getHotelId());
			Assertions.assertEquals("山の幸プラン２", planBean.getName());
			Assertions.assertEquals("野菜たくさん", planBean.getDetail());
			Assertions.assertEquals(8000, planBean.getPrice());
			Assertions.assertEquals(12, planBean.getMaxrooms());
	
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
		//fail("まだ実装されていません");
		PlanDAO planDAO = new PlanDAO();
		PlanBean planBean = new PlanBean();
	
		System.out.println(price);
		try {
	
			//データベース1行目を変更
			planDAO.update(1, 1, "焼肉プラン", "お肉たくさん", 10000, 10);
			planBean = planDAO.findBy(1);
	
			//変更した1行目をチェック
			//変更前→1,'山の幸プラン２','野菜たくさん',8000,12
			//変更後→2, "焼肉プラン", "お肉たくさん", 10000, 10
			Assertions.assertEquals(1, planBean.getHotelId());
			Assertions.assertEquals("焼肉プラン", planBean.getName());
			Assertions.assertEquals("お肉たくさん", planBean.getDetail());
			Assertions.assertEquals(10000, planBean.getPrice());
			Assertions.assertEquals(10, planBean.getMaxrooms());
	
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
	//updateメソッドのテスト
		//すべての引数に値を入れたパターン
		PlanDAO planDAO = new PlanDAO();
		PlanBean planBean = new PlanBean();
		try {
	
			//データベース1行目を変更
			planDAO.update(1, 1, "焼肉プラン", "お肉たくさん", 10000, 10);
			planBean = planDAO.findBy(1);
	
			//変更した1行目をチェック
			//変更前→1,'山の幸プラン２','野菜たくさん',8000,12
			//変更後→2, "焼肉プラン", "お肉たくさん", 10000, 10
			Assertions.assertEquals(1, planBean.getHotelId());
			Assertions.assertEquals("焼肉プラン", planBean.getName());
			Assertions.assertEquals("お肉たくさん", planBean.getDetail());
			Assertions.assertEquals(10000, planBean.getPrice());
			Assertions.assertEquals(10, planBean.getMaxrooms());
	
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
		//updateメソッドのテスト
		//string型引数に空文字を入れ、int型引数に0を入れたパターン
	
		PlanDAO planDAO = new PlanDAO();
		PlanBean planBean = new PlanBean();
	
		int id = 1;
		int hotelId = 1;
		String name = "焼肉プラン2";
		String detail = "";
		int price = 0;
		int maxrooms = 0;
	
		try {
	
			//データベース1行目を変更
			planDAO.update(id, hotel_id, name, detail, price, maxrooms);
			planBean = planDAO.findBy(1);
	
			//変更したレコード1をチェック
			//変更前→1, "焼肉プラン", "お肉たくさん", 10000, 10
			//変更後→1, "焼肉プラン2", "お肉たくさん", 10000, 10
			Assertions.assertEquals(1, planBean.getHotelId());
			Assertions.assertEquals("焼肉プラン2", planBean.getName());
			Assertions.assertEquals("お肉たくさん", planBean.getDetail());
			Assertions.assertEquals(10000, planBean.getPrice());
			Assertions.assertEquals(10, planBean.getMaxrooms());
	
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
	void test() {
		//updateメソッドのテスト
		//string型引数にnullを入れ、int型引数に0を入れたパターン
	
		PlanDAO planDAO = new PlanDAO();
		PlanBean planBean = new PlanBean();
	
		int id = 1;
		int hotelId = 1;
		String name = "焼肉プラン3";
		String detail = "";
		int price = 0;
		int maxrooms = 0;
	
		try {
	
			//データベース1行目を変更
			planDAO.update(id, hotel_id, name, detail, price, maxrooms);
			planBean = planDAO.findBy(1);
	
			//変更したレコード1をチェック
			//変更前→1, "焼肉プラン", "お肉たくさん", 10000, 10
			//変更後→1, "焼肉プラン3", "お肉たくさん", 10000, 10
			Assertions.assertEquals(1, planBean.getHotelId());
			Assertions.assertEquals("焼肉プラン3", planBean.getName());
			Assertions.assertEquals("お肉たくさん", planBean.getDetail());
			Assertions.assertEquals(10000, planBean.getPrice());
			Assertions.assertEquals(10, planBean.getMaxrooms());
	
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
	void test6() {
		//insertメソッドのテスト
	
		PlanDAO planDAO = new PlanDAO();
		PlanBean planBean = new PlanBean();
	
		int hotelId = 1;
		String name = "魚介プラン";
		String detail = "新鮮なお魚たくさん";
		int price = 9000;
		int maxrooms = 10;
	
		try {
	
			//データベース1行目を変更
			planDAO.insert(hotelId, name, detail, price, maxrooms);
			planBean = planDAO.findBy(4);
	
			//追加したレコードをチェック
			//1, "魚介プラン", "新鮮なお魚たくさん", 9000, 10
			Assertions.assertEquals(1, planBean.getHotelId());
			Assertions.assertEquals("魚介プラン", planBean.getName());
			Assertions.assertEquals("新鮮なお魚たくさん", planBean.getDetail());
			Assertions.assertEquals(9000, planBean.getPrice());
			Assertions.assertEquals(10, planBean.getMaxrooms());
	
		} catch (
	
		DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			fail();
		}
	
	}
	*/

	//@Test
	void test7() {
		//deleteメソッドのテスト

		PlanDAO planDAO = new PlanDAO();
		PlanBean planBean = new PlanBean();

		try {

			planDAO.delete(1);

			//削除できたかをDBで確認
			//ここではdeleteが例外を出さないことを確認

		} catch (

		DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			fail();
		}

	}

	/*
	@BeforeEach
	void delete() {
		String url = "jdbc:postgresql:sample";
		String user = "student";
		String pass = "himitu";
	
		//String sql = "'\'i inn.sql";
		String sql = "delete from plan";
	
		String sql2 = "INSERT INTO plan (hotel_id,name,detail,price,maxrooms) VALUES(1,'山の幸プラン１','野菜たくさん',8000,12)";
		String sql3 = "INSERT INTO plan (hotel_id,name,detail,price,maxrooms) VALUES(1,'山の幸プラン２','野菜たくさん',8000,12)";
		String sql4 = "INSERT INTO plan (hotel_id,name,detail,price,maxrooms) VALUES(1,'山の幸プラン２','野菜たくさん',8000,12)";
	
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
	@Test
	void testtttt() {
		//findbyhotelメソッドのテスト

		PlanDAO dao = new PlanDAO();
		try {
			List<PlanBean> list = dao.findByHotel(1);
			for (PlanBean b : list) {
				System.out.println(b.getName());
			}
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			fail();
		}

	}

}
