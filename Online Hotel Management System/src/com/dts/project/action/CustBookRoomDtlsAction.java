package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.BookTypeDAO;
import com.dts.project.model.BookTypeModel;
import com.dts.project.model.FacilityModel;
import com.dts.project.model.ItemModel;
import com.dts.project.model.RoomTypeModel;

public class CustBookRoomDtlsAction extends HttpServlet {

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
		
		BookTypeModel  bm=null;
		
		
		
		//if(status.equalsIgnoreCase("Book Room Types")){		
             String target="CustomerBookingRoomDetails.jsp?status=Invalid Bookings  Details";
     		
     		try{
     	
     	
     		bm=new BookTypeModel();
     		
     		System.out.println("--------bm----------->"+bm);
     		bm.setRoomtypeid(Integer.parseInt(request.getParameter("roomtype")));				
     		bm.setCustid(Integer.parseInt(request.getParameter("custid")));
     		bm.setBooktypeid(Integer.parseInt(request.getParameter("bookingtype")));
     		bm.setNoofroomsforbook(Integer.parseInt(request.getParameter("nofrooms")));
     		bm.setRegdate(request.getParameter("rstdate"));
     		bm.setBookfrmdate(request.getParameter("fromdate"));
     		bm.setBooktodate(request.getParameter("todate"));
     		bm.setBookfrmtime(request.getParameter("fromtime"));
     		bm.setBooktotime(request.getParameter("totime"));
     		bm.setCartid(Long.parseLong(request.getParameter("cnum")));	        		
     		bm.setTtbookamount(Double.parseDouble(request.getParameter("bamt")));    		
     		boolean flag=new BookTypeDAO().CustOrderForBooking(bm);     		
     		System.out.println("------------flag------->"+flag);
     if(flag)
     	target="CustomerBookingRoomDetails.jsp?status=Booking Rooms Is Successfully";
     else
     	target="CustomerBookingRoomDetails.jsp?status=Booking  Rooms Is Fail Or Booking IS Full";
     }catch(Exception e){e.printStackTrace();}
     RequestDispatcher rd = request.getRequestDispatcher(target);
     rd.forward(request,response);

     	//	} 
		
	}

}
