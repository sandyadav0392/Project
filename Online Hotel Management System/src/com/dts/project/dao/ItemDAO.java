package com.dts.project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.project.model.CustomerModel;
import com.dts.project.model.HotelModel;
import com.dts.project.model.ItemModel;
import com.dts.project.model.OrderModel;

public class ItemDAO extends AbstractDataAccessObject {

	public boolean flag=false;
	public Connection con=null;
	
	
public boolean addItem(ItemModel additem){
		
		
		
		CallableStatement cstmt=null;
		  try 
		    {
			 
	        	
	        	con=getConnection();		       
		        cstmt=con.prepareCall("{ call ADD_ITEM(?,?,?,?,?)}");
         cstmt.setString(1, additem.getItemname());
         cstmt.setString(2, additem.getItemtypename());
         cstmt.setString(3, additem.getItemdesc());
         cstmt.setDouble(4, additem.getCost4unit());
         cstmt.setDouble(5, additem.getDiscnt());         
         
		       int i= cstmt.executeUpdate();
		         if(i==1)
		         {
		          flag=true;
		          con.commit();
		         }
		         else
		         {
		        	 flag=false;
		        	 con.rollback();
		         }

		    } 
		    
		    catch (Exception e) 
		    {
		        e.printStackTrace();
		        flag=false;
		        try 
		        {
		            con.rollback();
		        } 
		        catch (SQLException se) 
		        {
		            se.printStackTrace();
		        }
		    }
		    
		    finally
			{
			 try{
				 if(con!=null)
					 con.close();				 
			 }
			 catch(Exception e){}
			}
		    return flag;
		
	}
	



public boolean UpdateItem(ItemModel additem){
	
	
	
	CallableStatement cstmt=null;
	  try 
	    {
		 
        	
        	con=getConnection();		       
	        cstmt=con.prepareCall("{ call UPDATE_ITEM(?,?,?,?,?)}");
     cstmt.setInt(1, additem.getItemid());
     cstmt.setString(2, additem.getItemtypename());
     cstmt.setString(3, additem.getItemdesc());
     cstmt.setDouble(4, additem.getCost4unit());
     cstmt.setDouble(5, additem.getDiscnt());         
     
	       int i= cstmt.executeUpdate();
	         if(i==1)
	         {
	          flag=true;
	          con.commit();
	         }
	         else
	         {
	        	 flag=false;
	        	 con.rollback();
	         }

	    } 
	    
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	        flag=false;
	        try 
	        {
	            con.rollback();
	        } 
	        catch (SQLException se) 
	        {
	            se.printStackTrace();
	        }
	    }
	    
	    finally
		{
		 try{
			 if(con!=null)
				 con.close();				 
		 }
		 catch(Exception e){}
		}
	    return flag;
	
}




public boolean addCustOrdersDetails(ItemModel addorders){
	
	
	
	CallableStatement cstmt=null;
	  try 
	    {
		 
        	
        	con=getConnection();		       
	        cstmt=con.prepareCall("{ call ADD_CUST_ORDR(?,?,?,?,?,?,?,?,?,?,?)}");
    
	 cstmt.setInt(1, addorders.getItemid());
     cstmt.setString(2, addorders.getItemtypename());
     cstmt.setInt(3, addorders.getQuantity());
     cstmt.setString(4, DateWrapper.parseDate(addorders.getOrdrdate()));
     cstmt.setInt(5, addorders.getHotelid()); 
     cstmt.setInt(6, addorders.getCustid()); 
     cstmt.setDouble(7, addorders.getTotalcost());
     cstmt.setLong(8, addorders.getCardnumber()); 
     cstmt.setInt(9, addorders.getPin()); 
     cstmt.setString(10, DateWrapper.parseDate(addorders.getExpdate()));
     cstmt.setInt(11, addorders.getCvv2());
     
	       int i= cstmt.executeUpdate();
	       System.out.println("--------i--------"+i);
	       
	         if(i==1)
	         {
	          flag=true;
	          con.commit();
	         }
	         else
	         {
	        	 flag=false;
	        	 con.rollback();
	         }

	    } 
	    
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	        flag=false;
	        try 
	        {
	            con.rollback();
	        } 
	        catch (SQLException se) 
	        {
	            se.printStackTrace();
	        }
	    }
	    
	    finally
		{
		 try{
			 if(con!=null)
				 con.close();				 
		 }
		 catch(Exception e){e.printStackTrace();}
		}
	    
	    System.out.println("------flag-------->"+flag);
	    return flag;
	
}





