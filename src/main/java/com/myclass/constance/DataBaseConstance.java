package com.myclass.constance;

public class DataBaseConstance {
	
	//mysql
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/elearning";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "2710200072010002";
	
	public static String getDbDriver() {
		return DB_DRIVER;
	}
	public static String getDbUrl() {
		return DB_URL;
	}
	public static String getDbUsername() {
		return DB_USERNAME;
	}
	public static String getDbPassword() {
		return DB_PASSWORD;
	}
	
	
}
