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
import java.sql.Types;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;
import com.dts.dae.model.Profile;
import com.dts.project.model.EmpModel;


public class EmpRegistrationDAO extends AbstractDataAccessObject {
	
	public Connection con=null;

    private boolean flag;
	public  EmpRegistrationDAO(){}
	
	public boolean addemp(EmpModel emodel){
		
		
		String photo=emodel.getPhoto();
		
		 CallableStatement cstmt=null;
	        try 
	        {
	        	System.out.println("photo="+photo);
	        	File f=new File(photo);
	        	FileInputStream fis=new FileInputStream(f); 
	        	int mgid=0;
	        	con=getConnection();
	           con.setAutoCommit(false);
	         cstmt= con.prepareCall(" { call ADD_EMP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	          
	           
	           cstmt.setString(1,emodel.getFirstname());
	           System.out.println("----emodel.getFirstname()-----"+emodel.getFirstname());
	           cstmt.setString(2,emodel.getLastname());
	           System.out.println("----emodel.getLastname()------"+emodel.getLastname());	           
	           cstmt.setString(3,emodel.getMiddlename());
	           System.out.println("-------emodel.getMiddlename()------"+emodel.getMiddlename());	           
	           cstmt.setString(4,DateWrapper.parseDate(emodel.getDob()));
	           System.out.println("-------DateWrapper.parseDate(emodel.getDob())------"+DateWrapper.parseDate(emodel.getDob()));
	           cstmt.setString(5,DateWrapper.parseDate(emodel.getDoj()));
	           System.out.println("-------emodel.getDoj()----"+emodel.getDoj());
	           
	           cstmt.setString(6,emodel.getAddress());
	           cstmt.setDouble(7,emodel.getSal());	           
	           cstmt.setInt(8,emodel.getQualid());          
	           cstmt.setInt(9,emodel.getDeptid());
	           cstmt.setInt(10,emodel.getDesgid());	           
	           cstmt.setString(11,emodel.getGender());
	           cstmt.setString(12,emodel.getMstatus()); 
	           cstmt.setBinaryStream(13,fis,(int)f.length());
               cstmt.setInt(14,emodel.getEmpid());
              //cstmt.setInt(14,mgid);
               System.out.println("---mgid--"+mgid);
	           cstmt.setInt(15,emodel.getQuestionid());
	           System.out.println("---emodel.getQuestionid()--"+emodel.getQuestionid());
	           cstmt.setString(16,emodel.getAnswer());	
	           System.out.println("-------emodel.getAnswer()-----"+emodel.getAnswer());
	           cstmt.setString(17,emodel.getEmailid());
	           System.out.println("-----emodel.getEmailid()-------"+emodel.getEmailid());
	           cstmt.setString(18,emodel.getPhno());
	           System.out.println("-----emodel.getPhno()----"+emodel.getPhno());
	           cstmt.setInt(19,emodel.getPerformrank());
	           System.out.println("-----emodel.getPerformrank()------"+emodel.getPerformrank()); 
	            
	            int i= cstmt.executeUpdate();
	            System.out.println("---i-----"+i);
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
		    catch(SQLException e)
			{
			System.out.println(e.toString());
			if(e.toString().equalsIgnoreCase("java.sql.SQLException: [Microsoft][ODBC driver for Oracle][Oracle]ORA-12571: TNS:packet writer failure"))
				{
				flag=true;
				System.out.println("n==="+flag);
				}
		System.out.println(e);

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
		    finally{
		    	
		    	try 
		        {
		    		if(con!=null)
		            con.close();
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
		    	
		    }
		    
		
	 return flag; 	
	}
	
	
	
	
public boolean UpdateEmpProfileDetails(EmpModel emodel){
		
		
		//String photo=emodel.getPhoto();
		
	CallableStatement cstmt=null;
	        try 
	        {
	        	//System.out.println("photo="+photo);
	        	//File f=new File(photo);
	        	//FileInputStream fis=new FileInputStream(f); 
	        	int mgid=0;
	        	con=getConnection();
	           con.setAutoCommit(false);
	           //String sql="UPDATE EMPLOYEESMASTER SET DOB=to_date(?,'dd-mon-yyyy'),DOJ=to_date(?,'dd-mon-yyyy'),ADDRESS=?,SALARY=?,EMPQUALID=?,EMPDEPTID=?,EMPDESGID=?,EMPGENDER=?,MSTATUS=?,EMPPHNO=?,EMAILID=?,INCHARGEID=?,USERNAME=?,PASSWORD=?,PERFORMANCERANK=? WHERE EMPID=? AND EMPFSTNAME=?";
	           cstmt= con.prepareCall("{ call UPDATE_EMP_PROFILE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");   
	          	           
	           cstmt.setString(1,DateWrapper.parseDate(emodel.getDob()));	
	           
	           
	           cstmt.setString(2,DateWrapper.parseDate(emodel.getDoj())); 
	          
	           cstmt.setString(3,emodel.getAddress());
	          
	           cstmt.setDouble(4,emodel.getSal());	   
	          
	           cstmt.setInt(5,emodel.getQualid());   
	           
	           
	           cstmt.setInt(6,emodel.getDeptid());
	         
	           cstmt.setInt(7,emodel.getDesgid());	
	           
	           cstmt.setString(8,emodel.getGender());
	          
	           cstmt.setString(9,emodel.getMstatus());  
	           
	           cstmt.setString(10,emodel.getPhno());
	           
	          
	           cstmt.setString(11,emodel.getEmailid()); 
	          
	           cstmt.setInt(12,emodel.getEmpinchargid());
	          
	           cstmt.setInt(13,emodel.getPerformrank());
	           
	           cstmt.setInt(14,emodel.getEmpid());
	          
	           cstmt.setString(15,emodel.getFirstname());
	          
	           
	            int i= cstmt.executeUpdate();
	            System.out.println("---i-----"+i);
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
		    catch(SQLException e)
			{
			System.out.println(e.toString());
			if(e.toString().equalsIgnoreCase("java.sql.SQLException: [Microsoft][ODBC driver for Oracle][Oracle]ORA-12571: TNS:packet writer failure"))
				{
				flag=true;
				System.out.println("n==="+flag);
				}
		System.out.println(e);

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
		    finally{
		    	
		    	try 
		        {
		    		if(con!=null)
		            con.close();
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
		    	
		    }
		    
		
	 return flag; 	
	}
	
	
public boolean addgeneralmanager(EmpModel emodel){
		
		
		String photo=emodel.getPhoto();
		
		 CallableStatement cstmt=null;
	        try 
	        {
	        	System.out.println("photo="+photo);
	        	File f=new File(photo);
	        	FileInputStream fis=new FileInputStream(f); 
	        	int mgid=0;
	        	con=getConnection();
	           con.setAutoCommit(false);
	         cstmt= con.prepareCall(" { call ADD_GMANAGER(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
	          
	           
	           cstmt.setString(1,emodel.getFirstname());
	           System.out.println("----emodel.getFirstname()-----"+emodel.getFirstname());
	           cstmt.setString(2,emodel.getLastname());
	           System.out.println("----emodel.getLastname()------"+emodel.getLastname());	           
	           cstmt.setString(3,emodel.getMiddlename());
	           System.out.println("-------emodel.getMiddlename()------"+emodel.getMiddlename());	           
	           cstmt.setString(4,DateWrapper.parseDate(emodel.getDob()));
	           System.out.println("-------DateWrapper.parseDate(emodel.getDob())------"+DateWrapper.parseDate(emodel.getDob()));
	           cstmt.setString(5,DateWrapper.parseDate(emodel.getDoj()));
	           System.out.println("-------emodel.getDoj()----"+emodel.getDoj());
	           
	           cstmt.setString(6,emodel.getAddress());
	           cstmt.setDouble(7,emodel.getSal());	           
	           cstmt.setInt(8,emodel.getQualid());          
	           cstmt.setInt(9,emodel.getDeptid());
	           cstmt.setInt(10,emodel.getDesgid());	           
	           cstmt.setString(11,emodel.getGender());
	           cstmt.setString(12,emodel.getMstatus()); 
	           cstmt.setBinaryStream(13,fis,(int)f.length());
               //cstmt.setInt(14,emodel.getEmpid());
               cstmt.setInt(14,mgid);
               System.out.println("---mgid--"+mgid);
	           cstmt.setInt(15,emodel.getQuestionid());
	           System.out.println("---emodel.getQuestionid()--"+emodel.getQuestionid());
	           cstmt.setString(16,emodel.getAnswer());	
	           System.out.println("-------emodel.getAnswer()-----"+emodel.getAnswer());
	           cstmt.setString(17,emodel.getEmailid());
	           System.out.println("-----emodel.getEmailid()-------"+emodel.getEmailid());
	           cstmt.setString(18,emodel.getPhno());
	           System.out.println("-----emodel.getPhno()----"+emodel.getPhno());
	           cstmt.setInt(19,emodel.getPerformrank());
	           System.out.println("-----emodel.getPerformrank()------"+emodel.getPerformrank()); 
	            
	            int i= cstmt.executeUpdate();
	            System.out.println("---i-----"+i);
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
		    catch(SQLException e)
			{
			System.out.println(e.toString());
			if(e.toString().equalsIgnoreCase("java.sql.SQLException: [Microsoft][ODBC driver for Oracle][Oracle]ORA-12571: TNS:packet writer failure"))
				{
				flag=true;
				System.out.println("n==="+flag);
				}
		System.out.println(e);

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
		    finally{
		    	
		    	try 
		        {
		    		if(con!=null)
		            con.close();
		        } 
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
		    	
		    }
		    
		    
		
		
		
		
	 return flag; 	
	}
	
	
	
	
	
	 public CoreHash getQualification(){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			EmpModel aEmpModel=null;
			try {
				 con = getConnection();
				   
				
	            	 cstmt=con.createStatement();
	            	 //cstmt.registerOutParameter(1,OracleTypes.CURSOR);
	            	 
	            	 //ResultSet rs=((OracleCallableStatement)cstmt).getCursor(1);
	            	 ResultSet rs=cstmt.executeQuery("select qualid,Initcap(QUALFULLNAME) from qualificationmaster");
	            	 while(rs.next())
	                 {
	              	   aEmpModel=new EmpModel();
	              	   System.out.println("In GetManager"+rs.getInt(1)+rs.getString(2));
	              	   aEmpModel.setQualid(rs.getInt(1));
	              	   aEmpModel.setQualname(rs.getString(2));  
	              	   
	               	   
	              	 aCoreHash.put(new Integer(sno),aEmpModel);
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
	 
	 public CoreHash getDeptNames(){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			EmpModel aEmpModel=null;
			try {
				 con = getConnection();
				   
				
	            	 cstmt=con.createStatement();
	            	 
	            	 ResultSet rs=cstmt.executeQuery("select departmentid,initcap(deptname) from departmentmaster where deptname not like upper('administration')");
	            //	ResultSet rs=cstmt.executeQuery("select departmentid,initcap(deptname) from departmentmaster ");
	            	 while(rs.next())
	                 {
	              	   aEmpModel=new EmpModel();
	              	   aEmpModel.setDeptid(rs.getInt(1));
	              	   aEmpModel.setDeptname(rs.getString(2));  
	              	   
	                   	
	               	   
	              	 aCoreHash.put(new Integer(sno),aEmpModel);
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
	 
	 public CoreHash getUserDeptNames(){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			EmpModel aEmpModel=null;
			try {
				 con = getConnection();
				   
				
	            	 cstmt=con.createStatement();
	            	 
	            	// ResultSet rs=cstmt.executeQuery("select departmentid,initcap(deptname) from departmentmaster where deptname not like 'Election'");
	            	ResultSet rs=cstmt.executeQuery("select departmentid,initcap(deptname) from departmentmaster ");
	            	 while(rs.next())
	                 {
	              	   aEmpModel=new EmpModel();
	              	   aEmpModel.setDeptid(rs.getInt(1));
	              	   aEmpModel.setDeptname(rs.getString(2));  
	              	   
	              	 aCoreHash.put(new Integer(sno),aEmpModel);
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
	 
	    public CoreHash getDesigNames(){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			EmpModel aEmpModel=null;
			try {
				 con = getConnection();
				   System.out.println("con"+con);
				
	            	 cstmt=con.createStatement();
	            	 System.out.println("cstmt"+cstmt);
	            	 
	            	// ResultSet rs=cstmt.executeQuery("select designationid,initcap(designationname) from designationmaster where UPPER(designationname) not LIKE UPPER('Administrator')");
	            	 ResultSet rs=cstmt.executeQuery("select designationid,initcap(designationname) from designationmaster");
	            	 while(rs.next())
	                 {
	              	   aEmpModel=new EmpModel();
	              	   aEmpModel.setDesgid(rs.getInt(1));
	              	   aEmpModel.setDesgname(rs.getString(2));  
	              	   
	               	   
	              	 aCoreHash.put(new Integer(sno),aEmpModel);
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
	    
	    
	    public CoreHash getDesigNamesOfUsers(){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			EmpModel aEmpModel=null;
			try {
				 con = getConnection();
				   System.out.println("con"+con);
				
	            	 cstmt=con.createStatement();
	            	 System.out.println("cstmt"+cstmt);
	            	 
	            	 //ResultSet rs=cstmt.executeQuery("select designationid,initcap(designationname) from designationmaster where designationname not in('commissioner','field officer')");
	            	 ResultSet rs=cstmt.executeQuery("select designationid,initcap(designationname) from designationmaster");
	            	 while(rs.next())
	                 {
	              	   aEmpModel=new EmpModel();
	              	   aEmpModel.setDesgid(rs.getInt(1));
	              	   aEmpModel.setDesgname(rs.getString(2));  
	              	   
	               	   
	              	 aCoreHash.put(new Integer(sno),aEmpModel);
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
	    
	    
	    public CoreHash getManager(){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			EmpModel aEmpModel=null;
			try {
				 con = getConnection();
				   System.out.println("con"+con);
				
	            	 cstmt=con.createStatement();
	            	 System.out.println("cstmt"+cstmt);
	            	
	            	// ResultSet rs=cstmt.executeQuery("select empid,empfstname from employeesmaster where upper(logintype)=upper('MANAGINGDIRECTOR')");
	            	 ResultSet rs=cstmt.executeQuery("select empid,empfstname from employeesmaster");
	            	 while(rs.next())
	                 {
	              	   aEmpModel=new EmpModel();
	              	   System.out.println("In Manger");
	              	   System.out.println(rs.getInt(1)+""+rs.getString(2));
	              	   aEmpModel.setEmpid(rs.getInt(1));
	              	   aEmpModel.setManagername(rs.getString(2));  
	              	                 	   
	              	 aCoreHash.put(new Integer(sno),aEmpModel);
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
			 catch(Exception e){e.printStackTrace();}
			}
			return aCoreHash;
	    }

	    public CoreHash getGeneralManager(){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			EmpModel aEmpModel=null;
			try {
				 con = getConnection();
				   System.out.println("con"+con);
				
	            	 cstmt=con.createStatement();
	            	 System.out.println("cstmt"+cstmt);
	            	
	            	// ResultSet rs=cstmt.executeQuery("select empid,empfstname from employeesmaster where upper(logintype)=upper('gmanager')");
	            	 ResultSet rs=cstmt.executeQuery("select empid,empfstname from employeesmaster");
	            	 while(rs.next())
	                 {
	              	   aEmpModel=new EmpModel();
	              	   System.out.println("In Manger");
	              	   System.out.println(rs.getInt(1)+""+rs.getString(2));
	              	   aEmpModel.setEmpid(rs.getInt(1));
	              	   aEmpModel.setManagername(rs.getString(2));  
	              	                 	   
	              	 aCoreHash.put(new Integer(sno),aEmpModel);
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
			 catch(Exception e){e.printStackTrace();}
			}
			return aCoreHash;
	    }

	    
	    public EmpModel getInchargeName(){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			EmpModel aEmpModel=null;
			try {
				 con = getConnection();
				   System.out.println("con"+con);
				
	            	 cstmt=con.createStatement();
	            	 System.out.println("cstmt"+cstmt);
	            	 
	            	// ResultSet rs=cstmt.executeQuery("select empid,empfstname from employeesmaster where empid=(select empid from employeesmaster where upper(logintype)=upper('commissioner'))");
	            	 ResultSet rs=cstmt.executeQuery("select empid,empfstname from employeesmaster");
	            	 while(rs.next())
	                 {
	              	   aEmpModel=new EmpModel();
	              	   
	              	   aEmpModel.setEmpinchargid(rs.getInt(1));
	              	   aEmpModel.setEmpinchargname(rs.getString(2));  
	              	                 	   
	              	 aCoreHash.put(new Integer(sno),aEmpModel);
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
			 catch(Exception e){e.printStackTrace();}
			}
			return aEmpModel;
	    }

	    
	    
	    public CoreHash getAllInchargeName(){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			EmpModel aEmpModel=null;
			try {
				 con = getConnection();
				   System.out.println("con"+con);
				
	            	 cstmt=con.createStatement();
	            	 System.out.println("cstmt"+cstmt);
	            	 
	            	 ResultSet rs=cstmt.executeQuery("select empid,Initcap(empfstname) from employeesmaster where empid=(select empid from employeesmaster where upper(logintype)=upper('Admin'))");
	            	// ResultSet rs=cstmt.executeQuery("select empid,empfstname from employeesmaster");
	            	 while(rs.next())
	                 {
	              	   aEmpModel=new EmpModel();
	              	   
	              	   aEmpModel.setEmpinchargid(rs.getInt(1));
	              	   aEmpModel.setEmpinchargname(rs.getString(2));  
	              	                 	   
	              	 aCoreHash.put(new Integer(sno),aEmpModel);
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
			 catch(Exception e){e.printStackTrace();}
			}
			return aCoreHash;
	    }

	    
	    
	    
	    
	    
	    public boolean addquestion(EmpModel pmodel)
	    {
	    	
	        String question=pmodel.getQuestionname();
	        
	        PreparedStatement pst=null;
	      
	        try 
	        {
	        	            
	        	con=getConnection();
	        	System.out.println("-----con---------->"+con);
	          
	           String sql="insert into questionmaster values((select nvl(max(questionid),0)+1 from questionmaster),?)";
	           pst=con.prepareStatement(sql);
	           pst.setString(1,question); 
	           
	           int i= pst.executeUpdate();
	           
	           System.out.println("----i--------------->"+i);
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
	            
	        }
	        finally{
	        	
	        	try{
	        		if(con!=null){
	        			con.close();
	        		}
	        	}
	        	catch (Exception se) 
	            {
	                se.printStackTrace();
	            }
	        }
	        
	        return flag;
	    }

	    public CoreHash getquestionbase(){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
	    	System.out.println("aCoreHash--"+aCoreHash.isEmpty());
	    	int sno=1;
	    	ResultSet rs=null;
	    	Statement st=null;
	    	EmpModel aEmpModel=null;
	    	try {
	    		 con = getConnection();
	    		   System.out.println("con"+con);
	    		   String sql="select *from questionmaster";
	    		st=con.createStatement();
	    		
	            rs=st.executeQuery(sql);	

	            	 while(rs.next())
	                 {
	              	   aEmpModel=new EmpModel();
	              	  
	              	   aEmpModel.setQuestionid(rs.getInt(1));
	              	   aEmpModel.setQuestionname(rs.getString(2));  
	              	  
	                  
	              	 aCoreHash.put(new Integer(sno),aEmpModel);
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
 
	    public CoreHash getEmployeeAbsDetails(){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			ResultSet rs=null;
			EmpModel rb=null;
			Statement st=null;
		        try
		        {
		        	con=getConnection();
		        	System.out.println("------con---------"+con);
		        	st=con.createStatement();
		        	System.out.println("-----st---------"+st);
		        	String sql="SELECT E.EMPID,E.EMPFSTNAME,ABS(MONTHS_BETWEEN(TO_DATE(E.DOB,'DD-MM-YYYY'),TO_DATE(E.DOJ,'DD-MM-YYYY'))/12) YEARS,Q.QUALABBR,D.DEPTNAME,DSG.DESIGNATIONNAME,E.EMPGENDER,C.CONSTNAME,E.LOGINTYPE FROM EMPLOYEESMASTER E,CONSTITUENCYMASTER C,DESIGNATIONMASTER DSG,DEPARTMENTMASTER D,QUALIFICATIONMASTER Q WHERE ((E.EMPQUALID=Q.QUALID)AND(E.ASSIGNCONSTNCYID=C.CONSTID))AND ((E.EMPDEPTID=D.DEPARTMENTID)AND (E.EMPDESGID=DSG.DESIGNATIONID)) order by E.EMPID desc";
//		        	CallableStatement cs=con.prepareCall("{call VIEW_EMP_DTLS(?,?,?,?,?,?,?,?,?,?)}");
//				    System.out.println(cs);
//				    cs.registerOutParameter(1,Types.NUMERIC);
//					cs.registerOutParameter(2,Types.VARCHAR);
//					cs.registerOutParameter(3,Types.NUMERIC);
//					cs.registerOutParameter(4,Types.VARCHAR);
//					cs.registerOutParameter(5,Types.VARCHAR);
//					cs.registerOutParameter(6,Types.VARCHAR);
//					cs.registerOutParameter(7,Types.VARCHAR);
//					cs.registerOutParameter(8,Types.VARCHAR);					
//					cs.registerOutParameter(9,Types.VARCHAR);
//					cs.registerOutParameter(10,Types.VARCHAR);
					
					rs=st.executeQuery(sql);
					while(rs.next()){
						
					rb=new EmpModel();	
					rb.setEmpid(rs.getInt(1));
					System.out.println("-----rs.getInt(1)-----  "+rs.getInt(1));
					rb.setFirstname(rs.getString(2));
					System.out.println("-----rs.getString(2)-----  "+rs.getString(2));
					rb.setExp(rs.getInt(3));	
					System.out.println("-----rs.getInt(3)-----  "+rs.getInt(3));
					rb.setQualname(rs.getString(4));
					System.out.println("-----rs.getString(4)-----  "+rs.getString(4));
					rb.setDeptname(rs.getString(5));
					System.out.println("-----rs.getString(5)-----  "+rs.getString(5));
					rb.setDesgname(rs.getString(6));
					System.out.println("-----rs.getString(6)-----  "+rs.getString(6));
					rb.setGender(rs.getString(7));
					System.out.println("-----rs.getString(7)-----  "+rs.getString(7));
					rb.setConstituencyname(rs.getString(8));
					System.out.println("-----rs.getString(8)-----  "+rs.getString(8));
					//rb.setManagername(rs.getString(9));
					//System.out.println("-----rs.getString(9)-----  "+rs.getString(9));
					rb.setLogintype(rs.getString(9));
					System.out.println("-----rs.getString(9)-----  "+rs.getString(9));
			
	              	 aCoreHash.put(new Integer(sno),rb);
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
	 
	   
	    
	    
	    
	    public CoreHash getAllEmployeesProfiles(String images){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			Statement cstmt;
			ResultSet rs=null;
			EmpModel rb=null;
			Statement st=null;
		        try
		        {
		        	con=getConnection();
		        	System.out.println("------con---------"+con);
		        	st=con.createStatement();
		        	System.out.println("-----st---------"+st);
		        	//String sql="SELECT E.EMPID,E.EMPFSTNAME,to_char(E.DOB,'dd-mm-yyyy'),to_char(E.DOJ,'dd-mm-yyyy'),E.ADDRESS,E.SALARY,E.EMPQUALID,Q.QUALABBR,E.EMPDEPTID,D.DEPTNAME,E.EMPDESGID,DSG.DESIGNATIONNAME,E.EMPGENDER,E.MSTATUS,E.ASSIGNCONSTNCYID,C.CONSTNAME,E.INCHARGEID,E1.EMPFSTNAME,E.USERNAME,E.PASSWORD,E.EMAILID,E.EMPPHOTO FROM EMPLOYEESMASTER E,CONSTITUENCYMASTER C,DESIGNATIONMASTER DSG,DEPARTMENTMASTER D,QUALIFICATIONMASTER Q,(SELECT EMPFSTNAME FROM EMPLOYEESMASTER  WHERE EMPID IN (SELECT INCHARGEID FROM EMPLOYEESMASTER)) E1 WHERE ((E.EMPQUALID=Q.QUALID)AND(E.ASSIGNCONSTNCYID=C.CONSTID)) AND ((E.EMPDEPTID=D.DEPARTMENTID)AND (E.EMPDESGID=DSG.DESIGNATIONID))";
        	//String sql="SELECT E.EMPID,E.EMPFSTNAME,to_char(E.DOB,'dd-mm-yyyy'),to_char(E.DOJ,'dd-mm-yyyy'),E.ADDRESS,E.SALARY,E.EMPQUALID,Q.QUALABBR,E.EMPDEPTID,D.DEPTNAME,E.EMPDESGID,DSG.DESIGNATIONNAME,E.EMPGENDER,E.MSTATUS,E.INCHARGEID,E1.EMPFSTNAME,E.USERNAME,E.PASSWORD,E.EMAILID,E.EMPPHOTO,E.PERFORMANCERANK FROM EMPLOYEESMASTER E,DESIGNATIONMASTER DSG,DEPARTMENTMASTER D,QUALIFICATIONMASTER Q,(SELECT EMPFSTNAME FROM EMPLOYEESMASTER  WHERE EMPID IN (SELECT INCHARGEID FROM EMPLOYEESMASTER)) E1 WHERE (E.EMPQUALID=Q.QUALID) AND (E.EMPDEPTID=D.DEPARTMENTID)AND (E.EMPDESGID=DSG.DESIGNATIONID)";
		        	String sql="SELECT E.EMPID,E.EMPFSTNAME,to_char(E.DOB,'dd-mm-yyyy'),to_char(E.DOJ,'dd-mm-yyyy'),E.ADDRESS,E.SALARY,E.EMPQUALID,Q.QUALABBR,E.EMPDEPTID,D.DEPTNAME,E.EMPDESGID,DSG.DESIGNATIONNAME,E.EMPGENDER,E.MSTATUS,E.INCHARGEID,E1.EMPFSTNAME,E.USERNAME,E.PASSWORD,E.EMAILID,E.EMPPHOTO,E.PERFORMANCERANK FROM EMPLOYEESMASTER E,EMPLOYEESMASTER E1,DESIGNATIONMASTER DSG,DEPARTMENTMASTER D,QUALIFICATIONMASTER Q where (E.EMPDEPTID=D.DEPARTMENTID)AND (E.EMPDESGID=DSG.DESIGNATIONID) and (E.EMPID=E1.EMPID)";		
					rs=st.executeQuery(sql);
					while(rs.next()){
						
					rb=new EmpModel();	
					int empid=rs.getInt(1);
					rb.setEmpid(empid);					
					rb.setFirstname(rs.getString(2));					
					rb.setDob(rs.getString(3));
					rb.setDoj(rs.getString(4));
					rb.setAddress(rs.getString(5));
					rb.setSal(rs.getDouble(6));
					rb.setQualid(rs.getInt(7));
					rb.setQualname(rs.getString(8));
					rb.setDeptid(rs.getInt(9));					
					rb.setDeptname(rs.getString(10));					
					rb.setDesgid(rs.getInt(11));
					rb.setDesgname(rs.getString(12));					
					rb.setGender(rs.getString(13));
					rb.setMstatus(rs.getString(14));										
					rb.setEmpinchargid(rs.getInt(15));
					rb.setEmpinchargname(rs.getString(16));
					rb.setUsername(rs.getString(17));
					rb.setPassword(rs.getString(18));
					rb.setEmailid(rs.getString(19));					
					Blob bb =rs.getBlob(20);					
					byte bb1[]=bb.getBytes(1,(int)bb.length());
					OutputStream fout1=new FileOutputStream(images+"/"+empid+".gif");
					fout1.write(bb1);
					rb.setPhoto(empid+".gif");
					
					rb.setPerformrank(rs.getInt(21));
	              	 aCoreHash.put(new Integer(sno),rb);
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
	 
	    
	    
	    
	    public EmpModel getEmployeesPersonalProfiles(String images,String loginname){
	    	
			
			int sno=1;
			
			ResultSet rs=null;
			EmpModel rb=null;
			Statement st=null;
		        try
		        {
		        	con=getConnection();
		        	System.out.println("------con---------"+con);
		        	st=con.createStatement();
		        	System.out.println("-----st---------"+st);
		       // String sql="SELECT EMPID,EMPFSTNAME FROM EMPLOYEESMASTER WHERE USERNAME LIKE '"+loginname+"'";
		        	
		        	String sql="SELECT E.EMPID,E.EMPFSTNAME,to_char(E.DOB,'dd-mm-yyyy'),to_char(E.DOJ,'dd-mm-yyyy'),E.ADDRESS,E.SALARY,E.EMPQUALID,Q.QUALABBR,E.EMPDEPTID,D.DEPTNAME,E.EMPDESGID,DSG.DESIGNATIONNAME,E.EMPGENDER,E.MSTATUS,E.INCHARGEID,E1.EMPFSTNAME,E.USERNAME,E.PASSWORD,E.EMAILID,E.EMPPHOTO FROM EMPLOYEESMASTER E,DESIGNATIONMASTER DSG,DEPARTMENTMASTER D,QUALIFICATIONMASTER Q,(SELECT EMPFSTNAME FROM EMPLOYEESMASTER  WHERE EMPID IN (SELECT INCHARGEID FROM EMPLOYEESMASTER)) E1 WHERE ((E.EMPQUALID=Q.QUALID)) AND ((E.EMPDEPTID=D.DEPARTMENTID)AND (E.EMPDESGID=DSG.DESIGNATIONID)) AND E.USERNAME='"+loginname+"'";
		        	
					
					rs=st.executeQuery(sql);
					while(rs.next()){
						
					rb=new EmpModel();	
					int empid=rs.getInt(1);
					rb.setEmpid(empid);					
					rb.setFirstname(rs.getString(2));					
					rb.setDob(rs.getString(3));
					rb.setDoj(rs.getString(4));
					rb.setAddress(rs.getString(5));
					rb.setSal(rs.getDouble(6));
					rb.setQualid(rs.getInt(7));
					rb.setQualname(rs.getString(8));
					rb.setDeptid(rs.getInt(9));					
					rb.setDeptname(rs.getString(10));					
					rb.setDesgid(rs.getInt(11));
					rb.setDesgname(rs.getString(12));					
					rb.setGender(rs.getString(13));
					rb.setMstatus(rs.getString(14));
									
					rb.setEmpinchargid(rs.getInt(15));
					rb.setEmpinchargname(rs.getString(16));
					rb.setUsername(rs.getString(17));
					rb.setPassword(rs.getString(18));
					rb.setEmailid(rs.getString(19));
					
					Blob bb =rs.getBlob(20);					
					byte bb1[]=bb.getBytes(1,(int)bb.length());
					OutputStream fout1=new FileOutputStream(images+"/"+empid+".gif");
					fout1.write(bb1);
					rb.setPhoto(empid+".gif");
				System.out.println("-------in EmployeeRegistrationDAO and Employee Personal profile--------");	
	              	 
	 		  
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
			return rb;
	    }
	    
	    
	    
	    
	    
 public EmpModel getEmployeesPersonalIdName(String loginname){
	    	
			
			int sno=1;
			
			ResultSet rs=null;
			EmpModel rb=null;
			Statement st=null;
		        try
		        {
		        	con=getConnection();
		        	System.out.println("------con---------"+con);
		        	st=con.createStatement();
		        	System.out.println("-----st---------"+st);
		         String sql="SELECT EMPID,EMPFSTNAME FROM EMPLOYEESMASTER WHERE USERNAME LIKE '"+loginname+"'";
		        	
					rs=st.executeQuery(sql);
					while(rs.next()){
						
					rb=new EmpModel();	
					int empid=rs.getInt(1);
					rb.setEmpid(empid);					
					rb.setFirstname(rs.getString(2));					
					
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
			return rb;
	    }
	    
	    public EmpModel getEmployeeProfileDetailsById(String images,int employeeid){
	    	CoreHash aCoreHash=new CoreHash();
	    	aCoreHash.clear();
			System.out.println("aCoreHash--"+aCoreHash.isEmpty());
			int sno=1;
			
			ResultSet rs=null;
			EmpModel rb=null;
			Statement st=null;
		        try
		        {
		        	con=getConnection();
		        	System.out.println("------con---------"+con);
		        	st=con.createStatement();
		        	System.out.println("-----st---------"+st);
		        	//String sql="SELECT E.EMPID,E.EMPFSTNAME,to_char(E.DOB,'dd-mm-yyyy'),to_char(E.DOJ,'dd-mm-yyyy'),E.ADDRESS,E.SALARY,E.EMPQUALID,Q.QUALABBR,E.EMPDEPTID,D.DEPTNAME,E.EMPDESGID,DSG.DESIGNATIONNAME,E.EMPGENDER,E.MSTATUS,E.INCHARGEID,E1.EMPFSTNAME,E.USERNAME,E.PASSWORD,E.EMAILID,E.EMPPHOTO FROM EMPLOYEESMASTER E,CONSTITUENCYMASTER C,DESIGNATIONMASTER DSG,DEPARTMENTMASTER D,QUALIFICATIONMASTER Q,(SELECT EMPFSTNAME FROM EMPLOYEESMASTER  WHERE EMPID IN (SELECT INCHARGEID FROM EMPLOYEESMASTER)) E1 WHERE ((E.EMPQUALID=Q.QUALID)AND(E.ASSIGNCONSTNCYID=C.CONSTID)) AND ((E.EMPDEPTID=D.DEPARTMENTID)AND (E.EMPDESGID=DSG.DESIGNATIONID)) AND E.EMPID="+employeeid;
		        	  String sql="SELECT E.EMPID,E.EMPFSTNAME,to_char(E.DOB,'dd-mm-yyyy'),to_char(E.DOJ,'dd-mm-yyyy'),E.ADDRESS,E.SALARY,E.EMPQUALID,Q.QUALABBR,E.EMPDEPTID,D.DEPTNAME,E.EMPDESGID,DSG.DESIGNATIONNAME,E.EMPGENDER,E.MSTATUS,E.INCHARGEID,E1.EMPFSTNAME,E.USERNAME,E.PASSWORD,E.EMAILID,E.EMPPHOTO,E.PERFORMANCERANK ,E.EMPPHNO FROM EMPLOYEESMASTER E,DESIGNATIONMASTER DSG,DEPARTMENTMASTER D,QUALIFICATIONMASTER Q,(SELECT EMPFSTNAME FROM EMPLOYEESMASTER  WHERE EMPID IN (SELECT INCHARGEID FROM EMPLOYEESMASTER)) E1 WHERE (E.EMPQUALID=Q.QUALID) AND (E.EMPDEPTID=D.DEPARTMENTID)AND (E.EMPDESGID=DSG.DESIGNATIONID) AND E.EMPID="+employeeid;
					
					rs=st.executeQuery(sql);
					while(rs.next()){
						
						rb=new EmpModel();	
						int empid=rs.getInt(1);
						rb.setEmpid(empid);					
						rb.setFirstname(rs.getString(2));					
						rb.setDob(rs.getString(3));
						rb.setDoj(rs.getString(4));
						rb.setAddress(rs.getString(5));
						rb.setSal(rs.getDouble(6));
						rb.setQualid(rs.getInt(7));
						rb.setQualname(rs.getString(8));
						rb.setDeptid(rs.getInt(9));					
						rb.setDeptname(rs.getString(10));					
						rb.setDesgid(rs.getInt(11));
						rb.setDesgname(rs.getString(12));					
						rb.setGender(rs.getString(13));
						rb.setMstatus(rs.getString(14));										
						rb.setEmpinchargid(rs.getInt(15));
						rb.setEmpinchargname(rs.getString(16));
						rb.setUsername(rs.getString(17));
						rb.setPassword(rs.getString(18));
						rb.setEmailid(rs.getString(19));					
						Blob bb =rs.getBlob(20);					
						byte bb1[]=bb.getBytes(1,(int)bb.length());
						OutputStream fout1=new FileOutputStream(images+"/"+empid+".gif");
						fout1.write(bb1);
						rb.setPhoto(empid+".gif");
						
						rb.setPerformrank(rs.getInt(21));
				System.out.println("-------in EmployeeRegistrationDAO and Employee Personal profile--------");	
				rb.setPhno(rs.getString(22));
	 		  
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
			return rb;
	    }
	    
	    
	   
	    
}