public boolean UpdateCustOrdrShipingDetails(OrderModel updateorders){
	
	
	
	CallableStatement cstmt=null;
	  try 
	    {
		 
        	
        	con=getConnection();		       
	        cstmt=con.prepareCall("{ call UPDATE_CUST_ORDR_SHIP(?,?,?,?,?,?,?,?,?,?,?,?)}");
    
	  
	 
     cstmt.setInt(1, updateorders.getOrderid());
     cstmt.setString(2, updateorders.getOrdertypename()); 
     cstmt.setInt(3, updateorders.getShipingid()); 
     cstmt.setInt(4, updateorders.getCustid());      
     cstmt.setInt(5, updateorders.getHotelid());    
     cstmt.setInt(6, updateorders.getQuantity());
     cstmt.setLong(7, updateorders.getCartid()); 
     cstmt.setDouble(8, updateorders.getTotalcost());
     cstmt.setString(9, DateWrapper.parseDate(updateorders.getOrderdate()));
     cstmt.setString(10, updateorders.getOrderstate());       
     cstmt.setString(11, DateWrapper.parseDate(updateorders.getShippeddate()));
     cstmt.setInt(12, updateorders.getEmpid());
   
     
	       int i= cstmt.executeUpdate();
	       System.out.println("--------i--------"+i);
	       
	         if(i==1)
	         {
	          flag=true;
	          con.commit();
	         }
	         else
	         {
	        	 flag=false;
	        	 con.rollback();
	         }

	    } 
	    
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	        flag=false;
	        try 
	        {
	            con.rollback();
	        } 
	        catch (SQLException se) 
	        {
	            se.printStackTrace();
	        }
	    }
	    
	    finally
		{
		 try{
			 if(con!=null)
				 con.close();				 
		 }
		 catch(Exception e){e.printStackTrace();}
		}
	    
	    System.out.println("------flag-------->"+flag);
	    return flag;
	
}



public CoreHash getAllItemDetails(){
	CoreHash aCoreHash=new CoreHash();
	aCoreHash.clear();
	System.out.println("aCoreHash--"+aCoreHash.isEmpty());
	int sno=1;
	Statement cstmt;
	ItemModel imodel=null;
	try {
		 con = getConnection();
		   
		
        	 cstmt=con.createStatement();
        	String sql="select *from itemmaster";
        	 ResultSet rs=cstmt.executeQuery(sql);
        	 while(rs.next())
             {
          	imodel=new ItemModel();          	  
          	imodel.setItemid(rs.getInt(1));
          	imodel.setItemname(rs.getString(2)); 
          	imodel.setItemtypename(rs.getString(3)); 
          	imodel.setItemdesc(rs.getString(4)); 
          	imodel.setCost4unit(rs.getDouble(5)); 
          	imodel.setDiscnt(rs.getDouble(6)); 
          	
           	   
          	 aCoreHash.put(new Integer(sno),imodel);
			    sno++;
		  
             }
	}
	catch(Exception e)
	{e.printStackTrace();
		LoggerManager.writeLogWarning(e);
	}
	finally
	{
	 try{
		 if(con!=null)
			 con.close();
		 
	 }
	 catch(Exception e){}
	}
	return aCoreHash;
}



