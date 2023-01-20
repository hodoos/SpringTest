package com.hodoos.test.jsp.bo;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hodoos.test.jsp.dao.SellerDAO;
import com.hodoos.test.jsp.model.Seller;

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
	public Seller getLastSeller(Integer id) {
		
		if(id == null) {
			return sellerDAO.selectLastSeller();
		} else {
			return sellerDAO.selectSeller(id);
		}
		
	}
	
	public Seller getLastSeller() {
		
		return sellerDAO.selectLastSeller();
		
	}
	
	public Seller getSellerById(@Param("id") int id) {
		
		return sellerDAO.selectSeller(id);
		
		
	}
}
