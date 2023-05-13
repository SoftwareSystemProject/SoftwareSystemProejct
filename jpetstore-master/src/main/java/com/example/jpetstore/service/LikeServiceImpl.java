package com.example.jpetstore.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpetstore.dao.LikeDao;
import com.example.jpetstore.domain.GroupItem;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Like;



@Service("LikeServiceImpl")
public class LikeServiceImpl implements LikeService {

	@Autowired
	private LikeDao likeDao;

	public List<Item> getItemLikes(Map<String, Integer> params) {
		return likeDao.getItemLikes(params);
	}

	public List<GroupItem> getGroupItemLikes(Map<String, Integer> params) {
		return likeDao.getGroupItemLikes(params);
	}

	public void insertItemLike(Like like) {
		likeDao.insertItemLike(like);
	}

	public void insertGroupItemLike(Like like) {
		likeDao.insertGroupItemLike(like);
	}

	public void removeItemLike(Map<String, Integer> params) {
		likeDao.removeItemLike(params);
	}

	public void removeGroupItemLike(Map<String, Integer> params) {
		likeDao.removeGroupItemLike(params);
	}

	public List<Item> rankingItem() {
		return likeDao.rankingItem();
	}

	public List<GroupItem> rankingGroupItem() {
		return likeDao.rankingGroupItem();
	}

}
