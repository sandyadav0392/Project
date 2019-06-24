package com.dts.project.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.project.model.CustomerModel;
import com.dts.project.model.FacilityModel;
import com.dts.project.model.HotelModel;

public class FacilityDAO extends AbstractDataAccessObject {
	public boolean flag=false;
	public Connection con=null;
	////////-----------------rakesh
	
	public boolean addfacilityRakesh(FacilityModel fmodel){
		
		String photo=fmodel.getFacildtls();
		PreparedStatement pst=null;
		
		
		try {
			java.io.File f=new File(photo);
        	FileInputStream fis=new FileInputStream(f); 
        	con=getConnection();
        	pst=con.prepareStatement("insert into FACILTYMASTER values((select nvl(max(FACILTYID),0)+1 from FACILTYMASTER),?,?,?,?,?,?)");
        	pst.setBinaryStream(1,fis,(int)f.length());
        	
        	
    		
        	 
    	     pst.setString(2, DateWrapper.parseDate(fmodel.getStdate()));
    	     pst.setString(3, DateWrapper.parseDate(fmodel.getStdate()));
    	     
    	     pst.setDouble(4, fmodel.getAditionalchrg());        
    	    // pst.setInt(6, fmodel.getHotelid());
    	     pst.setString(5, fmodel.getFacilname());	
    	    //pst.setString(6, fmodel.getHotelname());
    	     pst.setString(6, "ACTIVE");
    	    // pst.setString(7, "ACTIVE");
    	     int i=pst.executeUpdate();
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

	    
			
		}  catch (Exception e) 
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
	
	
	///-------------------------rakesh
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean AddFacility(FacilityModel fmodel){
		
		String photo=fmodel.getFacildtls();
		
		CallableStatement cstmt=null;
		  try 
		    {
			 System.out.println("photo="+photo);
	        	java.io.File f=new File(photo);
	        	FileInputStream fis=new FileInputStream(f); 
		    	
	        	
	        	con=getConnection();		       
		        cstmt=con.prepareCall("{ call ADD_FACIL(?,?,?,?,?)}");
	     
		 cstmt.setString(1, fmodel.getFacilname());	
		 cstmt.setBinaryStream(2,fis,(int)f.length());
	     cstmt.setString(3, DateWrapper.parseDate(fmodel.getStdate()));
	     cstmt.setDouble(4, fmodel.getAditionalchrg());        
	     cstmt.setInt(5, fmodel.getHotelid());	     
	    
	   
	     
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

	
	
	
public boolean UpdateFacilityDetails(FacilityModel fmodel){
		
		String photo=fmodel.getFacildtls();
		
		CallableStatement cstmt=null;
		  try 
		    {
			 System.out.println("photo="+photo);
	        	java.io.File f=new File(photo);
	        	FileInputStream fis=new FileInputStream(f); 
		    	
	        	
	        	con=getConnection();		       
		        cstmt=con.prepareCall("{ call UPDATE_FACIL_DTLS(?,?,?,?)}");
	     
		 cstmt.setInt(1, fmodel.getFacilid());	
		 cstmt.setBinaryStream(2,fis,(int)f.length());
	     cstmt.setString(3, DateWrapper.parseDate(fmodel.getStdate()));
	     cstmt.setDouble(4, fmodel.getAditionalchrg());        
	    // cstmt.setString(5, fmodel.getFacilstatus());	     
	    
	   
	     
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
	
public boolean DeleteFacilityDetails(FacilityModel fmodel){
	
	
	
	CallableStatement cstmt=null;
	  try 
	    {
		 
        	
        	con=getConnection();		       
	        cstmt=con.prepareCall("{ call DELETE_FACIL_DTLS(?)}");
     
	 cstmt.setInt(1, fmodel.getFacilid());	
	 
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
	
	 public CoreHash getFacilityTypes(){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			FacilityModel fmodel=null;
			try {
				 con = getConnection();
				   
				
	            	 cstmt=con.createStatement();
	            	
	            	 ResultSet rs=cstmt.executeQuery("select FACILTYID,Initcap(FACILITYNAME) from FACILTYMASTER WHERE UPPER(FACILITYSTATUS) LIKE UPPER('ACTIVE')");
	            	 while(rs.next())
	                 {
	              	   fmodel=new FacilityModel();
	              	   System.out.println("In Hotel DAo"+rs.getInt(1)+rs.getString(2));
	              	 fmodel.setFacilid(rs.getInt(1));
	              	fmodel.setFacilname(rs.getString(2));  
	              	   
	               	   
	              	 aCoreHash.put(new Integer(sno),fmodel);
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
	 
	 
	 public CoreHash getAllFacilityDetails(String docu){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			FacilityModel fmodel=null;
			try {
				 con = getConnection();
				   
				
	            	 cstmt=con.createStatement();
	            	
	            	 ResultSet rs=cstmt.executeQuery("select FACILTYID,FACILDTLS,TO_CHAR(STDATE,'DD-MM-YY'),ADITIONALCHARG,FACILITYNAME,FACILITYSTATUS from FACILTYMASTER  WHERE UPPER(FACILITYSTATUS) LIKE UPPER('ACTIVE')");
	            	 while(rs.next())
	                 {
	              	   fmodel=new FacilityModel();
	              	   System.out.println("In Hotel DAo"+rs.getInt(1)+rs.getString(2));
	              	
	              	   int fid=rs.getInt(1);
	              	   fmodel.setFacilid(fid);
	              	 
	              	Blob bb =rs.getBlob(2);
	    			byte bb1[]=bb.getBytes(1,(int)bb.length());
	    			OutputStream fout1=new FileOutputStream(docu+"/"+fid+".doc");
	    			fout1.write(bb1);			
	    			fmodel.setFacildtls(fid+".doc"); 
	    			
	    			
	              	fmodel.setStdate(rs.getString(3));  
	              //	fmodel.setEnddate(rs.getString(4));  
	              	fmodel.setAditionalchrg(rs.getDouble(4));  
	              	fmodel.setFacilname(rs.getString(5)); 
	              	fmodel.setFacilstatus(rs.getString(6));	              	
	               	   
	              	 aCoreHash.put(new Integer(sno),fmodel);
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
	
	 
	 
	 
	 public FacilityModel getPerFacilityDetails(String docu,int fcilid){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			FacilityModel fmodel=null;
			try {
				 con = getConnection();
				   
				
	            	 cstmt=con.createStatement();
	            	
	            	 ResultSet rs=cstmt.executeQuery("select FACILTYID,FACILDTLS,TO_CHAR(STDATE,'DD-MM-YY'),ADITIONALCHARG,FACILITYNAME,FACILITYSTATUS from FACILTYMASTER WHERE UPPER(FACILITYSTATUS) LIKE UPPER('ACTIVE') AND FACILTYID="+fcilid);
	            	 while(rs.next())
	                 {
	              	   fmodel=new FacilityModel();
	              	   System.out.println("In Hotel DAo"+rs.getInt(1)+rs.getString(2));
	              	
	              	   int fid=rs.getInt(1);
	              	   fmodel.setFacilid(fid);
	              	 
	              	Blob bb =rs.getBlob(2);
	    			byte bb1[]=bb.getBytes(1,(int)bb.length());
	    			OutputStream fout1=new FileOutputStream(docu+"/"+fid+".doc");
	    			fout1.write(bb1);			
	    			fmodel.setFacildtls(fid+".doc"); 
	    			
	    			
	              	fmodel.setStdate(rs.getString(3));  
	             
	              	fmodel.setAditionalchrg(rs.getDouble(4));  
	              	fmodel.setFacilname(rs.getString(5)); 
	              	fmodel.setFacilstatus(rs.getString(6));	              	
	               	   
	              	 aCoreHash.put(new Integer(sno),fmodel);
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
			return fmodel;
	    }
}
