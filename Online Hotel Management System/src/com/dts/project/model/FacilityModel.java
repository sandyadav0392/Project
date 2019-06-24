package com.dts.project.model;

public class FacilityModel {

private int facilid;
private String facilname;
private String facildtls;
private String stdate;
private String enddate;
private double aditionalchrg;
private int hotelid;
private String hotelname;
private String facilstatus;

public String getFacilstatus() {
	return facilstatus;
}
public void setFacilstatus(String facilstatus) {
	this.facilstatus = facilstatus;
}
public int getFacilid() {
	return facilid;
}
public void setFacilid(int facilid) {
	this.facilid = facilid;
}
public String getFacilname() {
	return facilname;
}
public void setFacilname(String facilname) {
	this.facilname = facilname;
}
public String getFacildtls() {
	return facildtls;
}
public void setFacildtls(String facildtls) {
	this.facildtls = facildtls;
}
public String getStdate() {
	return stdate;
}
public void setStdate(String stdate) {
	this.stdate = stdate;
}
public String getEnddate() {
	return enddate;
}
public void setEnddate(String enddate) {
	this.enddate = enddate;
}
public double getAditionalchrg() {
	return aditionalchrg;
}
public void setAditionalchrg(double aditionalchrg) {
	this.aditionalchrg = aditionalchrg;
}
public int getHotelid() {
	return hotelid;
}
public void setHotelid(int hotelid) {
	this.hotelid = hotelid;
}
public String getHotelname() {
	return hotelname;
}
public void setHotelname(String hotelname) {
	this.hotelname = hotelname;
}

}
