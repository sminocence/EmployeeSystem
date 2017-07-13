package com.tedu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.dao.EmpDao;
import com.tedu.dao.UserDao;
import com.tedu.entity.Emp;
import com.tedu.entity.UserInfo;
import com.tedu.utils.UUIDUtil;

public class EmpServlet extends HttpServlet{
	//����Servlet����
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//��ȡ�û�������·��
		String uri = request.getRequestURI();
//		System.out.println(uri);
		String action = uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
//		System.out.println(action);
		if("/login".equals(action)){//������ý�login������equals
			loginService(request, response);
		}else if("/add".equals(action)){
			addService(request,response);
		}else if("/addEmp".equals(action)){
			addEmpService(request, response);
		}else if("/list".equals(action)){
			listEmp(request, response);
		}else if("/del".equals(action)){
			deleteEmp(request, response);
		}else if("/load".equals(action)){
			loadEmpService(request,response);
		}else if("/modify".equals(action)){
			modifyEmpService(request,response);
		}
	}
	
	/*
	 * �޸�Ա����Ϣ
	 */
	private void modifyEmpService(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String salary = request.getParameter("salary");
		String id = request.getParameter("id");
		Emp emp = new Emp();
		emp.setAge(age);
		emp.setName(name);
		emp.setSalary(salary);
		String sql = "update emp set "
				+ "name='"+name+"',age='"+age+"',salary='"+salary+
				"' where id='"+id+"'";
		EmpDao.update(sql);
		response.sendRedirect("/Emp/list.do");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * ��ѯһ��Ա����Ϣ����modifyEmpService
	 */
	private void loadEmpService(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String id = request.getParameter("id");
			Emp emp = EmpDao.findById(id);
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("/html/updateEmp.jsp")
			.forward(request,response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * ɾ��Ա��
	 */
	public void deleteEmp(HttpServletRequest request,
			HttpServletResponse response){
		try {
			String id = request.getParameter("id");
			EmpDao.deleteById(id);
			response.sendRedirect("/Emp/list.do");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/*
	 * ���Ա������Ϣ
	 */
	public void addEmpService(HttpServletRequest request,HttpServletResponse response){
		try{
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String salary = request.getParameter("salary");
			Emp emp = new Emp();
			emp.setAge(age);
			emp.setName(name);
			emp.setSalary(salary);
			emp.setId(UUIDUtil.getUuid32());
			//�������ݿ�
			EmpDao.addEmp(emp);
			response.sendRedirect("/Emp/list.do");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void listEmp(HttpServletRequest request,
			HttpServletResponse response){
		try {
			//��ѯԱ����Ϣ����������Ϣ��ʾ����ҳ
			String empSql = "select * from emp";
			List<Emp> emps = EmpDao.findAll(empSql);
			//����setAtrribute�����ݴ��͸�ǰ��ҳ��
			request.setAttribute("emps", emps);
			//ת��
			request.getRequestDispatcher
			("/html/listEmp.jsp").forward
			(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * ע�Ṧ�ܣ������Ϣ
	 */
	public void addService(HttpServletRequest request,HttpServletResponse response){
		String user = request.getParameter("yh");
		String pass = request.getParameter("m");
		String passWord = request.getParameter("qr");
		String identity = request.getParameter("sf");
		String phone = request.getParameter("phone");
		if(!pass.equals(passWord)){
			System.out.println("���벻ƥ��");
			return;
		}
		//�����ݿ��ѯ�������û��Ƿ��Ѿ�ע�����
		UserInfo info = UserDao.findByName(user);
		if(info == null){
			UserInfo userinfo = new UserInfo();
			userinfo.setId("3");
			userinfo.setIdentity(identity);
			userinfo.setPassword(passWord);
			userinfo.setPhone(phone);
			userinfo.setUser(user);
			//��������
			UserDao.addUser(userinfo);
			try {
				response.sendRedirect("/Emp/html/index.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("���û��Ѿ�����");
		}
	}
	public void loginService(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String user = request.getParameter("ind_zhanghao");
		String password = request.getParameter("ind_mima");
		UserInfo userinfo = UserDao.findByName(user);
		if(userinfo == null){
			//������һ����������ʾ�˻�������
			response.sendRedirect("/Emp/html/zhuce.jsp");
		}else{
			String pas = userinfo.getPassword();//�����ݿ����ѯ������
			if(!pas.equals(password)){
				System.out.println("�������");
				response.sendRedirect("/Emp/html/index.html");
			}else{
//				try {
//					//��ѯԱ����Ϣ����������Ϣ��ʾ����ҳ
//					String empSql = "select * from emp";
//					List<Emp> emps = EmpDao.findAll(empSql);
//					//����setAtrribute�����ݴ��͸�ǰ��ҳ��
//					request.setAttribute("emps", emps);
//					//ת��
//					request.getRequestDispatcher
//					("/html/listEmp.jsp").forward
//					(request, response);
//				} catch (ServletException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				response.sendRedirect("/Emp/list.do");
			}
		}
	}
	
}
