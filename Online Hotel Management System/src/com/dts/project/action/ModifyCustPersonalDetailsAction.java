package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.CustomerDAO;
import com.dts.project.model.CustomerModel;

public class ModifyCustPersonalDetailsAction extends HttpServlet {

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

String target="ViewUserProfile.jsp?status=Invalid Modifying Customer Details";
		
		try{
	
	
		CustomerModel sm=new CustomerModel();
		sm.setCustid(Integer.parseInt(request.getParameter("custid")));
				
		sm.setDob(request.getParameter("dob"));
		sm.setDoj(request.getParameter("doj"));
		sm.setCusthno(request.getParameter("hno"));		
		sm.setStreet(request.getParameter("street"));		
		sm.setCity(request.getParameter("city"));
		sm.setState(request.getParameter("state"));		
		sm.setCountry(request.getParameter("country"));
		sm.setCustpin(request.getParameter("pin"));
		//sm.setCustphoto(request.getParameter("photo"));		
		sm.setEmailid(request.getParameter("emailid"));
		sm.setPhno(request.getParameter("phno"));
		
		boolean flag=new CustomerDAO().UpdateCustomerProfile(sm);
if(flag)
	target="ViewUserProfile.jsp?status=Modifying Customer Details Is Successfully";
else
	target="ViewUserProfile.jsp?status=Modifying Customer Details Is Fail";
}catch(Exception e){e.printStackTrace();}
RequestDispatcher rd = request.getRequestDispatcher(target);
rd.forward(request,response);
	}

}
