
<%@page import="com.dts.core.util.CoreHash"%>
<%@page import="com.dts.dae.dao.ProfileDAO"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.dts.dae.model.Profile"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<TITLE> Hungry Hyderabad.com</TITLE>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="css/mm_lodging1.css" type="text/css" />
<link rel="stylesheet" href="css/bannerstyles.css" type="text/css" />
<link rel="stylesheet" href="css/formstyles.css" type="text/css" />
<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
<script language="JavaScript1.1" src="scripts/pass.js">


</script> <script type="text/javascript" src="scripts/image.js"> </script>
 <script type="text/javascript" src="scripts/general.js"> </script>
 <script type="text/javascript" src="scripts/adi.js"> </script>
 <script type="text/javascript" src="scripts/form_validation.js"> </script>
 <script>
 function inDate(){

  var date=new Date();
  document.register.doj.value=date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getYear();
  document.getElementById('exprId').innerHTML=0;
}
function offDate(){

var day=document.forms.register.elements("day");
var dayvalue=day.options[day.selectedIndex].value;
var month=document.forms.register.elements("month");
var monthvalue=month.options[month.selectedIndex].value;
var year=document.forms.register.elements("year");
var yearvalue=year.options[year.selectedIndex].value;

 var append1=dayvalue+"-"+monthvalue+"-"+yearvalue;

 var append=append1.split("-");

born = new Date(bD[2], bD[1]*1-1, bD[0]);
years = Math.floor((now.getTime() - born.getTime()) / (365.25 * 24 * 60 * 60 * 1000));

 if(years>21){
 document.register.doj.value=date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getYear();;
}
 else{
   document.register.doj.value="";
   alert('Date Of Join Must Be Greater Then 21');
   
 }
<%--  var date=new Date();--%>
<%--  var checkdate=date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getYear();--%>
<%--      bD=checkdate.split("-");--%>
<%--      --%>
<%--      born = new Date(bD[2], bD[1]*1-1, bD[0]);--%>
<%--	  years = Math.floor((date.getTime() - born.getTime()) / (365.25 * 24 * 60 * 60 * 1000));--%>
<%--  if(years>21){--%>
<%--  document.register.doj.value=date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getYear();--%>
<%--  document.getElementById('exprId').innerHTML=0;--%>
<%--  }--%>
<%--  else{--%>
<%--  alert ('Date Of Join Must Be Greater Than 21');--%>
<%--  }--%>
}

function calAgeTo(){

  var day=document.forms.register.elements("day");
var dayvalue=day.options[day.selectedIndex].value;
var month=document.forms.register.elements("month");
var monthvalue=month.options[month.selectedIndex].value;
var year=document.forms.register.elements("year");
var yearvalue=year.options[year.selectedIndex].value;

 var append=dayvalue+"-"+monthvalue+"-"+yearvalue;

 
 now = new Date()
 bD = append.split('-');

 if(bD.length!=3){
   alert('Date Is Not Valid'); 
  document.getElementById('AgeId').innerHTML="";
  
 }
 else if(bD.length==3){
	 	born = new Date(bD[2], bD[1]*1-1, bD[0]);
	  years = Math.floor((now.getTime() - born.getTime()) / (365.25 * 24 * 60 * 60 * 1000));
    
   document.getElementById('AgeId').innerHTML=years; 
 }
}
function DOBcalc() {

<%--if(!register.doj.value==""){--%>
<%--  var DOjmdy = (register.doj.value).split('-'); --%>
<%--  Bjdate = new Date(DOjmdy[2],DOjmdy[0]-1,DOjmdy[1]); --%>
<%--  var bb=Bjdate.getFullYear();--%>
<%--  var DOBmdy = (register.dobirth.value).split('-'); --%>
<%--  --%>
<%--  Bdate = new Date(DOBmdy[2],DOBmdy[0]-1,DOBmdy[1]); --%>
<%--  var bDate=Bdate.getFullYear();--%>
<%--   var AgeValue=21;--%>
<%--    var Final=bb-AgeValue;--%>
<%--    if(Final>=bDate){}--%>
<%--	else{--%>
<%--  alert('Check The Joining Date Plz\n Must Be Greater Than ');--%>
<%--  --%>
<%--  }--%>
<%--  	}--%>
var date=new Date();
register.doj.value=date;

}
function disEnable(){
  register.hQual.disabled=false;
}
 </script>
 
 
 
 <script>
