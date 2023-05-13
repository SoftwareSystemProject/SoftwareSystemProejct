package com.example.jpetstore.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.LikeDao;
import com.example.jpetstore.dao.mybatis.mapper.LikeMapper;
import com.example.jpetstore.domain.GroupItem;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Like;
import com.example.jpetstore.domain.LineItem;
import com.example.jpetstore.domain.Order;

@Repository
public class MybatisLikeDao implements LikeDao {
	@Autowired
	private LikeMapper likeMapper;

	@Override
	public List<Item> getItemLikes(Map<String, Integer> params) throws DataAccessException {
		return likeMapper.getItemLikes(params);
	}

	@Override
	public List<GroupItem> getGroupItemLikes(Map<String, Integer> params) throws DataAccessException {
		return likeMapper.getGroupItemLikes(params);
	}

	@Override
	public void insertItemLike(Like like) throws DataAccessException {
		likeMapper.insertItemLike(like);
	}

	@Override
	public void insertGroupItemLike(Like like) throws DataAccessException {
		likeMapper.insertGroupItemLike(like);
	}

	@Override
	public void removeItemLike(Map<String, Integer> params) throws DataAccessException {
		likeMapper.removeItemLike(params);
	}

	@Override
	public void removeGroupItemLike(Map<String, Integer> params) throws DataAccessException {
		likeMapper.removeGroupItemLike(params);
	}

	@Override
	public List<Item> rankingItem() throws DataAccessException {
		List<Item> items = likeMapper.rankingItem();
		
		List<Item> rankingItems = null;
		for(int i=0; i<5; i++) {
			rankingItems.add(items.get(i));
		}
		
		return rankingItems;
	}

	@Override
	public List<GroupItem> rankingGroupItem() throws DataAccessException {
		List<GroupItem> groupItem = likeMapper.rankingGroupItem();
		
		List<GroupItem> rankingItems = null;
		for(int i=0; i<5; i++) {
			rankingItems.add(groupItem.get(i));
		}
		
		return rankingItems;
	}
}
