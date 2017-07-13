package com.tedu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tedu.entity.Emp;
import com.tedu.utils.DBTools;

/*
 * ר�������������ݿ����
 */
public class EmpDao {
	
//	private static Connection conn;
//	private static Statement statement;
//	//��̬���д��ֻ�ᱻ����һ�Σ�
//	static{
//		try{
//			conn = DBTools.getConnection();
//			statement = conn.createStatement();
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//	}
	/*
	 * ���Ա��
	 */
	public static void addEmp(Emp emp){
		StringBuffer sql = new 
		StringBuffer("insert into Emp(id,name,salary,age) values(");
		sql.append("'"+emp.getId()+"',");
		sql.append("'"+emp.getName()+"',");
		sql.append("'"+emp.getSalary()+"',");
		sql.append("'"+emp.getAge()+"')");
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
	
	/*
	 * �޸�Ա����ȫ����Ϣ��
	 */
//	public static void update(Emp emp){
//		String sql = "update Emp set id='"+emp.getId()+"'";
//	}
	
	public static void updateName(String id,String name){
		String sql = "update Emp set name='"+name+"' where id='"+id+"'";
		Connection conn = null;
		try {
			conn = DBTools.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
	}
	
	//ͨ����������һ��sql������޸�
	public static void update(String sql){
		Connection conn = null;
		try {
			conn = DBTools.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
	}
	
//	public static void updateByName(String name){
//		
//	}
	
	/*
	 * ��ѯԱ��
	 */
	public static List<Emp> findAll(String sql){
		//����һ���������ڴ�����е�emp����
		List<Emp> emps = new ArrayList<Emp>();
		Connection conn = null;
		try {
			conn = DBTools.getConnection();
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			//�������ȡ����Ӧ�����ݷ��뼯����
			while(set.next()){
				Emp emp = new Emp();
				emp.setId(set.getString("id"));
				emp.setName(set.getString("name"));
				emp.setAge(set.getString("age"));
				emp.setSalary(set.getString("salary"));
				//��ÿһ�ε�emp������뼯����
				emps.add(emp);
			}
			if(emps.size()==0){
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
		return emps;
	}
	public static Emp findById(String id){
		String sql = "select * from Emp where id='"+id+"'";
		Emp emp = new Emp();
		Connection conn = null;
		try {
			conn = DBTools.getConnection();
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			//�ж�set�Ƿ�Ϊ�գ���ֹ������ָ���쳣
			if(set.next()==false){
				return null;
			}else{
				emp.setId(set.getString("id"));
				emp.setName(set.getString("name"));
				emp.setAge(set.getString("age"));
				emp.setSalary(set.getString("salary"));
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
		return emp;
	}
	
	public static List<Emp> findByName(String name){
		String sql = "select * from Emp where name='"+name+"'";
		//����һ���������ڴ�����е�emp����
		List<Emp> emps = new ArrayList<Emp>();
		Connection conn = null;
		try {
			conn = DBTools.getConnection();
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(sql);
			//�������ȡ����Ӧ�����ݷ��뼯����
			while(set.next()){
				Emp emp = new Emp();
				emp.setId(set.getString("id"));
				emp.setName(set.getString("name"));
				emp.setAge(set.getString("age"));
				emp.setSalary(set.getString("salary"));
				//��ÿһ�ε�emp������뼯����
				emps.add(emp);
			}
			if(emps.size()==0){
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
		return emps;
	}
	
	
	/*
	 * ɾ��Ա��
	 */
//	public static void deleteAll(){
//		
//	}
	
	public static void deleteById(String id){
		String sql = "delete from Emp where id='"+id+"'";
		Connection conn = null;
		try {
			conn = DBTools.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTools.close(conn);
		}
	}
	
//	public static void deleteByName(String name){
//		
//	}
	public static void main(String[] args){
		Emp e = new Emp();
		e.setId("3");
		e.setName("tom");
		e.setSalary("100000");
		e.setAge("22");
		addEmp(e);
	}
}