function validateDate()
{
var day = document.register.day.value;
var month = document.register.month.value;
var year = document.register.year.value;
var dob=day+"-"+month+"-"+year;

	var pinit = document.register.dob.value;
	var pinitArry = pinit.split("-");
	var pinit2=new Date();
	pinit2.setFullYear( pinitArry [2], pinitArry [1]-1, pinitArry [0] );
		
	var pfinal = document.register.doj.value;	
	var pfinalArray = pfinal.split("-");
	var pfinal2=new Date();
	pfinal2.setFullYear( pfinalArray [2], pfinalArray [1]-1, pfinalArray [0] );
	
		
	var inputDate =  document.register.dob.value;
	var inputDateArray = inputDate.split("-");
	var inputDate2 = new Date();
	inputDate2.setFullYear( inputDateArray[2], inputDateArray[1]-1, inputDateArray[0] );
	var today = new Date();
		
	if(inputDate2>pfinal2)
	{
		alert("greate than project end date");
		return false;
	}
	if(inputDate2<pinit2)
	{
		alert("Module should not be below to Project begin date");
		return false;
	}
	if(inputDate2<today)
	{
		alert("Project INITIATING Date cann't be earlier to today")
		return false;
	}
	else
	{
		var endDate =  document.register.doj.value;
		var endDateArray = endDate.split("-");
		var finalDate = new Date();
		finalDate.setFullYear( endDateArray[2], endDateArray[1]-1, endDateArray[0] );
		if(finalDate<inputDate2)
		{
			alert("Project Final Date cann't be earlier to Initiated Date")
			return false;
		}
		if(finalDate>pfinal2)
		{
			alert("Module End Date should be below to project enddate");
			return false
		}
		
	
	}
	
	
}
</script>
 
