package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.HotelDAO;
import com.dts.project.model.HotelModel;

public class AddHotelAction extends HttpServlet {

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
HotelModel htlmodel=null;
if(status.equalsIgnoreCase("Add Hotel")){

String target="AddHotel.jsp?status=Invalid Add Hotel Details";
		try{
		
		
		 htlmodel=new HotelModel();
		 htlmodel.setHotelname(request.getParameter("hname"));
		 htlmodel.setHotelpltno(request.getParameter("hpltno"));
		 htlmodel.setHtlstreet(request.getParameter("hstreet"));		
		 htlmodel.setHotelcity(request.getParameter("city"));
		 htlmodel.setHotelstate(request.getParameter("state"));
		 htlmodel.setHotelpin(request.getParameter("pin"));
		 htlmodel.setHotelstdate(request.getParameter("stdate"));
		 htlmodel.setInchrgid(Integer.parseInt(request.getParameter("inchrgname")));
		 htlmodel.setHotelmailid(request.getParameter("mailid"));
		 htlmodel.setContactno(request.getParameter("contactno"));
		 boolean flag=new HotelDAO().addHotel(htlmodel);
		 
		 if(flag)
				target="AddHotel.jsp?status=Add Hotel Is Successful";
			else
				target="AddHotel.jsp?status=Add Hotel Is Fail";
			}
			catch(Exception e){e.printStackTrace();}
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);
			
}

if(status.equalsIgnoreCase("Update Hotel Details")){

	String target="ViewAllHotels.jsp?status=Invalid Update Hotel Details";
			try{
			
			
			 htlmodel=new HotelModel();
			 htlmodel.setHotelid(Integer.parseInt(request.getParameter("hhid")));
			 htlmodel.setHotelpltno(request.getParameter("hpltno"));
			 htlmodel.setHtlstreet(request.getParameter("street"));		
			 htlmodel.setHotelcity(request.getParameter("city"));
			 htlmodel.setHotelstate(request.getParameter("state"));
			 htlmodel.setHotelpin(request.getParameter("pin"));
			 htlmodel.setHotelstdate(request.getParameter("stdate"));
			 htlmodel.setInchrgid(Integer.parseInt(request.getParameter("inchrgid")));
			 htlmodel.setHotelmailid(request.getParameter("mailid"));
			 htlmodel.setContactno(request.getParameter("contactno"));
			 boolean flag=new HotelDAO().UpdateHotelDetails(htlmodel);
			 
			 if(flag)
					target="ViewAllHotels.jsp?status=Update Hotels Is Successful";
				else
					target="ViewAllHotels.jsp?status=Update Hotels Is Fail";
				}
				catch(Exception e){e.printStackTrace();}
				RequestDispatcher rd = request.getRequestDispatcher(target);
				rd.forward(request,response);
				
	}


	}

}
