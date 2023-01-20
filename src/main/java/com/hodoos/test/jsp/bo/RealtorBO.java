package com.hodoos.test.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hodoos.test.jsp.dao.RealtorDAO;
import com.hodoos.test.jsp.model.Realtor;

@Service
public class RealtorBO {
	@Autowired
	private RealtorDAO realtorDAO;
	public int addRealtor(Realtor realtor) {
		
		return realtorDAO.insertRealtor(realtor);
	}
}
