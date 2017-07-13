package com.tedu.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBTools {
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	static{
		//用static静态块初始化：在编译期间就赋值。
		Properties ps = new Properties();//专门用来读取.properties配置文件中的值
		try {
			ps.load(DBTools.class.getClassLoader().getResourceAsStream("db.properties"));//load方法用来加载这个文件
			//用getProperty分别取获取配置文件中的参数的值
			driverClass = ps.getProperty("driverClass");
			url = ps.getProperty("url");
			user = ps.getProperty("user");
			password = ps.getProperty("password");
			//加载mysql驱动
			Class.forName(driverClass);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取连接
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
	/**
	 * 利用jdbc连接数据库
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try{
			String sql = "select * from userInfo";
			//获取数据库的链接
			conn = getConnection();
			Statement st = conn.createStatement();
			ResultSet set = st.executeQuery(sql);
			while(set.next()){
				String user = set.getString("user");
				System.out.println(user);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn!=null){
				close(conn);//释放链接
			}
		}
	}
	
	/*
	 * 用来释放数据库的链接
	 */
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
