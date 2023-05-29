package com.example.withus.dao.mybatis.mapper;

import java.util.List;

import com.example.withus.domain.DonationOrders;

public interface DonationOrdersMapper {
	
	List<DonationOrders> getTotalDonationOrders(String user_id);
	DonationOrders getDonationOrder(String user_id, int donation_id);
	void applyDonationOrder(DonationOrders donationOrders);
	void cancelDonationOrder(String user_id, int donation_id);
}
