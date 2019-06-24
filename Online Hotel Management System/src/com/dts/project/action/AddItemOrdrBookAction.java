package com.dts.project.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.project.dao.BookTypeDAO;
import com.dts.project.dao.CustomerDAO;
import com.dts.project.dao.FacilityDAO;
import com.dts.project.dao.ItemDAO;
import com.dts.project.dao.RoomDAO;
import com.dts.project.model.BookTypeModel;
import com.dts.project.model.CustomerModel;
import com.dts.project.model.FacilityModel;
import com.dts.project.model.ItemModel;
import com.dts.project.model.OrderModel;
import com.dts.project.model.RoomTypeModel;

public class AddItemOrdrBookAction extends HttpServlet {

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
		ItemModel im=null;
		FacilityModel fm=null;
		RoomTypeModel rm=null;
		BookTypeModel  bm=null;
		OrderModel omodel=null;
		
		if(status.equalsIgnoreCase("Add Item")){		
        String target="AddItems.jsp?status=Invalid Add Item Details";
		
		try{
	
	
		im=new ItemModel();
		im.setItemname(request.getParameter("iname"));				
		im.setItemtypename(request.getParameter("itype"));
		im.setItemdesc(request.getParameter("idesc"));
		im.setCost4unit(Double.parseDouble(request.getParameter("icost")));
		im.setDiscnt(Double.parseDouble(request.getParameter("idiscount")));
		
		
		boolean flag=new ItemDAO().addItem(im);
if(flag)
	target="AddItems.jsp?status=Add Item Details Is Successfully";
else
	target="AddItems.jsp?status=Add Item Details Is Fail";
}catch(Exception e){e.printStackTrace();}
RequestDispatcher rd = request.getRequestDispatcher(target);
rd.forward(request,response);

		}
		
