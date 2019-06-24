package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.EmpRegistrationDAO;
import com.dts.project.model.EmpModel;

public class EmpRegistration extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

String target="EmployeesRegistration.jsp?status=Invalid REgistration";
EmpModel em=null;
		try{
	
	
		 em=new EmpModel();
		
		String day=request.getParameter("day");
		String month=request.getParameter("month");
		String year=request.getParameter("year");
		String bd=day+"-"+month+"-"+year;
		
		
		String jday=request.getParameter("jday");
		String jmonth=request.getParameter("jmonth");
		String jyear=request.getParameter("jyear");
		String jbd=jday+"-"+jmonth+"-"+jyear;
		
		em.setFirstname(request.getParameter("firstname"));
		em.setMiddlename(request.getParameter("middlename"));
		em.setLastname(request.getParameter("lastname"));		
		em.setDob(bd);
		em.setDoj(jbd);
		em.setAddress(request.getParameter("address"));		
		em.setEmailid(request.getParameter("emailid"));		
		em.setSal(Double.parseDouble(request.getParameter("salary")));
		em.setPhoto(request.getParameter("photo"));		
		em.setPhno(request.getParameter("phno"));
		em.setPerformrank(Integer.parseInt(request.getParameter("rank")));		
		em.setDesgid(Integer.parseInt(request.getParameter("disgnation")));		
		em.setDeptid(Integer.parseInt(request.getParameter("dname")));
		em.setMstatus(request.getParameter("mstatus"));
		em.setEmpid(Integer.parseInt(request.getParameter("manager")));		
		em.setGender(request.getParameter("gender"));
		em.setQualid(Integer.parseInt(request.getParameter("qualification")));
		em.setQuestionid(Integer.parseInt(request.getParameter("question")));		
		em.setAnswer(request.getParameter("answer"));				
		  
		
		boolean flag=new EmpRegistrationDAO().addemp(em);
if(flag)
	target="EmployeesRegistration.jsp?status=Employee Registration Is Successfully";
else
	target="EmployeesRegistration.jsp?status=Employee Registration Is Fail";
}catch(Exception e){e.printStackTrace();}
RequestDispatcher rd = request.getRequestDispatcher(target);
rd.forward(request,response);
	}

}
