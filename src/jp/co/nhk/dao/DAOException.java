package jp.co.nhk.dao;

public class DAOException extends Exception {

	public DAOException(String message, Exception e) {
		super(message, e);
	}
}
