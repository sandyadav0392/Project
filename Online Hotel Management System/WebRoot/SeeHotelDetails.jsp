
<%@page import="com.dts.project.dao.EmpRegistrationDAO"%>
<%@page import="com.dts.project.model.EmpModel"%>
<%@page import="com.dts.core.util.CoreHash"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.dts.project.dao.HotelDAO"%>
<%@page import="com.dts.project.model.HotelModel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0041)http://www.telemarketing.com/services.asp -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		
		<META name="description" content=""/>
		<META name="keywords" content=""/>
                <META name="robots" content=""/>
		<TITLE> Hungry Hyderabad.com</TITLE>
		<LINK rel="shortcut icon" type="image/x-icon" href="#"/>
		<LINK href="images/styles2.css" rel="stylesheet" type="text/css"/>
		<SCRIPT src="images/scripts.js" language="JavaScript" type="text/JavaScript"></SCRIPT>
		<!--BEGIN ROI TRACKING Code-->

<script language="JavaScript" src="scripts/gen_validatorv31.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="scripts/ts_picker.js"></script>
<script language="JavaScript1.1" src="scripts/pass.js">


</script> <script type="text/javascript" src="scripts/image.js"> </script>
 <script type="text/javascript" src="scripts/general.js"> </script>
 <script type="text/javascript" src="scripts/adi.js"> </script>
 <script type="text/javascript" src="scripts/form_validation.js"> </script>
 <script type="text/javascript">

