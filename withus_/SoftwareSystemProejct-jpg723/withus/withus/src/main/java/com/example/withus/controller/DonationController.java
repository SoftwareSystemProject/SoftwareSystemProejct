package com.example.withus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.example.withus.domain.Donation;
import com.example.withus.domain.Order;
import com.example.withus.domain.User;
import com.example.withus.service.DonationService;


@RestController
@SessionAttributes("donation") //session에 저장 및 공유
public class DonationController {
	//@Autowired
	//private PetStoreFacade petStore; //나중에 userService로 바꾸기
	@Autowired
	private DonationService donationService;
	
	//추가(세아) : donation list 조회
	@GetMapping(value = "/donationList")
    public List<Donation> donationList() {
		return donationService.getTotalDonations();
    }
	
	//추가(세아) : donation 상세 조회
	@GetMapping(value = "/donationList/detail/{id}")
	public Donation getDonation(@PathVariable("id") int donation_id) {
		return donationService.getDonation(donation_id);
	}
		
	@ModelAttribute("donation")
	public DonationInfo formBacking(HttpServletRequest request) {
		DonationInfo donationInfo = new DonationInfo();
		return donationInfo;
	}
	
	//기부 등록 폼
	@GetMapping("/donation/register")
	public String form() {
		return "donation/donationForm";
	}
	
	//기부 등록
	 @PostMapping(value="/donation/register")
	  public String submitDonation(@ModelAttribute("donation") DonationInfo donationInfo,
			  BindingResult result, SessionStatus status) {
//		 new DonationInfoValidator().validate(donationInfo, result);
//		 if(result.hasErrors()) {
//			 return "donation/donationForm";
//		 }
		 
		 donationService.registerDonation(null);
		 status.setComplete();
		 return "/donation/list";
	 }
	

	 //기부 삭제
	 @PostMapping(value="/donation/{donation_id}/cancel")
	 public String deleteDonation(@PathVariable("donation_id") int donation_id) {
		 donationService.deleteDonation(donation_id);
		 return "redirect:/donation";
	 }
	
	
}
