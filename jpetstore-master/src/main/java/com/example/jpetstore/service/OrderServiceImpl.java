package com.example.jpetstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpetstore.dao.OrderDao;
import com.example.jpetstore.dao.mybatis.MybatisOrderDao;
import com.example.jpetstore.domain.Order;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;


	public Order getOrder(int order_id) {
		return orderDao.getOrder(order_id);
	}

	public void insertOrder(Order order) {
		orderDao.insertOrder(order);
	}

	public int cancelOrder(int order_id) {
		return orderDao.cancelOrder(order_id);
	}

	public void modifyOrderInfo(String order_id) {
		orderDao.modifyOrderInfo(order_id);
	}

	public int userOrderTotal(String user_id) {
		return orderDao.userOrderTotal(user_id);
	}

	public List<Order> getOrdersByUserId(String user_id) {
		return orderDao.getOrdersByUserId(user_id);
	}

}
