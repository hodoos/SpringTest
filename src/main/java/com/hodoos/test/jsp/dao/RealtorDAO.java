package com.hodoos.test.jsp.dao;

import org.springframework.stereotype.Repository;

import com.hodoos.test.jsp.model.Realtor;

@Repository
public interface RealtorDAO {

	public int insertRealtor(Realtor realtor);
	
}
