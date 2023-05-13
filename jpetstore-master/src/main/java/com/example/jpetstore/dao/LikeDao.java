package com.example.jpetstore.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.GroupItem;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Like;
import com.example.jpetstore.domain.Order;

public interface LikeDao {

	List<Item> getItemLikes(Map<String, Integer> params) throws DataAccessException;

	List<GroupItem> getGroupItemLikes(Map<String, Integer> params) throws DataAccessException;
	 
	void insertItemLike(Like like) throws DataAccessException;

	void insertGroupItemLike(Like like) throws DataAccessException;

	void removeItemLike(Map<String, Integer> params) throws DataAccessException;

	void removeGroupItemLike(Map<String, Integer> params) throws DataAccessException;
	
	List<Item> rankingItem() throws DataAccessException;
	
	List<GroupItem> rankingGroupItem() throws DataAccessException;
}
