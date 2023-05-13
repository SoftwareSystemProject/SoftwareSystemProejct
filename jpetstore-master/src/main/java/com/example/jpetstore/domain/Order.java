package com.example.jpetstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("serial")
public class Order implements Serializable {

  private int order_id;
  private String user_id;
  private int groupitem_id;
  private Date order_date;
  private String address1;
  private String address2;
  private String receiver_name;
  private String receiver_phone;
  private int total_count;
  private double total_price;
  private String ship_status;
  private List<LineItem> lineItems = new ArrayList<LineItem>();

  public int getOrder_id() {
	return order_id;
	}
  
  public void setOrder_id(int order_id) {
	this.order_id = order_id;
	}
  
  public String getUser_id() {
	return user_id;
	}
  
  public void setUser_id(String user_id) {
	this.user_id = user_id;
	}
  
  public Date getOrder_date() {
	return order_date;
	}
  
  public void setOrder_date(Date order_date) {
	this.order_date = order_date;
	}
  
  public String getAddress1() {
	return address1;
	}
  
  public void setAddress1(String address1) {
	this.address1 = address1;
	}
  
  public String getAddress2() {
	return address2;
	}
  
  public void setAddress2(String address2) {
	this.address2 = address2;
	}
  
  public String getReceiver_name() {
	return receiver_name;
	}
  
  public void setReceiver_name(String receiver_name) {
	this.receiver_name = receiver_name;
	}
  
  public String getReceiver_phone() {
	return receiver_phone;
	}
  
  public void setReceiver_phone(String receiver_phone) {
	this.receiver_phone = receiver_phone;
	}
  
  public int getTotal_count() {
	return total_count;
	}
  
  public void setTotal_count(int total_count) {
	this.total_count = total_count;
	}
  
  public double getTotal_price() {
	return total_price;
	}
  
  public void setTotal_price(double total_price) {
	this.total_price = total_price;
	}
  
  public String getShip_status() {
	return ship_status;
	}
  
  public void setShip_status(String ship_status) {
	this.ship_status = ship_status;
	}
  
  public void setLineItems(List<LineItem> lineItems) {
	  this.lineItems = lineItems; 
	  }
  
  public List<LineItem> getLineItems() { 
	  return lineItems; 
	  }

  public int getGroupitem_id() {
	return groupitem_id;
	}

  public void setGroupitem_id(int groupitem_id) {
	this.groupitem_id = groupitem_id;
	}

public void initOrder1(User user, GroupItem groupItem) {
	  //user_id = user.gettUser_id();
//	receiver_name = user.getUsername();
//	receiver_phone = user.getPhone();
//    address1 = user.getAddress1();
//    address2 = user.getAddress2();   
//	groupitem_id = groupItem.getItemId();
    total_price = groupItem.getListPrice();
    total_count = groupItem.getQuantity();
    ship_status = "P";
  }

  public void initOrder2(User user, Cart cart) {
	  //user_id = user.gettUser_id();
//	receiver_name = user.getUsername();
//	receiver_phone = user.getPhone();
	order_date = new Date(); 
//    address1 = user.getAddress1();
//    address2 = user.getAddress2();   
    total_price = cart.getSubTotal();
 
    int count=0;
    Iterator<CartItem> i = cart.getAllCartItems();
    while (i.hasNext()) {
    	count++;
      CartItem cartItem = (CartItem) i.next();
      addLineItem(cartItem);
    }
    
    total_count = count;
    ship_status = "P";
  }

  public void addLineItem(CartItem cartItem) {
    LineItem lineItem = new LineItem(lineItems.size() + 1, cartItem);
    addLineItem(lineItem);
  }

  public void addLineItem(LineItem lineItem) {
    lineItems.add(lineItem);
  }

@Override
public String toString() {
	return "Order [order_id=" + order_id + ", user_id=" + user_id + ", groupitem_id=" + groupitem_id + ", order_date="
			+ order_date + ", address1=" + address1 + ", address2=" + address2 + ", receiver_name=" + receiver_name
			+ ", receiver_phone=" + receiver_phone + ", total_count=" + total_count + ", total_price=" + total_price
			+ ", ship_status=" + ship_status + ", lineItems=" + lineItems + "]";
}
  
  
}