</head>
<body bgcolor="#999966">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
	<tr>
	<td height="139" colspan="6" align="left" valign="top" nowrap="nowrap"><img src="images/mm_spacer.gif" alt="" width="15" height="1" border="0" /><br />
	  <table width="100%" border="0">
        <tr>
          <td bgcolor="#0F615D"><img src="images/Distributed Payroll System.jpg" alt="ds" width="800" height="139" /></td>
        </tr>
      </table></td>
	</tr>

	<tr bgcolor="#ffffff">
	<td><img src="images/mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
	</tr>

	<tr bgcolor="#a4c2c2">
	<td height="36" nowrap="nowrap" bgcolor="#16B3AA"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="17%">&nbsp;</td>
        <td width="72%"><table width="100%" border="0" cellspacing="5" cellpadding="5">
          <tr>
            <td bgcolor="#16B3AA" class="navText" id="navigation">
            <tr bgcolor="#a4c2c2">	
	<td height="36" colspan="6" class="navText style1" id="navigation">	
	
	 <% String role=(String)session.getAttribute("role"); 
	if(role!=null){
	if(role.equalsIgnoreCase("admin")){
	 %>
	<jsp:include page="AdminOptions.html"/>
	<%}else if(role.equalsIgnoreCase("employee")){ %>
	
	<jsp:include page="EmployeeOptions.jsp"/>
	
	<%}else if(role.equalsIgnoreCase("customer")){ %>
	
	<jsp:include page="CustomerOptions.jsp"/>
	<%}
	else { %>
	
	<!--<jsp:include page="LoginForm.jsp?status=session expired login again...."/>	
	--><jsp:include page="LoginForm.jsp"></jsp:include>	
	<%} }else{
					response.sendRedirect("LoginForm.jsp?status=session expired login again...." );
			}	
	 %>
	 			</td>	
	</tr>
	
           
        </table></td>
        <td width="11%">&nbsp;</td>
      </tr>
    </table></td>
	</tr>

	<tr bgcolor="#ffffff">
	<td><img src="images/mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
	</tr>

	<tr bgcolor="#ffffff">
	  <td align="left" valign="top" bgcolor="#FFFFFF"><img src="images/mm_spacer.gif" alt="" width="50" height="1" border="0" /><br />
	    <br />
	    <table width="100%" border="0" cellspacing="5" cellpadding="5">
          <tr>
            <td width="9%">&nbsp;</td>
            <td width="82%">
            
            
            
            <form name="register" action="./RegisterAction" method="get"  >
            <table bgcolor="#16B3AA" align="left" width="100%">
              <tr>
                <th colspan="7" bgcolor="#FFFFCC"><span class="Title"><center>Employee Details</center></span></th>
              </tr>
              <tr></tr>
              <tr></tr>
              <tr><td><center>  <% if(request.getParameter("status")!=null)
					  {%>
                           <strong><font color=red><%=request.getParameter("status")%></font></strong>
                      <%}%></center></td></tr> 
              <tr>
                <td><pre><span class="Title">      First Name</span></pre></td>
                <td colspan="2"><input type="text" name="firstName" value="" size="20"/>
                    <span ><sup><font color="red"> *</font></sup></span> </td>
              </tr>
              <tr> </tr>
              <tr>
                <td><pre><span class="Title">      Last Name</span></pre></td>
                <td colspan="2"><input type="text" name="lastName" value="" size="20"/>
                    <span ><sup><font color="red"> *</font></sup></span> </td>
              </tr>
              <tr>
                <td><pre><span class="Title">      Middle Name</span></pre></td>
                <td colspan="2"><span ><sup><font color="red">
                  <input type="text" name="middleName"  value=""/>
                  *</font></sup></span></td>
              </tr>
              
              <tr>
                <td><pre><span class="Title">      DOB</span></pre></td>
                <td colspan="2"><select name="day"  >
                    <option selected="selected" value="00">DD</option>
                    <option  value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="30">30</option>
                    <option value="31">31</option>
                  </select>
                    <select name="month" >
                      <option selected="selected" value="00">MM</option>
                      <option  value="01">Jan</option>
                      <option value="02">Feb</option>
                      <option value="03">Mar</option>
                      <option value="04">Apr</option>
                      <option value="05">May</option>
                      <option value="06">Jun</option>
                      <option value="07">Jul</option>
                      <option value="08">Aug</option>
                      <option value="09">Sep</option>
                      <option value="10">Oct</option>
                      <option value="11">Nov</option>
                      <option value="12">Dec</option>
                    </select>
                    <select name="year"  >
                      <option selected="selected" value="0000">YYYY</option>
                      <option value="1901">1901</option>
                      <option value="1902">1902</option>
                      <option value="1903">1903</option>
                      <option value="1904">1904</option>
                      <option value="1905">1905</option>
                      <option value="1906">1906</option>
                      <option value="1907">1907</option>
                      <option value="1908">1908</option>
                      <option value="1909">1909</option>
                      <option value="1910">1910</option>
                      <option value="1911">1911</option>
                      <option value="1912">1912</option>
                      <option value="1913">1913</option>
                      <option value="1914">1914</option>
                      <option value="1915">1915</option>
                      <option value="1916">1916</option>
                      <option value="1917">1917</option>
                      <option value="1918">1918</option>
                      <option value="1919">1919</option>
                      <option value="1920">1920</option>
                      <option value="1921">1921</option>
                      <option value="1922">1922</option>
                      <option value="1923">1923</option>
                      <option value="1924">1924</option>
                      <option value="1925">1925</option>
                      <option value="1926">1926</option>
                      <option value="1927">1927</option>
                      <option value="1928">1928</option>
                      <option value="1929">1929</option>
                      <option value="1930">1930</option>
                      <option value="1931">1931</option>
                      <option value="1932">1932</option>
                      <option value="1933">1933</option>
                      <option value="1934">1934</option>
                      <option value="1935">1935</option>
                      <option value="1936">1936</option>
                      <option value="1937">1937</option>
                      <option value="1938">1938</option>
                      <option value="1939">1939</option>
                      <option value="1940">1940</option>
                      <option value="1941">1941</option>
                      <option value="1942">1942</option>
                      <option value="1943">1943</option>
                      <option value="1944">1944</option>
                      <option value="1945">1945</option>
                      <option value="1946">1946</option>
                      <option value="1947">1947</option>
                      <option value="1948">1948</option>
                      <option value="1949">1949</option>
                      <option value="1950">1950</option>
                      <option value="1951">1951</option>
                      <option value="1952">1952</option>
                      <option value="1953">1953</option>
                      <option value="1954">1954</option>
                      <option value="1955">1955</option>
                      <option value="1956">1956</option>
                      <option value="1957">1957</option>
                      <option value="1958">1958</option>
                      <option value="1959">1959</option>
                      <option value="1960">1960</option>
                      <option value="1961">1961</option>
                      <option value="1962">1962</option>
                      <option value="1963">1963</option>
                      <option value="1964">1964</option>
                      <option value="1965">1965</option>
                      <option value="1966">1966</option>
                      <option value="1967">1967</option>
                      <option value="1968">1968</option>
                      <option value="1969">1969</option>
                      <option value="1970">1970</option>
                      <option value="1971">1971</option>
                      <option value="1972">1972</option>
                      <option value="1973">1973</option>
                      <option value="1974">1974</option>
                      <option value="1975">1975</option>
                      <option value="1976">1976</option>
                      <option value="1977">1977</option>
                      <option value="1978">1978</option>
                      <option value="1979">1979</option>
                      <option value="1980">1980</option>
                      <option value="1981">1981</option>
                      <option value="1982">1982</option>
                      <option value="1983">1983</option>
                      <option value="1984">1984</option>
                      <option value="1985">1985</option>
                      <option value="1986">1986</option>
                      <option value="1987">1987</option>
                      <option value="1988">1988</option>
                      <option value="1989">1989</option>
                      <option value="1990">1990</option>
                      <option value="1991">1991</option>
                      <option value="1992">1992</option>
                      <option value="1993">1993</option>
                      <option value="1994">1994</option>
                      <option value="1995">1995</option>
                      <option value="1996">1996</option>
                      <option value="1997">1997</option>
                      <option value="1998">1998</option>
                      <option value="1999">1999</option>
                      <option value="2000">2000</option>
                      <option value="2001">2001</option>
                      <option value="2002">2002</option>
                      <option value="2003">2003</option>
                      <option value="2004">2004</option>
                      <option value="2005">2005</option>
                      <option value="2006">2006</option>
                      <option value="2007">2007</option>
                      <option value="2008">2008</option>
                    </select>
                    </td>
              </tr>
              <tr>
                <td><pre><span class="Title">      DOJ</span></pre></td>
                <td colspan="2"><input type="text" name="doj" value="" size="10" readonly="readonly" onfocus="inDate()" onblur="offDate()"/>

              </tr>
              
             
             
             <tr>
                <td align="left" valign="top"><pre><span class="Title">  Address</span></pre></td>
                <td width="33%" align="left" valign="top"><input type="text" name="address"   /></td>
               
              </tr>
             
             
              <tr>
                <td align="left" valign="top"><pre><span class="Title"> E-MailID</span></pre></td>
                <td width="33%" align="left" valign="top"><input type="text" name="emailid"   /></td>
               
              </tr>
             
             
              <tr>
                <td align="left" valign="top"><pre><span class="Title">  Salary</span></pre></td>
                <td width="33%" align="left" valign="top"><input type="text" name="salary"/></td>
               
              </tr>
             
              <tr>
                <td align="left" valign="top"><pre><span class="Title">   Photo</span></pre></td>
                <td width="33%" align="left" valign="top"><input type="file" name="browsePhoto"  /></td>
                
              </tr>
              
               
              
              
              <tr>
                <td><pre><span class="Title">  Designator</span></pre></td>
                <td colspan="2"><select name="designator">
                    <option  value="select">-SELECT ONE-</option>
                    <% CoreHash ch=new ProfileDAO().getDesigNames();
	             Enumeration em=ch.elements();
	             Profile p=null;
	             while(em.hasMoreElements()){
	                   p=(Profile)em.nextElement();
	                   System.out.println(p.getDesigName());
	                   
	                  %>
                    <option  value="<%=p.getDesigId()%>"><%=p.getDesigName()%></option>
                    <%} %>
                  </select>
                   </td>
              </tr>
              <tr>
                <td>Dept Name</td>
                <td colspan="2"><select name="deptname">
                    <option  value="select">-SELECT ONE-</option>
                    <% CoreHash ch1=new ProfileDAO().getDeptNames();
	             Enumeration em1=ch1.elements();
	            
	             Profile p1=null;
	             while(em1.hasMoreElements()){
	                   p1=(Profile)em1.nextElement();
	                     %>
                    <option  value="<%=p1.getDeptId()%>"><%=p1.getDeptName()%></option>
                    <%} %>
                  </select>
                  </td></tr>
                  <tr><td>
                  Manager</td><td>
                  <select name="manager">
                    <option  value="select">-Manager List-</option>
                    <% CoreHash ch2=new ProfileDAO().getManager();
	             Enumeration em2=ch2.elements();
	             Profile p2=null;
	             while(em2.hasMoreElements()){
	                   p2=(Profile)em2.nextElement();
	                   System.out.println(p2.getManager()+"In Manager");
	                   %>
                    <option  value="<%=p2.getManagerid()%>"><%=p2.getManager()%></option>
                    <%} %>
                  </select>                </td>
              </tr>
             
              <tr>
                <td><pre><span class="Title"> Gender</span></pre></td>
                <td colspan="2"><select name="gender" >
                    <option  value="select">-Select One-</option>
                    <option  value="male">Male</option>
                    <option  value="female">Female</option>
                  </select></td></tr>
                  
                  
                  <tr><td>
                 Martial Status</td><td>
                  <select name="mstatus">
                    <option  value="select">-Select One-</option>
                    <option  value="married">Married</option>
                    <option  value="notmarried">NotMarried</option>
                  </select>                </td>
              </tr>
              <tr>
                <td><pre><span class="Title">      Qualification</span></pre></td>
                <td colspan="2"><select name="hqualification" >
                    <option  value="select">-SELECT ONE-</option>
                    <% CoreHash ch3=new ProfileDAO().getQualification();
	             Enumeration em3=ch3.elements();
	             Profile p3=null;
	             while(em3.hasMoreElements()){
	                   p3=(Profile)em3.nextElement();
	                   
	                   %>
                    <option  value="<%=p3.getQualId()%>"><%=p3.getQualName()%></option>
                    <%} %>
                  </select>
                </td>
              </tr>
              
              
             
             
              <tr>
                <td><pre><span class="Title">  Question </span></pre></td>
                <td colspan="2"><select name="question" >
                    <option  value="select">-SELECT ONE-</option>
                    <% CoreHash ch5=new ProfileDAO().getquestionbase();
	             Enumeration em5=ch5.elements();
	             Profile p5=null;
	             while(em5.hasMoreElements()){
	                   p5=(Profile)em5.nextElement();
	                   
	                   %>
                    <option  value="<%=p5.getSecretqid()%>"><%=p5.getSecretqans()%></option>
                    <%} %>
                  </select>
                </td>
              </tr>
              
              
              
