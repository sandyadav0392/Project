package com.dts.project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.project.model.BookTypeModel;
import com.dts.project.model.CustomerModel;
import com.dts.project.model.HotelModel;

public class BookTypeDAO extends AbstractDataAccessObject {
	public boolean flag=false;
	public Connection con=null;
	
	
public boolean addBookingType(BookTypeModel btype){
		
		
		CallableStatement cstmt=null;
		  try 
		    {
			  
		    	
	        	
	        	con=getConnection();		       
		        cstmt=con.prepareCall("{ call ADD_BOOKTYPE(?,?,?)}");
         cstmt.setString(1, btype.getBooktypename());
         cstmt.setDouble(2, btype.getCostperHour());
         cstmt.setString(3, btype.getBooktypedesc());
        
         
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
	


public boolean UpdateBookingType(BookTypeModel btype){
	
	
	CallableStatement cstmt=null;
	  try 
	    {
		  
	    	
        	
        	con=getConnection();		       
	        cstmt=con.prepareCall("{ call UPDATE_BOOKTYPE(?,?,?,?)}");
     cstmt.setInt(1, btype.getBooktypeid());
     cstmt.setDouble(2, btype.getCostperHour());
     cstmt.setString(3, btype.getBooktypedesc());
     cstmt.setString(4, btype.getBooktypestatus());
    
     
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






public CoreHash getAllBookingTypes(){
	CoreHash aCoreHash=new CoreHash();
	aCoreHash.clear();
	System.out.println("aCoreHash--"+aCoreHash.isEmpty());
	int sno=1;
	Statement cstmt;
	BookTypeModel bmodel=null;
	try {
		 con = getConnection();
		   
		
        	 cstmt=con.createStatement();
        	
        	 ResultSet rs=cstmt.executeQuery("select * from BookTypeMstr");
        	 while(rs.next())
             {
          	   bmodel=new BookTypeModel();
          	   System.out.println("In Booking DAo"+rs.getInt(1)+rs.getString(2));
          	 bmodel.setBooktypeid(rs.getInt(1));
          	 bmodel.setBooktypename(rs.getString(2));  
          	 bmodel.setCostperHour(rs.getDouble(3));   
          	 bmodel.setBooktypedesc(rs.getString(4));
          	 bmodel.setBooktypestatus(rs.getString(5));
          	
          	 aCoreHash.put(new Integer(sno),bmodel);
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



public CoreHash getEmptyBookingRoomTypes(){
	CoreHash aCoreHash=new CoreHash();
	aCoreHash.clear();
	System.out.println("aCoreHash--"+aCoreHash.isEmpty());
	int sno=1;
	Statement cstmt;
	BookTypeModel bmodel=null;
	try {
		 con = getConnection();
		   
		
        	 cstmt=con.createStatement();
        	String sql="select * from BookTypeMstr where upper(status) like upper('AVAILABLE')";
        	 ResultSet rs=cstmt.executeQuery(sql);
        	 while(rs.next())
             {
          	   bmodel=new BookTypeModel();
          	   System.out.println("In Booking DAo"+rs.getInt(1)+rs.getString(2));
          	 bmodel.setBooktypeid(rs.getInt(1));
          	 bmodel.setBooktypename(rs.getString(2));  
          	 bmodel.setCostperHour(rs.getDouble(3));   
          	 bmodel.setBooktypedesc(rs.getString(4));
          	 bmodel.setBooktypestatus(rs.getString(5));
          	
          	 aCoreHash.put(new Integer(sno),bmodel);
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

public BookTypeModel getBookingTypesDetails(int booktypeid){
	CoreHash aCoreHash=new CoreHash();
	aCoreHash.clear();
	System.out.println("aCoreHash--"+aCoreHash.isEmpty());
	int sno=1;
	Statement cstmt;
	BookTypeModel bmodel=null;
	try {
		 con = getConnection();
		   
		
        	 cstmt=con.createStatement();
        	String sql="select * from BookTypeMstr where booktypeid="+booktypeid;
        	 ResultSet rs=cstmt.executeQuery(sql);
        	 while(rs.next())
             {
          	   bmodel=new BookTypeModel();
          	   System.out.println("In Booking DAo"+rs.getInt(1)+rs.getString(2));
          	 bmodel.setBooktypeid(rs.getInt(1));
          	 bmodel.setBooktypename(rs.getString(2));  
          	 bmodel.setCostperHour(rs.getDouble(3));   
          	 bmodel.setBooktypedesc(rs.getString(4));
          	 bmodel.setBooktypestatus(rs.getString(5));
          	
          	 aCoreHash.put(new Integer(sno),bmodel);
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
	return bmodel;
}



public boolean CustOrderForBooking(BookTypeModel botype){
	
	
	CallableStatement cstmt=null;
	  try 
	    {
		  
	    	
        	
        	con=getConnection();		       
	        cstmt=con.prepareCall("{ call CUST_ODER_FOR_BOOKING(?,?,?,?,?,?,?,?,?,?,?,?)}");
     cstmt.setInt(1, botype.getBooktypeid());
     System.out.println("------botype.getBooktypeid()--------"+botype.getBooktypeid());
     cstmt.setInt(2, botype.getRoomtypeid());
     System.out.println("------botype.getRoomtypeid()---------"+botype.getRoomtypeid());
     cstmt.setInt(3, botype.getNoofroomsforbook());
     System.out.println("-----botype.getNoofroomsforbook()------------>"+botype.getNoofroomsforbook());
     cstmt.setInt(4, botype.getCustid());
     System.out.println("----botype.getCustid()------"+botype.getCustid());
     cstmt.setLong(5, botype.getCartid());
     System.out.println("-----botype.getCartid()-------"+botype.getCartid());
     cstmt.setString(6, DateWrapper.parseDate(botype.getRegdate()));
     System.out.println("------DateWrapper.parseDate(botype.getRegdate())--------->"+DateWrapper.parseDate(botype.getRegdate()));
     cstmt.setString(7, DateWrapper.parseDate(botype.getBookfrmdate()));
     System.out.println("--------DateWrapper.parseDate(botype.getBookfrmdate())------"+DateWrapper.parseDate(botype.getBookfrmdate()));
     
     cstmt.setString(8, botype.getBookfrmtime()); 
     System.out.println("----botype.getBookfrmtime()-----"+botype.getBookfrmtime());
     cstmt.setString(9, DateWrapper.parseDate(botype.getBooktodate())); 
     System.out.println("------DateWrapper.parseDate(botype.getBooktodate())-----------"+DateWrapper.parseDate(botype.getBooktodate()));
     cstmt.setString(10, botype.getBooktotime()); 
     System.out.println("-------botype.getBooktotime()-------"+botype.getBooktotime());
     cstmt.setDouble(11, botype.getTtbookamount());
     System.out.println("-----botype.getTtbookamount()-----"+botype.getTtbookamount());
     cstmt.registerOutParameter(12,Types.INTEGER);
    
     
	       int i= cstmt.executeUpdate();
	       
	       int s=cstmt.getInt(12);	
	       
	       System.out.println("-------s--------->"+s);
	         if(i==1 && s==0){       
	        	 
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




public CoreHash getCustBookingDetails(int custid){
	CoreHash aCoreHash=new CoreHash();
	aCoreHash.clear();
	System.out.println("aCoreHash--"+aCoreHash.isEmpty());
	int sno=1;
	Statement cstmt;
	BookTypeModel bmodel=null;
	try {
		 con = getConnection();
		   
		
        	 cstmt=con.createStatement();
        	String sql="SELECT  CBK.BOOKID, CBK.BOOKTYPEID, BTM.BOOKTYPENAME, CBK.ROOMTYPEID, RTM.ROOMTYPENAME, CBK.NOOFROMS4BOOK, CBK.CUSTID, CST.CFSTNAME, TO_CHAR(CBK.REGISTERDATE,'DD-MM-YY'), TO_CHAR(CBK.BKGFROMDATE,'DD-MM-YY'),  TO_CHAR(CBK.BKGTODATE,'DD-MM-YY'),  CBK.BKAMT ,CBK.STATUS FROM  CUSTBOOKINGDTLS CBK, ROOMTYPEMSTR RTM, BOOKTYPEMSTR BTM,  CUSTOMER CST WHERE  (CBK.CUSTID=CST.CUSTID)AND(CBK.BOOKTYPEID=BTM.BOOKTYPEID)AND(CBK.ROOMTYPEID=RTM.ROOMTYPEID)AND CBK.CUSTID="+custid;
        	 ResultSet rs=cstmt.executeQuery(sql);
        	 while(rs.next())
             {
          	   bmodel=new BookTypeModel();
          	   
          	 bmodel.setBookid(rs.getInt(1));
          	 bmodel.setBooktypeid(rs.getInt(2));          	   
          	 bmodel.setBooktypename(rs.getString(3));           	 
          	 bmodel.setRoomtypeid(rs.getInt(4));          	   
          	 bmodel.setRoomtypename(rs.getString(5));
          	 bmodel.setNoofroomsforbook(rs.getInt(6));          	
          	 bmodel.setCustid(rs.getInt(7));          	   
         	 bmodel.setCustname(rs.getString(8));
         	 bmodel.setRegdate(rs.getString(9));
         	 bmodel.setBookfrmdate(rs.getString(10)); 
         	 bmodel.setBooktodate(rs.getString(11));   	
          	 bmodel.setTtbookamount(rs.getDouble(12)); 
          	 bmodel.setBooktypestatus(rs.getString(13));          	 
          	
          	
          	 aCoreHash.put(new Integer(sno),bmodel);
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



public CoreHash getAllCustBookingDetails(){
	CoreHash aCoreHash=new CoreHash();
	aCoreHash.clear();
	System.out.println("aCoreHash--"+aCoreHash.isEmpty());
	int sno=1;
	Statement cstmt;
	BookTypeModel bmodel=null;
	try {
		 con = getConnection();
		   
		
        	 cstmt=con.createStatement();
        	String sql="SELECT  CBK.BOOKID, CBK.BOOKTYPEID, BTM.BOOKTYPENAME, CBK.ROOMTYPEID, RTM.ROOMTYPENAME, CBK.NOOFROMS4BOOK, CBK.CUSTID, CST.CFSTNAME, TO_CHAR(CBK.REGISTERDATE,'DD-MM-YY'), TO_CHAR(CBK.BKGFROMDATE,'DD-MM-YY'),  TO_CHAR(CBK.BKGTODATE,'DD-MM-YY'),  CBK.BKAMT ,CBK.STATUS FROM  CUSTBOOKINGDTLS CBK, ROOMTYPEMSTR RTM, BOOKTYPEMSTR BTM,  CUSTOMER CST WHERE  (CBK.CUSTID=CST.CUSTID)AND(CBK.BOOKTYPEID=BTM.BOOKTYPEID)AND(CBK.ROOMTYPEID=RTM.ROOMTYPEID) AND UPPER(CBK.STATUS) LIKE UPPER('Y')";
        	 ResultSet rs=cstmt.executeQuery(sql);
        	 while(rs.next())
             {
          	   bmodel=new BookTypeModel();
          	   
          	 bmodel.setBookid(rs.getInt(1));
          	 bmodel.setBooktypeid(rs.getInt(2));          	   
          	 bmodel.setBooktypename(rs.getString(3));           	 
          	 bmodel.setRoomtypeid(rs.getInt(4));          	   
          	 bmodel.setRoomtypename(rs.getString(5));
          	 bmodel.setNoofroomsforbook(rs.getInt(6));          	
          	 bmodel.setCustid(rs.getInt(7));          	   
         	 bmodel.setCustname(rs.getString(8));
         	 bmodel.setRegdate(rs.getString(9));
         	 bmodel.setBookfrmdate(rs.getString(10)); 
         	 bmodel.setBooktodate(rs.getString(11));   	
          	 bmodel.setTtbookamount(rs.getDouble(12)); 
          	 bmodel.setBooktypestatus(rs.getString(13));          	 
          	
          	
          	 aCoreHash.put(new Integer(sno),bmodel);
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
	
}