public ItemModel getPerticularItemDetails(int itemid){
	//CoreHash aCoreHash=new CoreHash();
	//aCoreHash.clear();
	//System.out.println("aCoreHash--"+aCoreHash.isEmpty());
	int sno=1;
	Statement cstmt;
	ItemModel imodel=null;
	try {
		 con = getConnection();
		   
		
        	 cstmt=con.createStatement();
        	String sql="select *from itemmaster where itemid="+itemid;
        	 ResultSet rs=cstmt.executeQuery(sql);
        	 while(rs.next())
             {
          	imodel=new ItemModel();          	  
          	imodel.setItemid(rs.getInt(1));
          	imodel.setItemname(rs.getString(2)); 
          	imodel.setItemtypename(rs.getString(3)); 
          	imodel.setItemdesc(rs.getString(4)); 
          	imodel.setCost4unit(rs.getDouble(5)); 
          	imodel.setDiscnt(rs.getDouble(6)); 
          	
           	   
          	// aCoreHash.put(new Integer(sno),imodel);
			  //  sno++;
		  
             }
	}
	catch(Exception e)
	{e.printStackTrace();
		LoggerManager.writeLogWarning(e);
	}
	finally
	{
	 try{
		 if(con!=null)
			 con.close();
		 
	 }
	 catch(Exception e){}
	}
	return imodel;
}




public ItemModel getItemCostDetails(int itemid){
	//CoreHash aCoreHash=new CoreHash();
	//aCoreHash.clear();
	//System.out.println("aCoreHash--"+aCoreHash.isEmpty());
	int sno=1;
	Statement cstmt;
	ItemModel imodel=null;
	try {
		 con = getConnection();
		   
		
        	 cstmt=con.createStatement();
        	String sql="select *from itemmaster where itemid="+itemid;
        	 ResultSet rs=cstmt.executeQuery(sql);
        	 while(rs.next())
             {
          	imodel=new ItemModel();          	  
          	imodel.setItemid(rs.getInt(1));
          	imodel.setItemname(rs.getString(2)); 
          	imodel.setItemtypename(rs.getString(3)); 
          	imodel.setItemdesc(rs.getString(4)); 
          	imodel.setCost4unit(rs.getDouble(5)); 
          	imodel.setDiscnt(rs.getDouble(6)); 
          	
           	   
          	// aCoreHash.put(new Integer(sno),imodel);
			  //  sno++;
		  
             }
	}
	catch(Exception e)
	{e.printStackTrace();
		LoggerManager.writeLogWarning(e);
	}
	finally
	{
	 try{
		 if(con!=null)
			 con.close();
		 
	 }
	 catch(Exception e){}
	}
	return imodel;
}
	





public CoreHash getCostOrderShips(){
	CoreHash aCoreHash=new CoreHash();
	aCoreHash.clear();
	System.out.println("aCoreHash--"+aCoreHash.isEmpty());
	int sno=1;
	Statement cstmt;
	OrderModel omodel=null;
	try {
		 con = getConnection();
		   
		
        	 cstmt=con.createStatement();
        	String sql="SELECT  ODTLS.ORDERID,ODMSTR.ORDERTYPE, ODTLS.CUSTID, CM.CFSTNAME, ODTLS.ITEMID, ITM.ITEMNAME, ODTLS.SHIPINGID, ODTLS.HOTELID, HM.HOTELNAME, ODTLS.TOTALCOST, ODTLS.CARTID,  ODMSTR.ODRQUANTITY, TO_CHAR(ODMSTR.ODRDATE,'DD-MM-YY'), ODMSTR.ODRSTATE FROM  ORDERDTLS ODTLS, ORDERMSTR ODMSTR, ITEMMASTER ITM, CUSTOMER CM,HOTELMASTER HM WHERE (ODTLS.ORDERID=ODMSTR.ORDERID) AND(ODTLS.ITEMID=ITM.ITEMID) AND(ODTLS.CUSTID=CM.CUSTID) AND(ODTLS.HOTELID=HM.HOTELID) AND UPPER(ODMSTR.ODRSTATE) LIKE UPPER('ACTIVE')  ORDER BY ODTLS.ORDERID DESC";
        	 ResultSet rs=cstmt.executeQuery(sql);
        	 while(rs.next())
             {
          	omodel=new OrderModel();          	  
          	omodel.setOrderid(rs.getInt(1));
          	omodel.setOrdertypename(rs.getString(2)); 
          	omodel.setCustid(rs.getInt(3)); 
          	omodel.setCustname(rs.getString(4));
          	omodel.setItemid(rs.getInt(5)); 
          	omodel.setItemname(rs.getString(6));
          	omodel.setShipingid(rs.getInt(7));
          	omodel.setHotelid(rs.getInt(8)); 
          	omodel.setHotelname(rs.getString(9));         	
          	
          	omodel.setTotalcost(rs.getDouble(10)); 
          	omodel.setCartid(rs.getInt(11));           	
          	omodel.setQuantity(rs.getInt(12)); 
          	omodel.setOrderdate(rs.getString(13));
          	omodel.setOrderstate(rs.getString(14));       	
          	
           	   
          	 aCoreHash.put(new Integer(sno),omodel);
			   sno++;
		  
             }
	}
	catch(Exception e)
	{e.printStackTrace();
		LoggerManager.writeLogWarning(e);
	}
	finally
	{
	 try{
		 if(con!=null)
			 con.close();
		 
	 }
	 catch(Exception e){}
	}
	return aCoreHash;
}




