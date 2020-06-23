package jp.co.nhk.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jp.co.nhk.bean.HotelBean;

class HotelDAOTest extends HotelDAO {

	@Test
	@DisplayName("insertできるか実験")
	void test() {
		//fail("まだ実装されていません");
		HotelDAO dao = new HotelDAO();
		//1
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		try {
			//			Date date = sdf.parse("15:00:00");
			//			java.sql.Date sqlDate1 = new java.sql.Date(date.getTime());
			//			Date date2 = sdf.parse("10:00:00");
			//			java.sql.Date sqlDate2 = new java.sql.Date(date.getTime());
			//2
			String str1 = "15:00:00";
			String str2 = "10:00:00";

			dao.insert("あけぼの", "春を感じる旅館", "岐阜", str1, str2, "0120-12-5784");
		} catch (DAOException e1) {
			// TODO 自動生成された catch ブロック
			fail();
		}
		//String str = new SimpleDateFormat("kk:mm:ss").format("15:00:00");
		//java.sql.Date sqlDate1 = java.sql.Date.valueOf("15:00:00");
		//String str2 = new SimpleDateFormat("kk:mm:ss").format("10:00:00");
		//java.sql.Date sqlDate2 = java.sql.Date.valueOf("10:00:00");

		//dao.insert("あけぼの", "春を感じる旅館", "岐阜", sqlDate1, sqlDate2, "0120-12-5784");

	}

	//@Test
	@DisplayName("updateできるか(全入力)")
	void test2() {
		int id = 2;
		String name = "ハッピーホーム";
		String intro = "ど〇ぶつの森ネタです";
		String address = "無人島";
		String checkin = "15:00";
		String checkout = "12:00";
		String tel = "111-222-333";
		HotelDAO dao = new HotelDAO();
		try {
			dao.update(id, name, intro, address, checkin, checkout, tel);
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			fail();
		}
	}

	@Test
	@DisplayName("updateできるか(名前変更)")
	void test3() {
		int id = 2;
		String name = null;
		String intro = null;
		String address = "";
		String checkin = "";
		String checkout = "";
		String tel = "111-111-1111";
		HotelDAO dao = new HotelDAO();
		try {
			dao.update(id, name, intro, address, checkin, checkout, tel);
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			fail();
		}
	}

	@Test
	@DisplayName("deleteできるか")
	void test4() {
		HotelDAO dao = new HotelDAO();
		try {
			dao.delete(3);
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			fail();
		}
	}

	@Test
	@DisplayName("findAllできるか")
	void test5() {
		HotelDAO dao = new HotelDAO();
		try {
			List<HotelBean> list = dao.findAll();
			for (HotelBean li : list) {
				System.out.println(li.getName());
			}
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			fail();
		}
	}

	@Test
	@DisplayName("findByできるか")
	void test6() {
		HotelDAO dao = new HotelDAO();
		try {
			HotelBean bean = dao.findBy(2);
			System.out.println(bean.getName());
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			fail();
		}
	}

}
