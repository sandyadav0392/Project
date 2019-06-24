/*
 * ProfileDAO.java
 *
 * 
 * 
 */

package com.dts.dae.dao;
import oracle.jdbc.driver.*;
import com.dts.dae.model.Profile;

import com.dts.core.dao.AbstractDataAccessObject; 
import com.dts.core.util.CoreHash;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.Date;
import java.util.Properties;


/**
 *
 * @author 
 */
public class ProfileDAO extends AbstractDataAccessObject{
    
    public Connection con;

    private boolean flag;
    /** Creates a new instance of ProfileDAO */
    public ProfileDAO() 
    {
           //getting Database Connection
           
    }
    
       
    //User Registration
    public boolean register(Profile regbean)
    {
    	
        
        String firstname=regbean.getFirstName();
        System.out.println("firstname-------->"+firstname);
        String middlename=regbean.getMiddleName();
        System.out.println("middlename---------->"+middlename);
        String lastname=regbean.getLastName();
        System.out.println("lastname-------------->"+lastname);
        String photo=regbean.getPhoto();
        
        String bdate=DateWrapper.parseDate(regbean.getBirthDate());
        System.out.println("bdate--------------->"+bdate);
        String doj=DateWrapper.parseDate(regbean.getDateOfJoin());
        System.out.println("doj-------------->"+doj);
        String address=regbean.getAddress();
        System.out.println("address------------->"+address);
        double salary =regbean.getSal();
        System.out.println("salary----------------->"+salary);
        int desigid=regbean.getDesigId();
        System.out.println("desigid----------------->"+desigid);
        int deptid=regbean.getDeptId();
        System.out.println("deptid--------------------->"+deptid);
        int hqualid=regbean.getQualId();
        System.out.println("hqualid------------------------->"+hqualid);
        String gender=regbean.getGender();
        System.out.println("gender----------------------->"+gender);
        int mgr=regbean.getManagerid();
        System.out.println("mgr----------------------->"+mgr);
        int constiteuencyid=regbean.getConstituencyid();
        System.out.println("constiteuencyid----------------->"+constiteuencyid);
        int qid=regbean.getQuestionid();
        System.out.println("qid-------------------------->"+qid);
        String ans=regbean.getSecretqans();
        System.out.println("ans----------------------->"+ans);
        String mstatus=regbean.getMartialStatus(); 
        System.out.println("mstatus---------------->"+mstatus);
        String email=regbean.getEmail();
        
       System.out.println("email-------------->"+email);
        CallableStatement cstmt=null;
        try 
        {
        	System.out.println("photo="+photo);
        	File f=new File(photo);
        	FileInputStream fis=new FileInputStream(f); 
        	
        	con=getConnection();
          // con.setAutoCommit(false);
         cstmt= con.prepareCall(" { call ADD_EMP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
          
           
            cstmt.setString(1,firstname);
            cstmt.setString(2,lastname);
           cstmt.setString(3,middlename);
           cstmt.setString(4,bdate);
           cstmt.setString(5,doj);
           cstmt.setString(6,address);
           cstmt.setDouble(7,salary);
           cstmt.setInt(8,hqualid);          
           cstmt.setInt(9,deptid);
           cstmt.setInt(10,desigid);
           cstmt.setString(11,gender);
           cstmt.setString(12,mstatus);
           cstmt.setBinaryStream(13,fis,(int)f.length());
           cstmt.setInt(14,constiteuencyid);       
           cstmt.setInt(15,0);
           cstmt.setInt(16,qid);
           cstmt.setString(17,ans);
            cstmt.setString(18,email);          
          
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
    
    //Getting profile
    public Profile getEmployeeProfile(String loginname)
    {
        Profile rb=new Profile();
        try
        {
        	con=getConnection();
        	CallableStatement cs=con.prepareCall("{call EMPPROFILESELECT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		    System.out.println(cs);
		    cs.setString(1,loginname);
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.registerOutParameter(3,Types.VARCHAR);
			cs.registerOutParameter(4,Types.VARCHAR);
			cs.registerOutParameter(5,Types.VARCHAR);
			cs.registerOutParameter(6,Types.VARCHAR);
			cs.registerOutParameter(7,Types.VARCHAR);
			cs.registerOutParameter(8,Types.VARCHAR);
			cs.registerOutParameter(9,Types.BLOB);
			cs.registerOutParameter(10,Types.VARCHAR);
			cs.registerOutParameter(11,Types.VARCHAR);
			cs.registerOutParameter(12,Types.VARCHAR);
			cs.registerOutParameter(13,Types.VARCHAR);
			cs.registerOutParameter(14,Types.VARCHAR);
			cs.registerOutParameter(15,Types.VARCHAR);
			cs.registerOutParameter(16,Types.VARCHAR);
			cs.registerOutParameter(17,Types.VARCHAR);
			cs.registerOutParameter(18,Types.VARCHAR);
			cs.registerOutParameter(19,Types.VARCHAR);
			cs.registerOutParameter(20,Types.VARCHAR);
			cs.registerOutParameter(21,Types.VARCHAR);
			cs.registerOutParameter(22,Types.VARCHAR);
			cs.registerOutParameter(23,Types.VARCHAR);
			cs.registerOutParameter(24,Types.VARCHAR);
			cs.registerOutParameter(25,Types.VARCHAR);
			cs.registerOutParameter(26,Types.VARCHAR);
			cs.registerOutParameter(27,Types.VARCHAR);
			cs.registerOutParameter(28,Types.VARCHAR);
			cs.registerOutParameter(29,Types.VARCHAR);
			cs.registerOutParameter(30,Types.VARCHAR);
			cs.registerOutParameter(31,Types.VARCHAR);
			cs.registerOutParameter(32,Types.VARCHAR);
			cs.registerOutParameter(33,Types.VARCHAR);
			cs.registerOutParameter(34,Types.VARCHAR);
			cs.registerOutParameter(35,Types.VARCHAR);
			cs.registerOutParameter(36,Types.VARCHAR);
			cs.registerOutParameter(37,Types.VARCHAR);
			cs.registerOutParameter(38,Types.VARCHAR);
			cs.registerOutParameter(39,Types.VARCHAR);
			cs.registerOutParameter(40,Types.VARCHAR);
			cs.registerOutParameter(41,Types.DOUBLE);
			cs.execute();
			rb.setFirstname(cs.getString(2));
			
			rb.setLastname(cs.getString(3));
			rb.setMiddleName(cs.getString(4));
			
			rb.setBdate(cs.getString(5));
			//rb.setPhoto(cs.getString());
			rb.setDateOfJoin(cs.getString(6));
			rb.setGender(cs.getString(7));
			rb.setMartialStatus(cs.getString(8));
			rb.setHno(cs.getString(10));
			System.out.println("House No"+cs.getString(10));
			rb.setStreet(cs.getString(11));
			System.out.println("Street"+cs.getString(11));
//			rb.setHome(cs.getString(8));
			//rb.setHno(cs.getString(9));
			//rb.setStreet(cs.getString(10));
			rb.setCity(cs.getString(12));
			rb.setLandmark(cs.getString(13));
			rb.setState(cs.getString(14));
			//rb.setPin(cs.getString(13));
			rb.setCountry(cs.getString(15));
			rb.setPin(cs.getString(16));
			rb.setHome(cs.getString(17));
			//rb.setOffice(cs.getString(18));
			rb.setOhno(cs.getString(18));
			rb.setOstreet(cs.getString(19));
			rb.setOcity(cs.getString(20));
			rb.setOlandmark(cs.getString(21));
			rb.setOstate(cs.getString(22));
			//rb.setOpin(cs.getString(20));
			rb.setOcountry(cs.getString(23));
			rb.setOpin(cs.getString(24));
			rb.setOffice(cs.getString(25));
			
			rb.setChno(cs.getString(26));
			rb.setCstreet(cs.getString(27));
			rb.setCcity(cs.getString(28));
			rb.setPlandmark(cs.getString(29));
			rb.setCstate(cs.getString(30));
			//rb.setCpin(cs.getString(27));
			rb.setCcountry(cs.getString(31));
			rb.setCpin(cs.getString(32));
			rb.setContact(cs.getString(33));
			rb.setPhone(cs.getString(34));
			rb.setHomePhoneType(cs.getString(35));
			rb.setOphone(cs.getString(36));
			rb.setOfficePhoneType(cs.getString(37));
			rb.setCphone(cs.getString(38));
			rb.setPersonalPhoneType(cs.getString(39));
		    rb.setQualName(cs.getString(40));
		    rb.setSal(cs.getDouble(41));
		    System.out.println("SAlary"+cs.getDouble(41));
		 /*FileOutputStream fs = null;
         InputStream is = null;
         fs = new FileOutputStream("photo.jpg");
        
         is = cs.getBlob(35).getBinaryStream();
         byte[] buf = new byte[16384];
         int bytes;
         while ((bytes = is.read(buf)) != -1) {
             fs.write(buf, 0, bytes);
			
         }*/
//		Blob b =cs.getBlob(9);
//		byte b1[]=b.getBytes(1,(int)b.length());
//		OutputStream fout=new FileOutputStream("photo.jpg");
//		fout.write(b1);

	}
	
        catch(Exception e)
        {e.printStackTrace();
        	LoggerManager.writeLogSevere(e);
        }
        finally
        {
        	try{
        		con.close();
        	}catch(Exception e)
        	{
        		LoggerManager.writeLogSevere(e);
            }
        	
        }
        return rb;
    }     // Modify Profile
    public boolean modifyProfile(Profile regbean)
    {
    	
        String firstname=regbean.getFirstName();
        String lastname=regbean.getLastName();
        String middlename=regbean.getMiddleName();
        String photo=regbean.getPhoto();
        String dob=regbean.getBdate();
        String doj=regbean.getDateOfJoin();
        String gender=regbean.getGender();
        String mstatus=regbean.getMartialStatus();
        String qualification=regbean.getQualName();
       int empid=regbean.getEmpid();
       System.out.println(lastname+""+middlename+""+photo+""+dob+""+gender+""+mstatus+""+qualification);
       //home
        String hno=regbean.getHno();
        String home=regbean.getHome();
        String street=regbean.getStreet();
        String city=regbean.getCity();
        String state=regbean.getState();
        String country=regbean.getCountry();
        String pin=regbean.getPin();
        String Phonetype=regbean.getHomePhoneType();
        String phone=regbean.getPhone();
        String mgr=regbean.getManager();
        System.out.println(hno+""+home+""+street+""+city+""+state+""+country+""+pin+""+Phonetype+""+phone+""+mgr);
        //office
        String ohno=regbean.getOhno();
        String office=regbean.getOffice();
        String ostreet=regbean.getOstreet();
        String ocity=regbean.getOcity();
        String ostate=regbean.getOstate();
        String ocountry=regbean.getOcountry();
        String opin=regbean.getOpin();
        String oPhonetype=regbean.getOfficePhoneType();
        String ophone=regbean.getOphone();
        System.out.println(ohno+""+office+""+ostreet+""+ocity+""+ostate+""+ocountry+""+opin+""+oPhonetype+""+ophone);
        //personal
        String phno=regbean.getChno();
        String contact=regbean.getContact();
        String pstreet=regbean.getCstreet();
        String pcity=regbean.getCcity();
        String pstate=regbean.getCstate();
        String pcountry=regbean.getCcountry();
        String ppin=regbean.getCpin();
        String pPhonetype=regbean.getPersonalPhoneType();
        String pphone=regbean.getCphone();
        System.out.println(phno+""+contact+""+pstreet+""+pcity+""+pstate+""+pcountry+""+ppin+""+pPhonetype+""+pphone);
       
        
        String newdate=DateWrapper.parseDate(new Date());
        try 
        {
        	System.out.println("photo="+photo);
        	File f=new File(photo);
        	FileInputStream fis=new FileInputStream(f); 
        	System.out.println("fole="+f.length());
           
            
        	con=getConnection();
        	System.out.println("In Change Profile"+con);
        	System.out.println(empid+""+firstname+""+lastname+""+middlename+""+dob+""+doj+""+gender+""+mstatus+""+qualification);
          // con.setAutoCommit(false);
        	System.out.println("First Step In Pro");
        	CallableStatement cs=con.prepareCall("{ call CHANGEPROFILE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
    		System.out.println("Next Step Goes On");
        	cs.setInt(1,empid);
        	cs.setString(2,firstname);
    		cs.setString(3,lastname);
    		cs.setString(4,middlename);
    		cs.setString(5,dob);
    		cs.setString(6,doj);
    		cs.setString(7,gender);
    		cs.setString(8,mstatus);
    		cs.setString(9,qualification);
    		 cs.setBinaryStream(10, null,0);
    		System.out.println("Before Home");
    		
    		
    		
    		
    		cs.setString(11,hno);
    		cs.setString(12,street);
    		cs.setString(13,city);
    		cs.setString(14,"India");
    		cs.setString(15,state);
    		cs.setString(16,country);
    		cs.setString(17,pin);
    		cs.setString(18,home);
    		System.out.println("After Home");
    		    		
    		cs.setString(19,ohno);
    		cs.setString(20,ostreet);
    		cs.setString(21,ocity);
    		cs.setString(22,"India");
    		cs.setString(23,ostate);
    		cs.setString(24,ocountry);
    		cs.setString(25,opin);
    		cs.setString(26,office);
    		System.out.println("After Office");
    		
    		cs.setString(27,phno);
    		cs.setString(28,pstreet);
    		cs.setString(29,pcity);
    		cs.setString(30,"India");
    		cs.setString(31,pstate);
    		
    		cs.setString(32,pcountry);
    		cs.setString(33,ppin);
    		cs.setString(34,contact);
    		System.out.println("After Personal");
    		
    		cs.setString(35,Phonetype);
    		cs.setString(36,phone);
    		cs.setString(37,oPhonetype);
    		cs.setString(38,ophone);
    		cs.setString(39,pPhonetype);
    		cs.setString(40,pphone);
    		
    		System.out.println("Before");
    		
    		boolean flag=cs.execute();
    		System.out.println(flag);
    		System.out.println("After");
    		
    		
    		if(flag){
    			
    	     flag=true;
    	     System.out.println("Updated");
    		}
  
           
            else
            {
                flag=false;
            
            }
            con.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException sex) 
            {
                sex.printStackTrace();
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
        return flag;
    }
   //getreport fromdate todate
    public CoreHash getReportFromTo(String sdate,String edate)
	{
		
		Properties p=getProperties();
		String pattern="";
		if(p.getProperty("dbname").equals("access"))
			pattern="#";
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println(" aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement st;
		Profile aProfile=null;
		try {
			 con = getConnection();
			   
            	 st=con.createStatement();
            	 ResultSet rs=st.executeQuery("SELECT DISTINCT(UD.LOGINID ),UD.FIRSTNAME,UD.LASTNAME,UD.DOB,UD.DOR,UD.EMAILID FROM USERDETAILS UD,LOGINMASTER LM WHERE UD.USERID=LM.USERID AND TO_CHAR(LOGINDATE,'DD-MM-YYYY')>='"+sdate+"' AND TO_CHAR(LOGINDATE,'DD-MM-YYYY')<='"+edate+"'");
            	 while(rs.next())
                 {
              	   aProfile=new Profile();
              	  
              	   aProfile.setLoginID(rs.getString(1));
              	   aProfile.setFirstname(rs.getString(2));  
              	   aProfile.setLastName(rs.getString(3));
              	   String date=DateWrapper.parseDate(rs.getDate(4)).trim();
                	aProfile.setBirthDate(date);
                   aProfile.setRegDate(DateWrapper.parseDate(rs.getDate(5)).trim());
                   aProfile.setEmail(rs.getString(6));
                   	
               	   
              	 aCoreHash.put(new Integer(sno),aProfile);
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
    //presentloginuser getting
    
    public CoreHash getReportPresent()
	{
		
		
		CoreHash aCoreHash = new CoreHash();
		aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		CallableStatement cstmt;
		Profile aProfile=null;
		try {
			 con = getConnection();
			   
			
            	 cstmt=con.prepareCall("{call REF_CURSOR_TEST.GET_ACCOUNTS_PROCEDURE(?)}");
            	 cstmt.registerOutParameter(1,OracleTypes.CURSOR);
            	 cstmt.executeUpdate();
            	 ResultSet rs=((OracleCallableStatement)cstmt).getCursor(1);
            	  while(rs.next())
                 {
              	   aProfile=new Profile();
              	   
              	   aProfile.setLoginID(rs.getString(1));
              	   aProfile.setFirstname(rs.getString(2));  
              	   aProfile.setLastName(rs.getString(3));
              	   String date=DateWrapper.parseDate(rs.getDate(4)).trim();
                	aProfile.setBirthDate(date);
                   aProfile.setRegDate(DateWrapper.parseDate(rs.getDate(5)).trim());
                   aProfile.setEmail(rs.getString(6));
                   	
               	   
              	 aCoreHash.put(new Integer(sno),aProfile);
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
    
    
    public boolean changeAccountStatus(String loginid,int status)
    {
        try 
        {
        	con=getConnection();
            con.setAutoCommit(false);
            PreparedStatement cstmt=con.prepareStatement("UPDATE logindetails SET loginstatus=? WHERE loginid=?");
            
            cstmt.setInt(1,status);
            cstmt.setString(2,loginid);
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
            con.close();
        } 
        catch (SQLException ex) 
        {
        	LoggerManager.writeLogSevere(ex);
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException se) 
            {
            	LoggerManager.writeLogSevere(se);
            }
        }
        catch (Exception e) 
        {
        	LoggerManager.writeLogSevere(e);
            flag=false;
            try 
            {
                con.rollback();
            } 
            catch (SQLException se) 
            {
            	LoggerManager.writeLogSevere(se);
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
		Profile aProfile=null;
		try {
			 con = getConnection();
			   
			
            	 cstmt=con.createStatement();
            	 //cstmt.registerOutParameter(1,OracleTypes.CURSOR);
            	 
            	 //ResultSet rs=((OracleCallableStatement)cstmt).getCursor(1);
            	 ResultSet rs=cstmt.executeQuery("select qualid,QUALFULLNAME from qualificationmaster");
            	 while(rs.next())
                 {
              	   aProfile=new Profile();
              	   System.out.println("In GetManager"+rs.getInt(1)+rs.getString(2));
              	   aProfile.setQualId(rs.getInt(1));
              	   aProfile.setQualName(rs.getString(2));  
              	   
               	   
              	 aCoreHash.put(new Integer(sno),aProfile);
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
    public Profile getMinMax(String desigid){
    	CoreHash aCoreHash=new CoreHash();
    	aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement cstmt;
		Profile aProfile=null;
		try {
			 con = getConnection();
			   
			
            	 cstmt=con.createStatement();
            	 //cstmt.registerOutParameter(1,OracleTypes.CURSOR);
            	 int no=Integer.parseInt(desigid);
            	 //ResultSet rs=((OracleCallableStatement)cstmt).getCursor(1);
            	 ResultSet rs=cstmt.executeQuery("select  MINIMUMSALARYRANGE,MAXIMUMSALARYRANGE from designationmaster where designationid='"+no+"'");
            	 while(rs.next())
                 {
              	   aProfile=new Profile();
              	   System.out.println("In GetMinMax"+rs.getInt(1)+rs.getInt(2));
              	   aProfile.setMin(rs.getInt(1));
              	   aProfile.setMax(rs.getInt(2));  
              	   
              	   //aProfile.setLastName(rs.getString(3));
              	   //String date=DateWrapper.parseDate(rs.getDate(4)).trim();
                	//aProfile.setBirthDate(date);
                   //aProfile.setRegDate(DateWrapper.parseDate(rs.getDate(5)).trim());
                   //aProfile.setEmail(rs.getString(6));
                   	
               	   
              	 aCoreHash.put(new Integer(sno),aProfile);
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
		return aProfile;
    }
    public CoreHash getDeptNames(){
    	CoreHash aCoreHash=new CoreHash();
    	aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement cstmt;
		Profile aProfile=null;
		try {
			 con = getConnection();
			   
			
            	 cstmt=con.createStatement();
            	 
            	// ResultSet rs=cstmt.executeQuery("select departmentid,initcap(deptname) from departmentmaster where deptname not like upper('administration')");
            	ResultSet rs=cstmt.executeQuery("select departmentid,initcap(deptname) from departmentmaster ");
            	 while(rs.next())
                 {
              	   aProfile=new Profile();
              	   aProfile.setDeptId(rs.getInt(1));
              	   aProfile.setDeptName(rs.getString(2));  
              	   
                   	
               	   
              	 aCoreHash.put(new Integer(sno),aProfile);
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
		Profile aProfile=null;
		try {
			 con = getConnection();
			   System.out.println("con"+con);
			
            	 cstmt=con.createStatement();
            	 System.out.println("cstmt"+cstmt);
            	 
            	// ResultSet rs=cstmt.executeQuery("select designationid,initcap(designationname) from designationmaster where designationname not like upper('President')");
            	 ResultSet rs=cstmt.executeQuery("select designationid,initcap(designationname) from designationmaster");
            	 while(rs.next())
                 {
              	   aProfile=new Profile();
              	   aProfile.setDesigId(rs.getInt(1));
              	   aProfile.setDesigName(rs.getString(2));  
              	   
               	   
              	 aCoreHash.put(new Integer(sno),aProfile);
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
		Profile aProfile=null;
		try {
			 con = getConnection();
			   System.out.println("con"+con);
			
            	 cstmt=con.createStatement();
            	 System.out.println("cstmt"+cstmt);
            	 //cstmt.registerOutParameter(1,OracleTypes.CURSOR);
            	 
            	 //ResultSet rs=((OracleCallableStatement)cstmt).getCursor(1);
            	 //ResultSet rs=cstmt.executeQuery("select employeeid,empfirstname from employeesmaster where empmanagerid=1001 ");
            	 ResultSet rs=cstmt.executeQuery("select empid,empfstname from employeesmaster");
            	 while(rs.next())
                 {
              	   aProfile=new Profile();
              	   System.out.println("In Manger");
              	   System.out.println(rs.getInt(1)+""+rs.getString(2));
              	   aProfile.setManagerid(rs.getInt(1));
              	   aProfile.setManager(rs.getString(2));  
              	                 	   
              	 aCoreHash.put(new Integer(sno),aProfile);
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
    public CoreHash getCurrentDept(){
    	CoreHash aCoreHash=new CoreHash();
    	aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		Statement cstmt;
		Profile aProfile=null;
		try {
			 con = getConnection();
			   System.out.println("con"+con);
			
            	 cstmt=con.createStatement();
            	 System.out.println("cstmt"+cstmt);
            	 //cstmt.registerOutParameter(1,OracleTypes.CURSOR);
            	 
            	 //ResultSet rs=((OracleCallableStatement)cstmt).getCursor(1);
            	 ResultSet rs=cstmt.executeQuery("select employeeid,empfirstname from employeesmaster where empmanagerid=1001 ");
            	 while(rs.next())
                 {
              	   aProfile=new Profile();
              	   System.out.println("In Manger");
              	   System.out.println(rs.getInt(1)+""+rs.getString(2));
              	   aProfile.setManagerid(rs.getInt(1));
              	   aProfile.setManager(rs.getString(2));  
              	                 	   
              	 aCoreHash.put(new Integer(sno),aProfile);
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
    public CoreHash getListOfEmployee(){
    	CoreHash aCoreHash=new CoreHash();
    	aCoreHash.clear();
		System.out.println("aCoreHash--"+aCoreHash.isEmpty());
		int sno=1;
		CallableStatement cstmt;
		Profile aProfile=null;
		try {
			 con = getConnection();
			   System.out.println("con"+con);
			
            	 cstmt=con.prepareCall("{ call CURSOR_TEST. GET_COLLEGES_PROCEDURE(?)}");
            	 System.out.println("cstmt"+cstmt);
            	 cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            	 //cstmt.registerOutParameter(1,OracleTypes.CURSOR);
            	 cstmt.executeUpdate();
            	 //ResultSet rs=((OracleCallableStatement)cstmt).getCursor(1);
            	 ResultSet rs = ((OracleCallableStatement)cstmt).getCursor(1);

            	 while(rs.next())
                 {
              	   aProfile=new Profile();
              	   //System.out.println("In Manger");
              	   //System.out.println(rs.getInt(1)+""+rs.getString(2));
              	   aProfile.setDesigName(rs.getString(1));
              	   aProfile.setDeptName(rs.getString(2));  
              	   aProfile.setDateOfJoin(rs.getString(3));
              	   aProfile.setEmpid(rs.getInt(4));
              	   aProfile.setGender(rs.getString(5));
              	   System.out.println("------------------");
              	   //aProfile.setLastName(rs.getString(3));
              	   //String date=DateWrapper.parseDate(rs.getDate(4)).trim();
                	//aProfile.setBirthDate(date);
                   //aProfile.setRegDate(DateWrapper.parseDate(rs.getDate(5)).trim());
                   //aProfile.setEmail(rs.getString(6));
                   	
               	   
              	 aCoreHash.put(new Integer(sno),aProfile);
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

public Profile getDeptCurrent(String empid){
	CoreHash aCoreHash=new CoreHash();
	aCoreHash.clear();
	System.out.println("aCoreHash--"+aCoreHash.isEmpty());
	int sno=1;
	CallableStatement cstmt;
	Profile aProfile=null;
	try {
		 con = getConnection();
		   System.out.println("con"+con);
		   aProfile=new Profile();
		     int empidnum=Integer.parseInt(empid);
        	 cstmt=con.prepareCall(" {?=call CHEK_EMP_DEPT_DETAILS1(?)}");
        	 System.out.println(empidnum);
        	 System.out.println("cstmt"+cstmt);
        	 cstmt.registerOutParameter(1,Types.VARCHAR);
        	 cstmt.setInt(2,empidnum);
        	 
        	       	 System.out.println("Now");
        	 cstmt.execute();
        	 System.out.println("Before");
        	 
        	 aProfile.setDeptName(cstmt.getString(1));
        	 System.out.println(aProfile.getDeptName());
        	System.out.println(cstmt.getString(1));
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
	return aProfile;
}

public Profile getDesigCurrent(String empid){
	CoreHash aCoreHash=new CoreHash();
	aCoreHash.clear();
	System.out.println("aCoreHash--"+aCoreHash.isEmpty());
	int sno=1;
	CallableStatement cstmt;
	Profile aProfile=null;
	try {
		 con = getConnection();
		   System.out.println("con"+con);
		   aProfile=new Profile();
		     int empidnum=Integer.parseInt(empid);
        	 cstmt=con.prepareCall(" {?=call CHEK_EMP_DESG_DETAILSFUN(?)}");
        	 System.out.println(empidnum);
        	 System.out.println("cstmt"+cstmt);
        	 cstmt.registerOutParameter(1,Types.VARCHAR);
        	 cstmt.setInt(2,empidnum);
        	 
        	       	 System.out.println("Now");
        	 cstmt.execute();
        	 System.out.println("Before");
        	 
        	 aProfile.setDesigName(cstmt.getString(1));
        	 System.out.println(aProfile.getDesigName());
        	System.out.println(cstmt.getString(1));
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
	return aProfile;
}
public Profile getQualCurrent(String empid){
	CoreHash aCoreHash=new CoreHash();
	aCoreHash.clear();
	System.out.println("aCoreHash--"+aCoreHash.isEmpty());
	int sno=1;
	CallableStatement cstmt;
	Profile aProfile=null;
	try {
		 con = getConnection();
		   System.out.println("con"+con);
		   aProfile=new Profile();
		     int empidnum=Integer.parseInt(empid);
        	 cstmt=con.prepareCall(" {?=call CHEK_EMP_QUAL_DETAILSFUN(?)}");
        	 System.out.println(empidnum);
        	 System.out.println("cstmt"+cstmt);
        	 cstmt.registerOutParameter(1,Types.VARCHAR);
        	 cstmt.setInt(2,empidnum);
        	 
        	       	 System.out.println("Now");
        	 cstmt.execute();
        	 System.out.println("Before");
        	 
        	 aProfile.setQualName(cstmt.getString(1));
        	 System.out.println(aProfile.getQualName());
        	System.out.println(cstmt.getString(1));
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
	return aProfile;
}

public boolean addquestion(Profile pmodel)
{
	
    String question=pmodel.getSecretqans();
    
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
	Profile aProfile=null;
	try {
		 con = getConnection();
		   System.out.println("con"+con);
		   String sql="select *from questionmaster";
		st=con.createStatement();
		
        rs=st.executeQuery(sql);	

        	 while(rs.next())
             {
          	   aProfile=new Profile();
          	  
          	   aProfile.setSecretqid(rs.getString(1));
          	   aProfile.setSecretqans(rs.getString(2));  
          	  
              
          	 aCoreHash.put(new Integer(sno),aProfile);
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