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
		//��static��̬���ʼ�����ڱ����ڼ�͸�ֵ��
		Properties ps = new Properties();//ר��������ȡ.properties�����ļ��е�ֵ
		try {
			ps.load(DBTools.class.getClassLoader().getResourceAsStream("db.properties"));//load����������������ļ�
			//��getProperty�ֱ�ȡ��ȡ�����ļ��еĲ�����ֵ
			driverClass = ps.getProperty("driverClass");
			url = ps.getProperty("url");
			user = ps.getProperty("user");
			password = ps.getProperty("password");
			//����mysql����
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
	 * ��ȡ����
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
	/**
	 * ����jdbc�������ݿ�
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try{
			String sql = "select * from userInfo";
			//��ȡ���ݿ������
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
				close(conn);//�ͷ�����
			}
		}
	}
	
	/*
	 * �����ͷ����ݿ������
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
