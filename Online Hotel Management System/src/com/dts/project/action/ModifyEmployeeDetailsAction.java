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

public class ModifyEmployeeDetailsAction extends HttpServlet {

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
String status=request.getParameter("submit");

EmpModel em=null;
	if(status.equalsIgnoreCase("Update")){	
		
		String target="ViewEmployeePersonalProfile.jsp?status=Invalid Update Employee Details";
		
		try{		
		 em=new EmpModel();			
		em.setEmpid(Integer.parseInt(request.getParameter("empid")));
		em.setFirstname(request.getParameter("ename"));
		em.setDob(request.getParameter("dob"));
		em.setDoj(request.getParameter("doj"));
		em.setAddress(request.getParameter("addrs"));		
		em.setEmailid(request.getParameter("emailid"));		
		em.setSal(Double.parseDouble(request.getParameter("sal")));
		em.setPhoto(request.getParameter("photo"));		
		em.setPhno(request.getParameter("phno"));		
		em.setDesgid(Integer.parseInt(request.getParameter("disgnation")));		
		em.setDeptid(Integer.parseInt(request.getParameter("dname")));
		em.setMstatus(request.getParameter("mstatus"));
		em.setEmpinchargid(Integer.parseInt(request.getParameter("inchrgid")));		
		em.setGender(request.getParameter("gender"));
		em.setQualid(Integer.parseInt(request.getParameter("qualname")));
		em.setUsername(request.getParameter("username"));
		em.setPassword(request.getParameter("password"));
		em.setPerformrank(Integer.parseInt(request.getParameter("rank")));			
		  
		
		boolean flag=new EmpRegistrationDAO().UpdateEmpProfileDetails(em);
if(flag)
	target="ViewEmployeePersonalProfile.jsp?status=Update Employee Details Is Successfully";
else
	target="ViewEmployeePersonalProfile.jsp?status=Update Employee Details Is Fail";
}catch(Exception e){e.printStackTrace();}
RequestDispatcher rd = request.getRequestDispatcher(target);
rd.forward(request,response);

	}
	
	
	
	
	
	if(status.equalsIgnoreCase("Update Employee Details")){	

		
				
				String target="ViewAllEmployees.jsp?status=Invalid Update Employee Details";
				
				try{		
				 em=new EmpModel();			
				em.setEmpid(Integer.parseInt(request.getParameter("empid")));			
				em.setFirstname(request.getParameter("ename"));
				
				em.setDob(request.getParameter("dob"));
				em.setDoj(request.getParameter("doj"));
				em.setAddress(request.getParameter("addrs"));		
				em.setEmailid(request.getParameter("emailid"));		
				em.setSal(Double.parseDouble(request.getParameter("sal")));
				em.setPhoto(request.getParameter("photo"));		
				em.setPhno(request.getParameter("phno"));		
				em.setDesgid(Integer.parseInt(request.getParameter("disgnation")));		
				em.setDeptid(Integer.parseInt(request.getParameter("dname")));
				em.setMstatus(request.getParameter("mstatus"));
				em.setEmpinchargid(Integer.parseInt(request.getParameter("inchrgid")));		
				em.setGender(request.getParameter("gender"));
				em.setQualid(Integer.parseInt(request.getParameter("qualname")));
				em.setUsername(request.getParameter("username"));
				em.setPassword(request.getParameter("password"));
				em.setPerformrank(Integer.parseInt(request.getParameter("rank")));			
				  
				
				boolean flag=new EmpRegistrationDAO().UpdateEmpProfileDetails(em);
		if(flag)
			target="ViewAllEmployees.jsp?status=Update Employee Details Is Successfully";
		else
			target="ViewAllEmployees.jsp?status=Update Employee Details Is Fail";
		}catch(Exception e){e.printStackTrace();}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request,response);

			}
	}

}
