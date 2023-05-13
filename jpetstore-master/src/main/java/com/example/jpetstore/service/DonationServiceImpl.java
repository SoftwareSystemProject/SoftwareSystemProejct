package com.example.jpetstore.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpetstore.dao.DonationDao;
import com.example.jpetstore.domain.Donation;



@Service("DonationServiceImpl")
public class DonationServiceImpl implements DonationService {

	@Autowired
	private DonationDao donationDao;

	public List<Donation> getTotalDonations() {
		return donationDao.getTotalDonations();
	}

	public Donation getDonation(int donation_id) {
		return donationDao.getDonation(donation_id);
	}

	public void registerDonation(Donation donation) {
		donationDao.registerDonation(donation);
	}

	public void deleteDonation(int donation_id) {
		donationDao.deleteDonation(donation_id);
	}

	public void updateDonation(Donation donation) {
		donationDao.updateDonation(donation);
	}

	public List<Donation> rankingDonation() {
		return donationDao.rankingDonation();
	}

	

}
