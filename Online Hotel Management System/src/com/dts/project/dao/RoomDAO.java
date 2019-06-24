package com.dts.project.dao;

import java.io.File;
import java.io.FileInputStream;
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
import com.dts.project.model.RoomTypeModel;

public class RoomDAO extends AbstractDataAccessObject {

	
	
	public boolean flag=false;
	public Connection con=null;
	
	public boolean AddRoomTypes(RoomTypeModel rmodel){
		
		
		
		CallableStatement cstmt=null;
		  try 
		    {
			 
	        	
	        	con=getConnection();		       
		        cstmt=con.prepareCall("{ call ADD_ROOMTYPE(?,?,?,?,?,?)}");
	     
		 cstmt.setString(1, rmodel.getRoomtypename());	
		 cstmt.setDouble(2, rmodel.getCost4room()); 
		 cstmt.setInt(3, rmodel.getNoofroom());	
		 cstmt.setInt(4, rmodel.getHotelid());	
		 cstmt.setInt(5, rmodel.getFacilityid());		 
	     cstmt.setString(6, rmodel.getRoomdesc());
	      
	    
		       int i=cstmt.executeUpdate();
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
	
	
	
	
public boolean UpdateRoomTypes(RoomTypeModel rmodel){
		
		
		
		CallableStatement cstmt=null;
		  try 
		    {
			 
	        	
	        	con=getConnection();		       
		        cstmt=con.prepareCall("{ call UPDATE_ROOMTYPE(?,?,?,?,?,?,?)}");
	     
		 cstmt.setInt(1, rmodel.getRoomtypeid());	
		 cstmt.setDouble(2, rmodel.getCost4room()); 
		 cstmt.setInt(3, rmodel.getNoofroom());	
		 cstmt.setInt(4, rmodel.getHotelid());	
		 cstmt.setInt(5, rmodel.getFacilityid());		 
	     cstmt.setString(6, rmodel.getRoomdesc());
	     cstmt.setString(7, rmodel.getRoomstatus());
	      
	    
		       int i=cstmt.executeUpdate();
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
	

	public CoreHash getAllRoomTypesDetails(){
    	CoreHash aCoreHash=new CoreHash();
    	aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement cstmt;
		RoomTypeModel hmodel=null;
		try {
			 con = getConnection();				   
			
            	 cstmt=con.createStatement();
            	String sql="SELECT RTM.ROOMTYPEID, RTM.ROOMTYPENAME, RTM.COST4ROOM, RTM.NOOFROOMS, RTM.HOTELID, HM.HOTELNAME, RTM.FACILTYID, FM.FACILITYNAME, RTM.ROOMDESC, RTM.ROOMSTATUS FROM ROOMTYPEMSTR RTM,HOTELMASTER HM,FACILTYMASTER FM WHERE (RTM.HOTELID=HM.HOTELID)AND(RTM.FACILTYID=FM.FACILTYID)";
            	 ResultSet rs=cstmt.executeQuery(sql);
            	 while(rs.next())
                 {
              	   hmodel=new RoomTypeModel();
              	//System.out.println("In Hotel DAo"+rs.getInt(1)+rs.getString(2));
              	hmodel.setRoomtypeid(rs.getInt(1));
              	hmodel.setRoomtypename(rs.getString(2)); 
              	hmodel.setCost4room(rs.getDouble(3)); 
              	hmodel.setNoofroom(rs.getInt(4));              	
              	hmodel.setHotelid(rs.getInt(5)); 
              	hmodel.setHotelname(rs.getString(6));
              	hmodel.setFacilityid(rs.getInt(7)); 
              	hmodel.setFacilityname(rs.getString(8));
              	hmodel.setRoomdesc(rs.getString(9));        	
              	hmodel.setRoomstatus(rs.getString(10)); 
              	
               	   
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
 
	
	
	public RoomTypeModel getPertRoomTypesDetails(int roomtypeid){
    	CoreHash aCoreHash=new CoreHash();
    	aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement cstmt;
		RoomTypeModel hmodel=null;
		try {
			 con = getConnection();				   
			
            	 cstmt=con.createStatement();
            	String sql="SELECT RTM.ROOMTYPEID, RTM.ROOMTYPENAME, RTM.COST4ROOM, RTM.NOOFROOMS, RTM.HOTELID, HM.HOTELNAME, RTM.FACILTYID, FM.FACILITYNAME, RTM.ROOMDESC, RTM.ROOMSTATUS FROM ROOMTYPEMSTR RTM,HOTELMASTER HM,FACILTYMASTER FM WHERE (RTM.HOTELID=HM.HOTELID)AND(RTM.FACILTYID=FM.FACILTYID) AND RTM.ROOMTYPEID="+roomtypeid;
            	 ResultSet rs=cstmt.executeQuery(sql);
            	 while(rs.next())
                 {
              	   hmodel=new RoomTypeModel();              	
              	hmodel.setRoomtypeid(rs.getInt(1));
              	hmodel.setRoomtypename(rs.getString(2)); 
              	hmodel.setCost4room(rs.getDouble(3)); 
              	hmodel.setNoofroom(rs.getInt(4));              	
              	hmodel.setHotelid(rs.getInt(5)); 
              	hmodel.setHotelname(rs.getString(6));
              	hmodel.setFacilityid(rs.getInt(7)); 
              	hmodel.setFacilityname(rs.getString(8));
              	hmodel.setRoomdesc(rs.getString(9));        	
              	hmodel.setRoomstatus(rs.getString(10)); 
              	
               	   
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
		return hmodel;
    }
 

	
	
	public RoomTypeModel getAvailNoOfRoomDetails(int roomtypeid){
    	//CoreHash aCoreHash=new CoreHash();
    	//aCoreHash.clear();
		//System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		//int sno=1;
		Statement cstmt;
		RoomTypeModel hmodel=null;
		try {
			 con = getConnection();				   
			
            	 cstmt=con.createStatement();
            	//String sql="SELECT RTM.ROOMTYPEID, RTM.ROOMTYPENAME, RTM.COST4ROOM, RTM.NOOFROOMS, RTM.HOTELID, HM.HOTELNAME, RTM.FACILTYID, FM.FACILITYNAME, RTM.ROOMDESC, RTM.ROOMSTATUS FROM ROOMTYPEMSTR RTM,HOTELMASTER HM,FACILTYMASTER FM WHERE (RTM.HOTELID=HM.HOTELID)AND(RTM.FACILTYID=FM.FACILTYID) AND RTM.ROOMTYPEID="+roomtypeid;
            	 String sql="SELECT RTM.ROOMTYPEID, RTM.ROOMTYPENAME, RTM.COST4ROOM, RTM.NOOFROOMS  FROM ROOMTYPEMSTR RTM,HOTELMASTER HM,FACILTYMASTER FM WHERE (RTM.HOTELID=HM.HOTELID)AND(RTM.FACILTYID=FM.FACILTYID) AND RTM.ROOMTYPEID="+roomtypeid;
            	 
            	 ResultSet rs=cstmt.executeQuery(sql);
            	 while(rs.next())
                 {
              	   hmodel=new RoomTypeModel();              	
              	hmodel.setRoomtypeid(rs.getInt(1));
              	hmodel.setRoomtypename(rs.getString(2)); 
              	hmodel.setCost4room(rs.getDouble(3)); 
              	hmodel.setNoofroom(rs.getInt(4));              	
              	//hmodel.setHotelid(rs.getInt(5)); 
              	//hmodel.setHotelname(rs.getString(6));
              	//hmodel.setFacilityid(rs.getInt(7)); 
              	//hmodel.setFacilityname(rs.getString(8));
              	//hmodel.setRoomdesc(rs.getString(9));        	
              	//hmodel.setRoomstatus(rs.getString(10)); 
              	
               	   
              	// aCoreHash.put(new Integer(sno),hmodel);
 			   // sno++;
 		  
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
}
