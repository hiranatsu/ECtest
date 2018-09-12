package com.internousdev.ecsite2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/ecsite2";
	private static String user = "root";
	private static String password = "mysql";

	public Connection getConnection(){
		Connection con = null;

	//接続情報から自分のPCにインストールされ散るMySQLへ接続する準備を整える。
		try{
			Class.forName(driverName);
			con = (Connection) DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	//MySQLに接続できたか情報を渡す。
		return con;
	}

}
