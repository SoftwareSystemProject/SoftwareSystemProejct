package com.example.withus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.withus.domain.User;

@Service
public class MemberServiceImpl {

	@Autowired
	private MemberService memberRepository;
	
	public User getSelectOne(User userVO) throws Exception{
		return memberRepository.getSelectOne(userVO);
	}
}
