package com.dts.project.model;

public class ItemModel {
	
	private int itemid;
	private String itemname;
	private String itemdesc;
	private String itemtypename;
	private double cost4unit;
	private double totalcost;
	private double discnt;
	private int quantity;
	private int custid;
	private String custname;
	private String ordrdate;
	private int hotelid;
	private String hotelname;
	
	private long cardnumber;
	private int pin;
	private String txdate;
	private String expdate;
	private int cvv2;
	
	
	
	
	public long getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(long cardnumber) {
		this.cardnumber = cardnumber;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getTxdate() {
		return txdate;
	}
	public void setTxdate(String txdate) {
		this.txdate = txdate;
	}
	public String getExpdate() {
		return expdate;
	}
	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}
	public int getCvv2() {
		return cvv2;
	}
	public void setCvv2(int cvv2) {
		this.cvv2 = cvv2;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getItemdesc() {
		return itemdesc;
	}
	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}
	public String getItemtypename() {
		return itemtypename;
	}
	public void setItemtypename(String itemtypename) {
		this.itemtypename = itemtypename;
	}
	public double getCost4unit() {
		return cost4unit;
	}
	public void setCost4unit(double cost4unit) {
		this.cost4unit = cost4unit;
	}
	public double getDiscnt() {
		return discnt;
	}
	public void setDiscnt(double discnt) {
		this.discnt = discnt;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getOrdrdate() {
		return ordrdate;
	}
	public void setOrdrdate(String ordrdate) {
		this.ordrdate = ordrdate;
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
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public double getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}
	

}
