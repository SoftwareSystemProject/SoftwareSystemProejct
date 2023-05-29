package com.example.withus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.example.withus.domain.AttendGroupItem;
import com.example.withus.service.AttendGroupItemService;


@RestController

public class AttendGroupItemController {
	@Autowired
	private AttendGroupItemService attendGroupItemService;

	
	@GetMapping(value = "/insertGroup/{user_id}/{groupItem_id}")
    public AttendGroupItem getGroupItem(@PathVariable("user_id") String user_id,@PathVariable("groupItem_id") int groupItem_id) {

		AttendGroupItem attendGroupItem = new AttendGroupItem();
		attendGroupItem.setUser_id(user_id);
		attendGroupItem.setGroupItem_id(groupItem_id);
		attendGroupItem.setUser_name("혜연"); //나중에 MemberSerivce로 바꾸기
		attendGroupItem.setTotalGroupItem_count(1);
		attendGroupItemService.insertAttendGroupItem(attendGroupItem);
		System.out.println(attendGroupItem);
        return attendGroupItem;
    }
	
	@GetMapping(value = "/attendgroupList")
    public List<AttendGroupItem> groupList() {
		return attendGroupItemService.getAttendGroupItemList();
    }

	
}
