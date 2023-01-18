package com.hodoos.test.jsp.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hodoos.test.jsp.dao.SellerDAO;

@Service
public class SellerBO {
	
	@Autowired
	private SellerDAO sellerDAO;
	
	public int addSeller(
			String nickName
			, double temperature
			, String profileImage) {
		
		return sellerDAO.insertSeller(nickName, temperature, profileImage);
		
	}
}
