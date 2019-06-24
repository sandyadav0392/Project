package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.project.dao.ItemDAO;
import com.dts.project.dao.RoomDAO;
import com.dts.project.model.CustomerModel;
import com.dts.project.model.ItemModel;
import com.dts.project.model.RoomTypeModel;

public class GetAvailRoomsAction extends HttpServlet {

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

String target="CustomerBookingRoomDetails.jsp?status=Invalid Room Details";
		
		RoomTypeModel cm=null;
		int rtid=Integer.parseInt(request.getParameter("rtid"));
		
	try{
		
		cm=new RoomDAO().getAvailNoOfRoomDetails(rtid);
		HttpSession session=request.getSession();		
		session.setAttribute("getRoomtypeCostDls", cm);
		
		if(cm!=null)
			target="CustomerBookingRoomDetails.jsp?noofrooms="+cm.noofroom+"&roomcost="+cm.cost4room+"&rmtypid="+cm.roomtypeid;	
		else
			target="CustomerBookingRoomDetails.jsp?status=No Room Are Not Available";	
		
	}
	catch(Exception e){e.printStackTrace();}
	
	RequestDispatcher rd = request.getRequestDispatcher(target);
	rd.forward(request,response);
	}

}
