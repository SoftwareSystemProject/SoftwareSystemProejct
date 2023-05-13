package com.example.jpetstore.dao;

import java.util.List;

import javax.activation.CommandMap;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Order;

public interface OrderDao {

  List<Order> getOrdersByUserId(String user_id) throws DataAccessException;

  Order getOrder(int order_id) throws DataAccessException;

  void insertOrder(Order order) throws DataAccessException;

  int cancelOrder(int order_id) throws DataAccessException;
  
  void modifyOrderInfo(String order_id) throws DataAccessException;
  
  int userOrderTotal(String user_id) throws DataAccessException;
}
