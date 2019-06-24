package com.dts.dae.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.dae.dao.ProfileDAO;
import com.dts.dae.model.Profile;

public class RegisterAction extends HttpServlet {

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
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		doPost(request,response);
		}
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
        
		String target="RegisterForm.jsp?status=Registration Is Invalid";
		String day=request.getParameter("day");
		String month=request.getParameter("month");
		String year=request.getParameter("year");
		String date=day+"-"+month+"-"+year;
		System.out.println("date"+date);
		try{
		 Profile rb = new Profile(); 
	    rb.setFirstName(request.getParameter("firstName"));
	    rb.setMiddleName(request.getParameter("middleName"));
        rb.setLastName(request.getParameter("lastName"));         
        rb.setPhoto(request.getParameter("browsePhoto"));
        rb.setBirthDate(date);       
        rb.setDateOfJoin(request.getParameter("doj"));
        rb.setAddress(request.getParameter("address"));
        rb.setSal(Double.parseDouble(request.getParameter("salary"))); 
        
        
        rb.setDesigId(Integer.parseInt(request.getParameter("designator")));   
        rb.setDeptId(Integer.parseInt(request.getParameter("deptname")));
        rb.setQualId(Integer.parseInt(request.getParameter("hqualification"))); 
        
        rb.setGender(request.getParameter("gender"));        
        rb.setManagerid(Integer.parseInt(request.getParameter("manager")));
        rb.setConstituencyid(Integer.parseInt(request.getParameter("cname")));
        rb.setQuestionid(Integer.parseInt(request.getParameter("question")));
        rb.setSecretqans(request.getParameter("answer"));
        rb.setMartialstatus(request.getParameter("mstatus"));
        rb.setEmail(request.getParameter("emailid"));
        
        boolean flag=new ProfileDAO().register(rb);
        
        if(flag) 
           target = "RegisterForm.jsp?status=Registration Is Success"; 
        else  
            target = "RegisterForm.jsp?status=Registration Is Failed"; 
            }catch(Exception e){e.printStackTrace();}
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);
	}

}
