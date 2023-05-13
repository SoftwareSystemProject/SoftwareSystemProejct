package com.example.jpetstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpetstore.dao.OrderDao;
import com.example.jpetstore.dao.SequenceDao;
import com.example.jpetstore.dao.mybatis.mapper.LineItemMapper;
import com.example.jpetstore.dao.mybatis.mapper.OrderMapper;
import com.example.jpetstore.domain.LineItem;
import com.example.jpetstore.domain.Order;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisOrderDao implements OrderDao {
	
	@Autowired
	protected OrderMapper orderMapper;

	public List<Order> getOrdersByUserId(String user_id) 
			throws DataAccessException {
		List<Order> orderList = orderMapper.getOrdersByUserId(user_id);
		if (orderList.size() == 0) {	
			return null;
		} else {
			return orderList;
		}
	}
	
	@Transactional
	public Order getOrder(int order_id) throws DataAccessException {
		Order order = orderMapper.getOrder(order_id);
	    return order;
	}
	
	//공동구매상품 바로 주문하기
	@Transactional
	public void insertOrder(Order order) throws DataAccessException {  
    	orderMapper.insertOrder(order);
	}
	
	//카트->주문하기
	
	
	@Transactional
	public int cancelOrder(int order_id) throws DataAccessException { 
		return orderMapper.cancelOrder(order_id);
	}
	
	@Transactional
	public void modifyOrderInfo(String order_id) {
		orderMapper.modifyOrderInfo(order_id);
	}

	@Transactional
	public int userOrderTotal(String user_id) {
		return orderMapper.userOrderTotal(user_id);
	}


	
}