<tr>
  <td><pre><span class=Title> Answer</span></pre></td>
  <td><input type="text" name="answer" value="" size="20"/></td>
</tr>
              
              <tr></tr>
              
              <tr>
                <td align="center" colspan="6"><font size="3" face="Verdana">
                  <input type="submit" name="register" value="Register"  onclick='return validateDate();'/>
                  &nbsp;&nbsp;&nbsp;
                  <input type="reset" name="cancel" value="Cancel"/>
                </font></td>
              </tr>
              
          </table></form>            
            <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("register");
  
 
  frmvalidator.addValidation("firstName","req","Please enter your First Name");
  frmvalidator.addValidation("firstName","maxlen=20",	"Max length for FirstName is 20");
  frmvalidator.addValidation("firstName","alpha"," First Name Alphabetic chars only");
  
  frmvalidator.addValidation("middleName","req","Please enter your Middle Name");
  frmvalidator.addValidation("middleName","maxlen=20",	"Max length for Middle Name is 20");
  frmvalidator.addValidation("middleName","alpha"," Middle Name Alphabetic chars only");
  
  frmvalidator.addValidation("lastName","req","Please enter your Last Name");
  frmvalidator.addValidation("lastName","maxlen=20","Max length for Last Name is 20");
  frmvalidator.addValidation("lastName","alpha"," Last Name Alphabetic chars only");
  
  frmvalidator.addValidation("browsePhoto","req","Please Load Your Photo"); 
   
   frmvalidator.addValidation("day","dontselect=0");
   frmvalidator.addValidation("month","dontselect=0");
   frmvalidator.addValidation("year","dontselect=0");
   frmvalidator.addValidation("doj","req","Please enter your DOJ");
     frmvalidator.addValidation("gender","dontselect=0");
     frmvalidator.addValidation("designator","dontselect=0");
     frmvalidator.addValidation("deptName","dontselect=0");
     frmvalidator.addValidation("mStatus","dontselect=0");
     frmvalidator.addValidation("hQualification","dontselect=0");
     
   
   frmvalidator.addValidation("addressType","dontselect=0");
   
   frmvalidator.addValidation("houseNo","req","Please enter your House Number");
   
   frmvalidator.addValidation("street","req","Please enter your Street Number");
     frmvalidator.addValidation("phoneType","dontselect=0");
     frmvalidator.addValidation("phoneNo","req");
     
  
  
   
   frmvalidator.addValidation("city","req","Please enter your city Name");
   frmvalidator.addValidation("state","req","Please enter your State Name");
   frmvalidator.addValidation("country","req","Please enter your Country Name");
   frmvalidator.addValidation("pin","req","Please enter your pin Number");
   
  
   frmvalidator.addValidation("fax","req","Please enter Fax Number");
  
   
    
 </script>
          
            <td width="9%">&nbsp;</td>
        
        
        
       
    </tr>

	<tr bgcolor="#ffffff">
	<td>`</td>
	</tr>

	<tr>
	<td bgcolor="#0F615D">&nbsp;</td>
	</tr>
</table>
</body>
</html>