function inDate(){

  var date=new Date();
  document.addcomputer.rDate.value=date.getDate()+"-"+(date.getMonth()+1)+"-"+date.getYear();
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
//var x_win = window.self; 

function goOn() {
var port=document.adduser.port.value;
var host=document.adduser.host.value;
var username=document.adduser.username.value;
window.location.href='http://'+host+':'+port+'/./ChekUserAction?username='+username;

} 
function trim(str){
while(str.chatAt(str.length-1)==" ")
str=str.substring(0,str.length-1);
while(str.chatAt(0)==" ")
str=str.substring(1,str.length);

return str;
}



  
  function checkUserName(){
  var temp = document.adduser;
  
 if ( temp.username.value.length <8 || temp.username.value.length >20) {
  alert(" a username should contain between 8 and 20 character");
       
        return false;
  } 
  return true;
  }
  
  
  function checkPass(){
  var temp = document.adduser;
   if (temp.password.value.length <5 || temp.password.value.length >15) {
  alert("a password should contain between 5  and  10 character");
    
    return false;
  } 
  return true;
   }
   
   
</script>



<script language=javascript>
function checkMailId(mailids)
{
var arr = new Array('.com','.net','.org','.biz','.coop','.info','.museum','.name','.pro'
,'.edu','.gov','.int','.mil','.ac','.ad','.ae','.af','.ag','.ai','.al',
'.am','.an','.ao','.aq','.ar','.as','.at','.au','.aw','.az','.ba','.bb',
'.bd','.be','.bf','.bg','.bh','.bi','.bj','.bm','.bn','.bo','.br','.bs',
'.bt','.bv','.bw','.by','.bz','.ca','.cc','.cd','.cf','.cg','.ch','.ci',
'.ck','.cl','.cm','.cn','.co','.cr','.cu','.cv','.cx','.cy','.cz','.de',
'.dj','.dk','.dm','.do','.dz','.ec','.ee','.eg','.eh','.er','.es','.et',
'.fi','.fj','.fk','.fm','.fo','.fr','.ga','.gd','.ge','.gf','.gg','.gh',
'.gi','.gl','.gm','.gn','.gp','.gq','.gr','.gs','.gt','.gu','.gv','.gy',
'.hk','.hm','.hn','.hr','.ht','.hu','.id','.ie','.il','.im','.in','.io',
'.iq','.ir','.is','.it','.je','.jm','.jo','.jp','.ke','.kg','.kh','.ki',
'.km','.kn','.kp','.kr','.kw','.ky','.kz','.la','.lb','.lc','.li','.lk',
'.lr','.ls','.lt','.lu','.lv','.ly','.ma','.mc','.md','.mg','.mh','.mk',
'.ml','.mm','.mn','.mo','.mp','.mq','.mr','.ms','.mt','.mu','.mv','.mw',
'.mx','.my','.mz','.na','.nc','.ne','.nf','.ng','.ni','.nl','.no','.np',
'.nr','.nu','.nz','.om','.pa','.pe','.pf','.pg','.ph','.pk','.pl','.pm',
'.pn','.pr','.ps','.pt','.pw','.py','.qa','.re','.ro','.rw','.ru','.sa',
'.sb','.sc','.sd','.se','.sg','.sh','.si','.sj','.sk','.sl','.sm','.sn',
'.so','.sr','.st','.sv','.sy','.sz','.tc','.td','.tf','.tg','.th','.tj',
'.tk','.tm','.tn','.to','.tp','.tr','.tt','.tv','.tw','.tz','.ua','.ug',
'.uk','.um','.us','.uy','.uz','.va','.vc','.ve','.vg','.vi','.vn','.vu',
'.ws','.wf','.ye','.yt','.yu','.za','.zm','.zw');

var mai = mailids;
var val = true;
var beforeat="";
var afterat="";
var afterat2="";

var dot=mai.lastIndexOf(".");
var con=mai.substring(dot, mai.length);
con=con.toLowerCase();
con=con.toString();

for(var i=0;i<(arr.length);i++)
{
	if(con == arr[i])
	{
		val=true;
		break;
	}
	else
	{
		val=false;
	}
}

var att=mai.lastIndexOf("@");
beforeat=mai.substring(0,att);
beforeat=beforeat.toLowerCase();
beforeat=beforeat.toString();
var asci1=beforeat.charCodeAt(0);

afterat=mai.substring(att+1, dot);
afterat=afterat.toLowerCase();
afterat=afterat.toString();

afterat2=mai.substring(att+1, mai.length);
afterat2=afterat2.toLowerCase();
afterat2=afterat2.toString();

if(beforeat=="" || afterat=="" || beforeat.length>30)
	val=false;

if(afterat2.length>64 || afterat.length<2)
	val=false;

if((afterat.charCodeAt(0))==45 || (afterat.charCodeAt(afterat.length-1))==45)
	val=false;

if(val==true)
{
	if(asci1 > 47 && asci1 < 58)
		val=false;
		
	if(asci1 < 48 || asci1 > 57)
	{
		for(var i=0; i<=beforeat.length-1; i++)
		{
			var asci2=beforeat.charCodeAt(i);
			if((asci2<=44 || asci2==47) || (asci2>=58 && asci2<=94) || (asci2==96) || (asci2>=123 && asci2<=127))
			{
				val=false;
				break;
			}
		}
		
		for(var j=0; j<=afterat.length-1; j++)
		{
			var asci3=afterat.charCodeAt(j);
			if((asci3<=44) || (asci3==46) || (asci3==47) || (asci3>=58 && asci3<=96) || (asci3>=123 && asci3<=127))
			{
				val=false;
				break;
			}
		}	
	}
}

if(val==false)
{
	alert("Your maild "+mai+" is not valid");
	return false;
}
else
{
	return true;
}
}
</script>
<script language = "Javascript">
/**
 * DHTML phone number validation script. Courtesy of SmartWebby.com (http://www.smartwebby.com/dhtml/)
 */

// Declaring required variables
var digits = "0123456789";
// non-digit characters which are allowed in phone numbers
var phoneNumberDelimiters = "()- ";
// characters which are allowed in international phone numbers
// (a leading + is OK)
var validWorldPhoneChars = phoneNumberDelimiters + "+";
// Minimum no of digits in an international phone no.
var minDigitsInIPhoneNumber = 10;

function isInteger(s)
{   var i;
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}
function trim(s)
{   var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not a whitespace, append to returnString.
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character isn't whitespace.
        var c = s.charAt(i);
        if (c != " ") returnString += c;
    }
    return returnString;
}
function stripCharsInBag(s, bag)
{   var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++)
    {   
        // Check that current character isn't whitespace.
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function checkInternationalPhone(strPhone){
var bracket=3
strPhone=trim(strPhone)
if(strPhone.indexOf("+")>1) return false
if(strPhone.indexOf("-")!=-1)bracket=bracket+1
if(strPhone.indexOf("(")!=-1 && strPhone.indexOf("(")>bracket)return false
var brchr=strPhone.indexOf("(")
if(strPhone.indexOf("(")!=-1 && strPhone.charAt(brchr+2)!=")")return false
if(strPhone.indexOf("(")==-1 && strPhone.indexOf(")")!=-1)return false
s=stripCharsInBag(strPhone,validWorldPhoneChars);
return (isInteger(s) && s.length >= minDigitsInIPhoneNumber);
}

function ValidatePnoneNumber(){
	var Phone=document.rigister.phno;
	
	if ((Phone.value==null)||(Phone.value=="")){
		alert("Please Enter your Phone Number")
		Phone.focus()
		return false
	}
	if (checkInternationalPhone(Phone.value)==false){
		alert("Please Enter a Valid Phone Number")
		Phone.value=""
		Phone.focus()
		return false
	}
	return true
 }
</script>

<SCRIPT language="javascript" src="images/track.asp"></SCRIPT>
<SCRIPT language="javascript">
<!--
if (typeof(ROIID) + '' != 'undefined')
{
 TrackEvent('LandingPage', 0);
}
//-->
</SCRIPT>
<!--END ROI TRACKING Code-->
<SCRIPT language="JavaScript" type="text/javascript">
<!-- Yahoo! Inc.
var ysm_accountid  = "1OGH0147L7RREN17UC00JA5NPI0";
document.write("<SCR" + "IPT language='JavaScript' type='text/javascript' " 
+ "SRC=//" + "srv1.wa.marketingsolutions.yahoo.com" + "/script/ScriptServlet" + "?aid=" + ysm_accountid 
+ "></SCR" + "IPT>");
// -->
</SCRIPT><SCRIPT language="JavaScript" type="text/javascript" src="images/ScriptServlet"></SCRIPT>

		<SCRIPT src="images/urchin.js" type="text/javascript">

		</SCRIPT>

		<SCRIPT type="text/javascript">

		_uacct = "UA-2950592-2";

		urchinTracker();

		</SCRIPT>	
		
		
		
		</HEAD>	
	
	<BODY onload="preloadImages();">
		<TABLE cellpadding="0" cellspacing="0" align="center">
			<TBODY><TR>
				<TD colspan="2" align="center">
<CSACTIONDICT>
	<SCRIPT type="text/javascript"><!--
var preloadFlag = false;
function preloadImages() {
	if (document.images) {
		pre_about_over = newImage('images/navbar/about_over.gif');
		pre_automated_over = newImage('images/navbar/automated_over.gif');
		pre_ebound_over = newImage('images/navbar/ebound_over.gif');
		pre_fulfillment_over = newImage('images/navbar/fulfillment_over.gif');
		pre_why_over = newImage('images/navbar/why_over.gif');
		pre_inbound_over = newImage('images/navbar/inbound_over.gif');
		pre_outbound_over = newImage('images/navbar/outbound_over.gif');
		preloadFlag = true;
	}
}

// --></SCRIPT>
</CSACTIONDICT>

				
				
				
				
				
					<DIV id="header">
	<IMG src="images/masthead2.jpg" alt="Telemarketing.com" width="1255" height="86" usemap="#masthead3856a44"><MAP name="masthead3856a44"><AREA shape="rect" coords="5,5,296,80" href="#" alt="Telemarketing.com"></MAP>

				<tr bgcolor="lightblue">	
	<td height="30" colspan="6" class="navText style1" id="navigation">	 

		<DIV id="navbar">	
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
	 					
</DIV>

</TD>
			</TR>
			<TR>
				<TD width="151" valign="top">
					<DIV id="navigation">
						<IMG src="images/services.jpg" width="151"></IMG>
						<IMG src="images/partner.jpg"><BR></BR>

					<A href="#" title="Call Centers" target="new"><IMG src="images/answernet_sm.jpg"></A><P>

				
					</P></DIV>
				</TD>
				<TD valign="top">
					<DIV id="content">				


<table>
<tbody>
 <table align="center" width="650" border="5">
<center> 
   <form name="seehoteldetails" action="./AddHotelAction" method="">     
<table align="center" WIDTH="650" border="0" bordercolor="black" bgcolor="#F4F5F7">
      <th colspan="15" bgcolor="lightgreen"><center><b><font color="white">HOTEL  DETAILS</font></center></th>
      <tr rowspan="4"></tr>
          
       <tr><td><span class=Title>
    <%if(request.getParameter("status")!=null)out.print(request.getParameter("status"));    %> </span> 
    </td></tr>
       
       
                
                <%
                 HotelModel  em=null;
                String images=getServletContext().getRealPath("/userimages");
                int hid=Integer.parseInt(request.getParameter("hid").trim());
                String loginname=(String)session.getAttribute("user"); 

       try{
      
       em=new HotelDAO().getEachHotelDetails(hid);
         
          
         %> 
                  
        <tr>
    <input type="hidden" name="hhid" value="<%=em.getHotelid()%>"/>
     <td>Hotel Name </td>
    <td><input type="text"  name="hname"  value="<%=em.getHotelname()%>" readonly /></td>
     </tr>
     
      <tr>
    <td>Plot No</td>
    <td><input type="text" name="hpltno" value="<%=em.getHotelpltno()%>"  /></td>
    </tr>
          
      <tr>
    <td>Street</td>
    <td><input type="text" name="street" value="<%=em.getHtlstreet()%>" /></td>
    </tr>
     
     <tr>
    <td>City</td>
    <td><input type="text" name="city" value="<%=em.getHotelcity()%>"/></td>
    </tr>
   <tr>
    <td>State</td>
    <td><input type="text" name="state" value="<%=em.getHotelstate()%>"/></td>
    </tr>
    
    
     <tr>
    <td>Start Date</td>
    <td><input type="text" name="stdate"  readonly value="<%=em.getHotelstdate()%>"/></td>
    </tr>
    
    
     <tr>
    <td>Pin</td>
    <td><input type="text" name="pin" value="<%=em.getHotelpin()%>"/></td>
    </tr>
    
<%--   --%>
<%--       <tr><input type="hidden" name="inchrgid" value="<%=em.getInchrgid()%>"  />--%>
<%--    <td>Incharge</td>--%>
<%--    <td><input type="text" name="inchargename" value="<%=em.getInchrgname()%>"/></td>--%>
<%--    </tr> --%>
<%--    --%>
    
     <tr>
     
    <td>Employee Incharge</td>
    <td><select  name="inchrgid">
<%--<option value="select">-Select-</option>--%>
<% 
CoreHash ch2=new EmpRegistrationDAO().getAllInchargeName();
	             Enumeration em2=ch2.elements();
	            
	             EmpModel p2=null;
	             while(em2.hasMoreElements()){
	                   p2=(EmpModel)em2.nextElement();
	                     if(em.getInchrgid()==p2.getEmpinchargid()){
	                   %>
                    <option selected value="<%=em.getInchrgid()%>"><%=em.getInchrgname()%></option>
                    <%} else %>
                   <option  value="<%=p2.getEmpinchargid()%>"><%=p2.getEmpinchargname()%></option> 
                   <% }%>
</select>
    </td>
    </tr>    
        
    
     <tr>
    <td>Mail-ID</td>
    <td><input type="text" name="mailid" value="<%=em.getHotelmailid()%>"/></td>
    </tr>
    
    
     <tr>
    <td>Contact No</td>
    <td><input type="text" name="contactno" value="<%=em.getContactno()%>"/></td>
    </tr>
    
    <%}catch(Exception e)
{e.printStackTrace();}%> 
        
        
         <tr rowspan="1"></tr><tr rowspan="1"></tr><tr rowspan="1"></tr><tr rowspan="1"></tr>
      <tr><td colspan="2"><center>
  <%if(role.equalsIgnoreCase("Admin")){ %>
      <input type="submit" name="submit" value="Update Hotel Details"/>
<%--      <input type="submit" name="submit" value="Delete"/>     --%>
          
      <%}else{ %>      
     <input type="button" name="Submit" value="Back" onclick="javascript:history.back(-1)"/>
<%} %>
     
     
      

</center></td></tr>
      </table>
</form> 
  </center>
   </table>
</tbody>

</TABLE>
		</DIV>
				</TD>
			</TR>
			<TR>
				<TD colspan="3" style="vertical-align: bottom" align="center" WIDTH="650">
					<DIV id="footerBorder">&nbsp;<DIV id="footer">«»<SPAN id="copyright">©2007-2009 AnswerNet</SPAN> «» <A href="#">Contact Us</A> <BR></BR>
					Visit AnswerNet  <A href="#" title="Call Centers">Call Centers</A> for Customized <A href="#" title="Call Center Services">Call Center Services</A> and <A href="#" title="Answering Services">Answering Services</A></DIV>
					</DIV>


				</TD>
			</TR>
		</TBODY>
		</TABLE>
	

</BODY></HTML>