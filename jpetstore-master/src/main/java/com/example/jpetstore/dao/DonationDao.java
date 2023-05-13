package com.example.jpetstore.dao;

import java.util.List;

import javax.activation.CommandMap;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Donation;
import com.example.jpetstore.domain.Order;

public interface DonationDao {
	List<Donation> getTotalDonations() throws DataAccessException;

	Donation getDonation(int donation_id) throws DataAccessException;
	  
	void registerDonation(Donation donation) throws DataAccessException;
	  
	void deleteDonation(int donation_id) throws DataAccessException;
	  
	void updateDonation(Donation donation) throws DataAccessException;
	  
	List<Donation> rankingDonation() throws DataAccessException;
}
