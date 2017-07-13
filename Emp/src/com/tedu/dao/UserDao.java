package com.tedu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tedu.entity.Emp;
import com.tedu.entity.UserInfo;
import com.tedu.utils.DBTools;

public  class UserDao {
	
	public static List<UserInfo> findAll(String sql){
		Connection conn = null;
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			conn = DBTools.getConnection();
			Statement st = conn.createStatement();
			ResultSet set = st.executeQuery(sql);
			while(set.next()){
				UserInfo user = new UserInfo();
				user.setId(set.getString("id"));
				user.setIdentity(set.getString("identity"));
				user.setPassword(set.getString("password"));
				user.setPhone(set.getString("phone"));
				user.setUser(set.getString("user"));
				list.add(user);
			}
			if(list.size()==0){
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
		return list;
	}
	
	//根据名字查找
	public static UserInfo findByName(String name){
		String sql = "select * from userinfo where user='"+name+"'";
		UserInfo user = new UserInfo();
		Connection conn = null;
		try {
			conn = DBTools.getConnection();
			Statement st = conn.createStatement();
			ResultSet set = st.executeQuery(sql);
			if(set.next()==false){
				return null;
			}else{
				user.setId(set.getString("id"));
				user.setIdentity(set.getString("identity"));
				user.setPassword(set.getString("password"));
				user.setPhone(set.getString("phone"));
				user.setUser(set.getString("user"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
		return user;
	}
	
	public static void addUser(UserInfo user){
		StringBuffer sql = new 
		StringBuffer("insert into userinfo(id,user,password,phone,identity) values(");
		sql.append("'"+user.getId()+"',");
		sql.append("'"+user.getUser()+"',");
		sql.append("'"+user.getPassword()+"',");
		sql.append("'"+user.getPhone()+"',");
		sql.append("'"+user.getIdentity()+"')");
		Connection conn = null;
		try {
			conn = DBTools.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
	}
}