		if(status.equalsIgnoreCase("Update Item Details")){
			
			String target="ViewAllItems.jsp?status=Invalid Modify Item Details";
					
					try{
				
				
					im=new ItemModel();
					im.setItemid(Integer.parseInt(request.getParameter("iid")));				
					im.setItemtypename(request.getParameter("itype"));
					im.setItemdesc(request.getParameter("idesc"));
					im.setCost4unit(Double.parseDouble(request.getParameter("icost")));
					im.setDiscnt(Double.parseDouble(request.getParameter("idiscount")));
					
					
					boolean flag=new ItemDAO().UpdateItem(im);
			if(flag)
				target="ViewAllItems.jsp?status=Modify Item Details Is Successfully";
			else
				target="ViewAllItems.jsp?status=Modify Item Details Is Fail";
			}catch(Exception e){e.printStackTrace();}
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);

					}	
		
		
		
            if(status.equalsIgnoreCase("Give Order")){
			
			    String target="SearchItems.jsp?status=Invalid Add OrderItem Details";
					
					try{
				
				
					im=new ItemModel();
					im.setCustid(Integer.parseInt(request.getParameter("custid")));
					im.setItemid(Integer.parseInt(request.getParameter("itemid")));				
					im.setItemtypename(request.getParameter("otype"));
					im.setQuantity(Integer.parseInt(request.getParameter("quantity")));				
					im.setOrdrdate(request.getParameter("stdate"));
					im.setHotelid(Integer.parseInt(request.getParameter("hname")));						
					im.setTotalcost(Double.parseDouble(request.getParameter("tcost")));	
					im.setCardnumber(Long.parseLong(request.getParameter("cnum")));
					im.setPin(Integer.parseInt(request.getParameter("pnum")));					
					im.setExpdate(request.getParameter("exdate"));
					im.setCvv2(Integer.parseInt(request.getParameter("cvv")));
					
					boolean flag=new ItemDAO().addCustOrdersDetails(im);
			if(flag)
				target="SearchItems.jsp?status=Add Order Item Details Is Successfully";
			else
				target="SearchItems.jsp?status=Add Order Item Details Is Fail";
			}catch(Exception e){e.printStackTrace();}
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request,response);

					}
            
            
            if(status.equalsIgnoreCase("Add Facility")){		
                String target="Facilitymaster.jsp?status=Invalid Add facility Details";
        		
        		try{

        		fm=new FacilityModel();
        		//rakesh
        		String fname=request.getParameter("fname");
        		String filename=request.getParameter("fdesc");
        		String stdate=request.getParameter("");
        		
        		
        		//----------------------
        		fm.setFacilname(request.getParameter("fname"));
        		
        		fm.setFacildtls(request.getParameter("fdesc")); 
        		
        		fm.setStdate(request.getParameter("stdate"));
        		fm.setAditionalchrg(Double.parseDouble(request.getParameter("aditionalchrg")));
        		fm.setHotelname(request.getParameter("hotelname"));
        		
        		fm.setHotelid(Integer.parseInt(request.getParameter("hotelname")));
        		
        		
        		//boolean flag=new FacilityDAO().AddFacility(fm);
        		boolean flag=new FacilityDAO().addfacilityRakesh(fm);
        if(flag)
        	target="Facilitymaster.jsp?status=Add Facility Details Is Successfully";
        else
        	target="Facilitymaster.jsp?status=Add Facility Details Is Fail";
        }catch(Exception e){e.printStackTrace();}
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);

        		}
            
		
            if(status.equalsIgnoreCase("Add Room Types")){		
                String target="AddRoomTypes.jsp?status=Invalid Add Room Types Details";
        		
        		try{
        	
        	
        		rm=new RoomTypeModel();
        		rm.setRoomtypename(request.getParameter("rtname"));				
        		rm.setCost4room(Double.parseDouble(request.getParameter("cost")));
        		rm.setNoofroom(Integer.parseInt(request.getParameter("noofroom")));
        		rm.setHotelid(Integer.parseInt(request.getParameter("hotelname")));
        		rm.setFacilityid(Integer.parseInt(request.getParameter("facilname")));
        		rm.setRoomdesc(request.getParameter("rdesc"));
        		
        		
        		
        		boolean flag=new RoomDAO().AddRoomTypes(rm);
        if(flag)
        	target="AddRoomTypes.jsp?status=Add Room Types Details Is Successfully";
        else
        	target="AddRoomTypes.jsp?status=Add Room Types Details Is Fail";
        }catch(Exception e){e.printStackTrace();}
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);

        		}
        		    
            if(status.equalsIgnoreCase("Update Room Type Details")){		
                String target="ViewAllRoomTypes.jsp?status=Invalid Modify Room Types Details";
        		
        		try{
        	
        	
        		rm=new RoomTypeModel();
        		rm.setRoomtypeid(Integer.parseInt(request.getParameter("rtid")));				
        		rm.setCost4room(Double.parseDouble(request.getParameter("cost")));
        		rm.setNoofroom(Integer.parseInt(request.getParameter("noofroom")));
        		rm.setHotelid(Integer.parseInt(request.getParameter("hotelname")));
        		rm.setFacilityid(Integer.parseInt(request.getParameter("facilname")));
        		rm.setRoomdesc(request.getParameter("rdesc"));
        		rm.setRoomstatus(request.getParameter("rstatus"));
        		
        		
        		
        		boolean flag=new RoomDAO().UpdateRoomTypes(rm);
        if(flag)
        	target="ViewAllRoomTypes.jsp?status=Modify Room Types Details Is Successfully";
        else
        	target="ViewAllRoomTypes.jsp?status=Modify Room Types Details Is Fail";
        }catch(Exception e){e.printStackTrace();}
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);

        		}
            
            
            if(status.equalsIgnoreCase("Add Book Types")){		
                String target="AddBookingTypes.jsp?status=Invalid Book  Types Details";
        		
        		try{
        	
        	
        		bm=new BookTypeModel();
        		bm.setBooktypename(request.getParameter("bktypename"));				
        		bm.setCostperHour(Double.parseDouble(request.getParameter("cost")));
        		bm.setBooktypedesc(request.getParameter("desc"));
        		
        		boolean flag=new BookTypeDAO().addBookingType(bm);
        if(flag)
        	target="AddBookingTypes.jsp?status=Add Book Types Details Is Successfully";
        else
        	target="AddBookingTypes.jsp?status=Add Book Types Details Is Fail";
        }catch(Exception e){e.printStackTrace();}
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);

        		}		       
          
            
            
            if(status.equalsIgnoreCase("Update Book Type Details")){		
                String target="ViewBookingTypes.jsp?status=Invalid Book Types Details";
        		
        		try{
        	
        	
        		bm=new BookTypeModel();
        		bm.setBooktypeid(Integer.parseInt(request.getParameter("bktid")));				
        		bm.setCostperHour(Double.parseDouble(request.getParameter("cost")));
        		bm.setBooktypedesc(request.getParameter("desc"));
        		bm.setBooktypestatus(request.getParameter("status"));
        		
        		boolean flag=new BookTypeDAO().UpdateBookingType(bm);
        if(flag)
        	target="ViewBookingTypes.jsp?status=Modify Book Types Details Is Successfully";
        else
        	target="ViewBookingTypes.jsp?status=Modify Book Types Details Is Fail";
        }catch(Exception e){e.printStackTrace();}
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);

        		}
            
            if(status.equalsIgnoreCase("Update Facility Details")){		
                String target="ViewAllFacilities.jsp?status=Invalid Facility Details";
        		
        		try{
        	
        	
        		fm=new FacilityModel();
        		fm.setFacilid(Integer.parseInt(request.getParameter("fclid")));				
        		fm.setStdate(request.getParameter("stdate"));
        		fm.setAditionalchrg(Double.parseDouble(request.getParameter("charges")));
        		fm.setFacildtls(request.getParameter("fdtls"));
        		fm.setFacilstatus(request.getParameter("status"));
        		
        		boolean flag=new FacilityDAO().UpdateFacilityDetails(fm);
        if(flag)
        	target="ViewAllFacilities.jsp?status=Modify Facility Details Is Successfully";
        else
        	target="ViewAllFacilities.jsp?status=Modify Facility Details Is Fail";
        }catch(Exception e){e.printStackTrace();}
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);

        		}
           
            if(status.equalsIgnoreCase("Delete Facility")){		
                String target="ViewAllFacilities.jsp?status=Invalid Facility Details";
        		
        		try{
        	
        	
        		fm=new FacilityModel();
        		fm.setFacilid(Integer.parseInt(request.getParameter("fid")));				
        		
        		boolean flag=new FacilityDAO().DeleteFacilityDetails(fm);
        if(flag)
        	target="ViewAllFacilities.jsp?status=Modify Facility Details Is Successfully";
        else
        	target="ViewAllFacilities.jsp?status=Modify Facility Details Is Fail";
        }catch(Exception e){e.printStackTrace();}
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);

        		}  
            
            
            if(status.equalsIgnoreCase("Update Cust Ordr Shiping Details")){		
                String target="ViewCustomerOrders.jsp?status=Invalid Order Details";
        		
        		try{
        	
        	
        		omodel=new OrderModel();
        		
        		omodel.setOrderid(Integer.parseInt(request.getParameter("ordrid")));				
        		omodel.setOrdertypename(request.getParameter("otype"));
        		omodel.setShipingid(Integer.parseInt(request.getParameter("shpid")));        		
        		omodel.setCustid(Integer.parseInt(request.getParameter("custid")));				
        		omodel.setEmpid(Integer.parseInt(request.getParameter("empid")));       		
        		omodel.setHotelid(Integer.parseInt(request.getParameter("htlid")));	
        		
        		omodel.setQuantity(Integer.parseInt(request.getParameter("quantity")));	
        		omodel.setCartid(Integer.parseInt(request.getParameter("cnum")));
        		omodel.setTotalcost(Double.parseDouble(request.getParameter("cost")));
        		omodel.setOrderdate(request.getParameter("odate"));
        		omodel.setOrderstate(request.getParameter("state"));
        		omodel.setShippeddate(request.getParameter("shippeddate"));
        		
        		boolean flag=new ItemDAO().UpdateCustOrdrShipingDetails(omodel);
        if(flag)
        	target="ViewCustomerOrders.jsp?status=Modify Order Details Is Successfully";
        else
        	target="ViewCustomerOrders.jsp?status=Modify Order Details Is Fail";
        }catch(Exception e){e.printStackTrace();}
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response);

        		}
                   
            
            
	}

}
