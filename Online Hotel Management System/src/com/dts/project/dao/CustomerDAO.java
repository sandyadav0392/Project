package com.dts.project.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
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
import com.dts.project.model.CustomerModel;




public class CustomerDAO extends AbstractDataAccessObject {
	public boolean flag=false;
	public Connection con=null;
	
	public CustomerDAO() {
		// TODO Auto-generated constructor stub
	}

	
	
public CustomerModel addCustomerProfile(CustomerModel addcust){
		
		//String photo=addcust.getCustphoto();
	CustomerModel  cm=null;
		CallableStatement cstmt=null;
		  try 
		    {
			  //System.out.println("photo="+photo);
	        	//java.io.File f=new File(photo);
	        	//FileInputStream fis=new FileInputStream(f); 
		    	
	        	
	        	con=getConnection();		       
		        cstmt=con.prepareCall("{ call ADD_CUSTOMER(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
         cstmt.setString(1, addcust.getCustfname());
         cstmt.setString(2, addcust.getCustmname());
         cstmt.setString(3, addcust.getCustlname());
         cstmt.setString(4, DateWrapper.parseDate(addcust.getDob()));
         cstmt.setString(5, DateWrapper.parseDate(addcust.getDoj()));         
         cstmt.setString(6, addcust.getCusthno());
         cstmt.setString(7, addcust.getStreet());
         cstmt.setString(8, addcust.getCity());
         cstmt.setString(9, addcust.getState());
         cstmt.setString(10, addcust.getCountry());
         cstmt.setString(11, addcust.getPhno());
         cstmt.setString(12, addcust.getEmailid());       
         cstmt.setString(13, addcust.getCustpin());
         cstmt.registerOutParameter(14,Types.VARCHAR);
         cstmt.registerOutParameter(15,Types.VARCHAR);
         
		       int i= cstmt.executeUpdate();
		         if(i==1)
		         {
		          flag=true;
		          con.commit();
		          cm=new CustomerModel();
		           
		             cm.setCustuname(cstmt.getString(14));
		             cm.setCustpass(cstmt.getString(15));  
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
		    return cm;
		
	}
	




public boolean UpdateCustomerProfile(CustomerModel updatecust){
	
	//String photo=updatecust.getCustphoto();
	
	CallableStatement cstmt=null;
	  try 
	    {
		 // System.out.println("photo="+photo);
        	//java.io.File f=new File(photo);
        	//FileInputStream fis=new FileInputStream(f); 
	    	
        	
        	con=getConnection();		       
	        cstmt=con.prepareCall("{ call UPDATE_CUSTOMER(?,?,?,?,?,?,?,?,?,?,?)}");
     
	 cstmt.setInt(1, updatecust.getCustid());	           
     cstmt.setString(2, DateWrapper.parseDate(updatecust.getDob()));
     cstmt.setString(3, DateWrapper.parseDate(updatecust.getDoj()));         
     cstmt.setString(4, updatecust.getCusthno());
     cstmt.setString(5, updatecust.getStreet());
     cstmt.setString(6, updatecust.getCity());
     cstmt.setString(7, updatecust.getState());
     cstmt.setString(8, updatecust.getCountry());
     cstmt.setString(9, updatecust.getPhno());
     cstmt.setString(10, updatecust.getEmailid());   
     cstmt.setString(11, updatecust.getCustpin());
    // cstmt.setBinaryStream(12,fis,(int)f.length());
   
     
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







public CoreHash getAllCustProfile(String image){
	
	CoreHash aCoreHash=new CoreHash();
	aCoreHash.clear();
	System.out.println("aCoreHash--"+aCoreHash.isEmpty());
	
	
	int sno=1;
	
	ResultSet rs=null;
	CustomerModel um=null;
	Statement st=null;
        try
        {
        	con=getConnection();     	
        	st=con.createStatement();
       	String sql="SELECT CUSTID,CFSTNAME,TO_CHAR(CDOB,'DD-MM-YYYY'),TO_CHAR(CDOJ,'DD-MM-YYYY'),CHNO,CSTREET,CCITY,CSTATE,CCOUNTRY,CPHNO,CEMAILID,CPIN,LOGINTYPE,PHOTO from CUSTOMER";
			
			rs=st.executeQuery(sql);
			while(rs.next()){
				
			um=new CustomerModel();		
			
			int cid=rs.getInt(1);
			
			um.setCustid(cid);
			um.setCustfname(rs.getString(2));
			
			um.setDob(rs.getString(3));
			um.setDoj(rs.getString(4));
			um.setCusthno(rs.getString(5));
			um.setStreet(rs.getString(6));
			um.setCity(rs.getString(7));
			um.setState(rs.getString(8));
			um.setCountry(rs.getString(9));
			um.setPhno(rs.getString(10));
			um.setEmailid(rs.getString(11));			
			
			um.setCustpin(rs.getString(12));
			um.setLogintype(rs.getString(13));
			
			
			
			Blob bb =rs.getBlob(14);
			byte bb1[]=bb.getBytes(1,(int)bb.length());
			OutputStream fout1=new FileOutputStream(image+"/"+cid+".gif");
			fout1.write(bb1);			
			um.setCustphoto(cid+".gif");
			
			
			
			 aCoreHash.put(new Integer(sno),um);
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
	





public CustomerModel getPerticularCustProfile(String image,int cstid){
	
	CoreHash aCoreHash=new CoreHash();
	aCoreHash.clear();
	System.out.println("aCoreHash--"+aCoreHash.isEmpty());
	
	
	int sno=1;
	
	ResultSet rs=null;
	CustomerModel um=null;
	Statement st=null;
        try
        {
        	con=getConnection();     	
        	st=con.createStatement();
       	String sql="SELECT CUSTID,CFSTNAME,TO_CHAR(CDOB,'DD-MM-YYYY'),TO_CHAR(CDOJ,'DD-MM-YYYY'),CHNO,CSTREET,CCITY,CSTATE,CCOUNTRY,CPHNO,CEMAILID,CPIN,LOGINTYPE,PHOTO from CUSTOMER where CUSTID="+cstid;
			
			rs=st.executeQuery(sql);
			while(rs.next()){
				
			um=new CustomerModel();		
			
			int cid=rs.getInt(1);
			
			um.setCustid(cid);
			um.setCustfname(rs.getString(2));
			//um.setCustmname(rs.getString(3));
			//um.setCustlname(rs.getString(4));
			um.setDob(rs.getString(3));
			um.setDoj(rs.getString(4));
			um.setCusthno(rs.getString(5));
			um.setStreet(rs.getString(6));
			um.setCity(rs.getString(7));
			um.setState(rs.getString(8));
			um.setCountry(rs.getString(9));
			um.setPhno(rs.getString(10));
			um.setEmailid(rs.getString(11));			
			//um.setCustuname(rs.getString(14));
			//um.setCustpass(rs.getString(15));
			um.setCustpin(rs.getString(12));
			um.setLogintype(rs.getString(13));
			
			
			
			Blob bb =rs.getBlob(14);
			byte bb1[]=bb.getBytes(1,(int)bb.length());
			OutputStream fout1=new FileOutputStream(image+"/"+cid+".gif");
			fout1.write(bb1);			
			um.setCustphoto(cid+".gif");
			
			
			
		  
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
	return um;
}
	


public CustomerModel getCustProfile(String username){
	
	int sno=1;
	
	ResultSet rs=null;
	CustomerModel um=null;
	Statement st=null;
        try
        {
        	con=getConnection();  
        	
        	System.out.println("----getConnection-------"+con);
        	st=con.createStatement();
       	String sql="SELECT CUSTID,CFSTNAME,CMIDNAME,CLSTNAME,TO_CHAR(CDOB,'DD-MM-YYYY'),TO_CHAR(CDOJ,'DD-MM-YYYY'),CHNO,CSTREET,CCITY,CSTATE,CCOUNTRY,CPHNO,CEMAILID,CUSERNAME,CPASSWORD,CPIN,LOGINTYPE FROM CUSTOMER WHERE CUSERNAME='"+username+"'";
			
			rs=st.executeQuery(sql);
			while(rs.next()){
				
			um=new CustomerModel();		
			
			int cid=rs.getInt(1);
			System.out.println("----cid----------------->"+cid);
			um.setCustid(cid);
			
			
			um.setCustfname(rs.getString(2));
			um.setCustmname(rs.getString(3));
			um.setCustlname(rs.getString(4));
			um.setDob(rs.getString(5));
			um.setDoj(rs.getString(6));
			um.setCusthno(rs.getString(7));
			um.setStreet(rs.getString(8));
			um.setCity(rs.getString(9));
			um.setState(rs.getString(10));
			um.setCountry(rs.getString(11));
			um.setPhno(rs.getString(12));
			um.setEmailid(rs.getString(13));			
			um.setCustuname(rs.getString(14));
			um.setCustpass(rs.getString(15));
			um.setCustpin(rs.getString(16));
			um.setLogintype(rs.getString(17));
			
			
			
			//Blob bb =rs.getBlob(18);
			//byte bb1[]=bb.getBytes(1,(int)bb.length());
			//OutputStream fout1=new FileOutputStream(image+"/"+cid+".gif");
			//fout1.write(bb1);			
			//um.setCustphoto(cid+".gif");
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
	return um;
}




}
