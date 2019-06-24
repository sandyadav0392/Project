package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.ItemDAO;
import com.dts.project.model.ItemModel;

public class GetItemCostAction extends HttpServlet {

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

		String target="AddCustOrderDetails.jsp?status=Invalid ItemCost Details";
		
		ItemModel im=null;
		int itemid=Integer.parseInt(request.getParameter("itemid"));
		
	try{
		
		im=new ItemDAO().getItemCostDetails(itemid);
		System.out.println("--GetItemCostAction-----------------");
		System.out.println("----itemid------>"+itemid);
		System.out.println("-----------im.getCost4unit()-im.getDiscnt()--------------->"+(im.getCost4unit()-im.getDiscnt()));
		if(im!=null)
			target="AddCustOrderDetails.jsp?itmid="+itemid+"&icost="+(im.getCost4unit()-im.getDiscnt());	
		else
			target="AddCustOrderDetails.jsp?itmid="+itemid+"&icost="+0;	
		
	}
	catch(Exception e){e.printStackTrace();}
	
	RequestDispatcher rd = request.getRequestDispatcher(target);
	rd.forward(request,response);
	
	}

}
