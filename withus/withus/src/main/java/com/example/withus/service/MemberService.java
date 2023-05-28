package com.example.withus.service;

import org.apache.ibatis.annotations.Mapper;

import com.example.withus.domain.User;

@Mapper
public interface MemberService {
	public User getSelectOne(User userVO)throws Exception;

}
