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

public class AddCustomerAction extends HttpServlet {

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

String target="AddCustomer.jsp?status=Invalid Customer Registration";
CustomerModel sm=null;
CustomerModel cm=null;
		try{
	
	
		sm=new CustomerModel();
		
		String day=request.getParameter("day");
		String month=request.getParameter("month");
		String year=request.getParameter("year");
		String bd=day+"-"+month+"-"+year;
		
		
		String jday=request.getParameter("jday");
		String jmonth=request.getParameter("jmonth");
		String jyear=request.getParameter("jyear");
		String jbd=jday+"-"+jmonth+"-"+jyear;
		
		sm.setCustfname(request.getParameter("firstname"));
		sm.setCustmname(request.getParameter("middlename"));
		sm.setCustlname(request.getParameter("lastname"));		
		sm.setDob(bd);
		sm.setDoj(jbd);
		sm.setCusthno(request.getParameter("hno"));		
		sm.setStreet(request.getParameter("street"));		
		sm.setCity(request.getParameter("city"));
		sm.setState(request.getParameter("state"));		
		sm.setCountry(request.getParameter("country"));
		
		
		sm.setCustpin(request.getParameter("pin"));
		sm.setCustphoto(request.getParameter("photo"));
		//sm.setLogintype(request.getParameter("supplier"));
		sm.setEmailid(request.getParameter("emailid"));
		sm.setPhno(request.getParameter("phno"));
		
		cm=new CustomerDAO().addCustomerProfile(sm);
if(cm!=null)
	target="AddCustomer.jsp?status=Registration Is Successfully &uname="+cm.getCustuname()+"&upass="+cm.getCustpass();
else
	target="AddCustomer.jsp?status=Customer Registration Is Fail";
}catch(Exception e){e.printStackTrace();}
RequestDispatcher rd = request.getRequestDispatcher(target);
rd.forward(request,response);
	}

}
