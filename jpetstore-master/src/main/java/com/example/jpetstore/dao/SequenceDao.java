package com.example.jpetstore.dao;

import org.springframework.dao.DataAccessException;

public interface SequenceDao {
	public int getNextId(int id) throws DataAccessException;
}
