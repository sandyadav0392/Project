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
import com.dts.project.model.HotelModel;
import com.dts.project.model.SupplierModel;


public class HotelDAO extends AbstractDataAccessObject {

	public HotelDAO() {
		// TODO Auto-generated constructor stub
	}
	public boolean flag=false;
	public Connection con=null;
	
	public boolean addHotel(HotelModel addhotel){
		
		 CallableStatement cstmt=null;
		  try 
		    {
			 
		    	con=getConnection();		       
		        cstmt=con.prepareCall("{ call ADD_HOTEL(?,?,?,?,?,?,?,?,?,?) }");
          cstmt.setString(1, addhotel.getHotelname());
          cstmt.setString(2, addhotel.getHotelpltno());
          cstmt.setString(3, addhotel.getHtlstreet());
          cstmt.setString(4, addhotel.getHotelcity());
          cstmt.setString(5, addhotel.getHotelstate());
          cstmt.setString(6, addhotel.getHotelpin());
          cstmt.setString(7, DateWrapper.parseDate(addhotel.getHotelstdate()));
          cstmt.setDouble(8, addhotel.getInchrgid());
          cstmt.setString(9, addhotel.getHotelmailid());
          cstmt.setString(10, addhotel.getContactno());
          
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
	
	
	public boolean UpdateHotelDetails(HotelModel addhotel){
		
		 CallableStatement cstmt=null;
		  try 
		    {
			 
		    	con=getConnection();		       
		        cstmt=con.prepareCall("{ call UPDATE_HOTEL(?,?,?,?,?,?,?,?,?,?) }");
         
		        cstmt.setInt(1, addhotel.getHotelid());
         cstmt.setString(2, addhotel.getHotelpltno());
         cstmt.setString(3, addhotel.getHtlstreet());
         cstmt.setString(4, addhotel.getHotelcity());
         cstmt.setString(5, addhotel.getHotelstate());
         cstmt.setString(6, addhotel.getHotelpin());
         cstmt.setString(7, DateWrapper.parseDate(addhotel.getHotelstdate()));
         cstmt.setInt(8, addhotel.getInchrgid());
         cstmt.setString(9, addhotel.getHotelmailid());
         cstmt.setString(10, addhotel.getContactno());
         
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
	
	
	
	
	
	

	
	

	
	 public CoreHash getHotelNames(){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			HotelModel hmodel=null;
			try {
				 con = getConnection();
				   
				
	            	 cstmt=con.createStatement();
	            	
	            	 ResultSet rs=cstmt.executeQuery("select hotelid,hotelNAME from HotelMaster");
	            	 while(rs.next())
	                 {
	              	   hmodel=new HotelModel();
	              	   System.out.println("In Hotel DAo"+rs.getInt(1)+rs.getString(2));
	              	 hmodel.setHotelid(rs.getInt(1));
	              	hmodel.setHotelname(rs.getString(2));  
	              	   
	               	   
	              	 aCoreHash.put(new Integer(sno),hmodel);
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
	 
	 
	 
	 public CoreHash getAllHotelDetails(){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			HotelModel hmodel=null;
			try {
				 con = getConnection();				   
				
	            	 cstmt=con.createStatement();
	            	
	            	 ResultSet rs=cstmt.executeQuery("SELECT HM.HOTELID, HM.HOTELNAME, HM.HPLOTNO, HM.HSTREET, HM.HCITY, HM.HSTATE, HM.HPIN, TO_CHAR(HM.HSTDATE,'DD-MM-YY'), HM.HINCHRGID, EM.EMPFSTNAME ,hm.HOTELMAILID,hm.HOTELCONTACTNO FROM HOTELMASTER HM,EMPLOYEESMASTER EM WHERE(HM.HINCHRGID=EM.EMPID)");
	            	 while(rs.next())
	                 {
	              	   hmodel=new HotelModel();
	              	System.out.println("In Hotel DAo"+rs.getInt(1)+rs.getString(2));
	              	hmodel.setHotelid(rs.getInt(1));
	              	hmodel.setHotelname(rs.getString(2)); 
	              	hmodel.setHotelpltno(rs.getString(3)); 
	              	hmodel.setHtlstreet(rs.getString(4)); 
	              	hmodel.setHotelcity(rs.getString(5)); 
	              	hmodel.setHotelstate(rs.getString(6)); 
	              	hmodel.setHotelpin(rs.getString(7));        	
	              	hmodel.setHotelstdate(rs.getString(8)); 
	              	hmodel.setInchrgid(rs.getInt(9)); 
	              	hmodel.setInchrgname(rs.getString(10)); 
	              	hmodel.setHotelmailid(rs.getString(11));
	              	hmodel.setContactno(rs.getString(12));
	               	   
	              	 aCoreHash.put(new Integer(sno),hmodel);
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
	 
	 
	 
	 public HotelModel getEachHotelDetails(int hid){
	    	//CoreHash aCoreHash=new CoreHash();
	    	//aCoreHash.clear();
			//System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			HotelModel hmodel=null;
			try {
				 con = getConnection();
				   
				
	            	 cstmt=con.createStatement();
	            	String sql="SELECT HM.HOTELID, HM.HOTELNAME, HM.HPLOTNO, HM.HSTREET, HM.HCITY, HM.HSTATE, HM.HPIN, TO_CHAR(HM.HSTDATE,'DD-MM-YYYY'), HM.HINCHRGID, EM.EMPFSTNAME,hm.HOTELMAILID,hm.HOTELCONTACTNO FROM HOTELMASTER HM,EMPLOYEESMASTER EM WHERE(HM.HINCHRGID=EM.EMPID) AND HM.HOTELID="+hid;
	            	 ResultSet rs=cstmt.executeQuery(sql);
	            	 while(rs.next())
	                 {
	              	   hmodel=new HotelModel();
	              	   System.out.println("In Hotel DAo"+rs.getInt(1)+rs.getString(2));
	              	 hmodel.setHotelid(rs.getInt(1));
	              	hmodel.setHotelname(rs.getString(2)); 
	              	hmodel.setHotelpltno(rs.getString(3)); 
	              	hmodel.setHtlstreet(rs.getString(4)); 
	              	hmodel.setHotelcity(rs.getString(5)); 
	              	hmodel.setHotelstate(rs.getString(6)); 
	              	hmodel.setHotelpin(rs.getString(7));        	
	              	hmodel.setHotelstdate(rs.getString(8)); 
	              	hmodel.setInchrgid(rs.getInt(9)); 
	              	hmodel.setInchrgname(rs.getString(10)); 
	              	hmodel.setHotelmailid(rs.getString(11));
	              	hmodel.setContactno(rs.getString(12));
	              	   
	               	   
	             // 	 aCoreHash.put(new Integer(sno),hmodel);
	 			 //   sno++;
	 		  
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
			return hmodel;
	    }
	 
	 
	 public CoreHash getSuppliersNames(){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			SupplierModel hmodel=null;
			try {
				 con = getConnection();
				   
				
	            	 cstmt=con.createStatement();
	            	
	            	 ResultSet rs=cstmt.executeQuery("select supplierid,sfstname from SupplierMaster");
	            	 while(rs.next())
	                 {
	              	   hmodel=new SupplierModel();
	              	   System.out.println("In Hotel DAo"+rs.getInt(1)+rs.getString(2));
	              	 hmodel.setSplid(rs.getInt(1));
	              	hmodel.setSfstname(rs.getString(2));  
	              	   
	               	   
	              	 aCoreHash.put(new Integer(sno),hmodel);
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
	
	 
	 
	 public CoreHash getTendersNames(){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			HotelModel hmodel=null;
			try {
				 con = getConnection();
				   
				
	            	 cstmt=con.createStatement();
	            	
	            	 ResultSet rs=cstmt.executeQuery("select tenderid,tenderto from tender");
	            	 while(rs.next())
	                 {
	              	   hmodel=new HotelModel();
	              	   System.out.println("In Tender DAo"+rs.getInt(1)+rs.getString(2));
	              	 hmodel.setTenderid(rs.getInt(1));
	              	hmodel.setTenderto(rs.getString(2));  
	              	   
	               	   
	              	 aCoreHash.put(new Integer(sno),hmodel);
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