public OrderModel getEachCustOrderShipsDetails(int ordrid){
	CoreHash aCoreHash=new CoreHash();
	aCoreHash.clear();
	System.out.println("aCoreHash--"+aCoreHash.isEmpty());
	int sno=1;
	Statement cstmt;
	OrderModel omodel=null;
	try {
		 con = getConnection();
		   
		
        	 cstmt=con.createStatement();
        	String sql="SELECT  ODTLS.ORDERID,ODMSTR.ORDERTYPE, ODTLS.CUSTID, CM.CFSTNAME, ODTLS.ITEMID, ITM.ITEMNAME, ODTLS.SHIPINGID, ODTLS.HOTELID, HM.HOTELNAME, ODTLS.TOTALCOST, ODTLS.CARTID,  ODMSTR.ODRQUANTITY, TO_CHAR(ODMSTR.ODRDATE,'DD-MM-YY'), ODMSTR.ODRSTATE FROM  ORDERDTLS ODTLS, ORDERMSTR ODMSTR, ITEMMASTER ITM, CUSTOMER CM,HOTELMASTER HM WHERE (ODTLS.ORDERID=ODMSTR.ORDERID) AND(ODTLS.ITEMID=ITM.ITEMID) AND(ODTLS.CUSTID=CM.CUSTID) AND(ODTLS.HOTELID=HM.HOTELID) AND UPPER(ODMSTR.ODRSTATE) LIKE UPPER('ACTIVE') AND ODMSTR.ORDERID="+ordrid+" ORDER BY ODTLS.ORDERID DESC";
        	 ResultSet rs=cstmt.executeQuery(sql);
        	 while(rs.next())
             {
          	omodel=new OrderModel();          	  
          	omodel.setOrderid(rs.getInt(1));
          	omodel.setOrdertypename(rs.getString(2)); 
          	omodel.setCustid(rs.getInt(3)); 
          	omodel.setCustname(rs.getString(4));
          	omodel.setItemid(rs.getInt(5)); 
          	omodel.setItemname(rs.getString(6));
          	omodel.setShipingid(rs.getInt(7));
          	omodel.setHotelid(rs.getInt(8)); 
          	omodel.setHotelname(rs.getString(9));         	
          	
          	omodel.setTotalcost(rs.getDouble(10)); 
          	omodel.setCartid(rs.getInt(11));           	
          	omodel.setQuantity(rs.getInt(12)); 
          	omodel.setOrderdate(rs.getString(13));
          	omodel.setOrderstate(rs.getString(14));       	
          	
           	   
          	 aCoreHash.put(new Integer(sno),omodel);
			   sno++;
		  
             }
	}
	catch(Exception e)
	{e.printStackTrace();
		LoggerManager.writeLogWarning(e);
	}
	finally
	{
	 try{
		 if(con!=null)
			 con.close();
		 
	 }
	 catch(Exception e){}
	}
	return omodel;
}

}
