package com.hodoos.test.mybatis.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hodoos.test.mybatis.dao.RealestateDAO;
import com.hodoos.test.mybatis.model.Realestate;

@Service
public class RealestateBO {
	
	@Autowired
	private RealestateDAO realestateDAO;
	
	public Realestate getRealestate(int id) {
		Realestate realestate = realestateDAO.selectRealestate(id);
		return realestate;
	}
	
	public List<Realestate> getRealestateRentPrice(int rentPrice) {
		
		List<Realestate> realestateList = realestateDAO.selectRealestateRentPrice(rentPrice);
		return realestateList;
	}
	
	public List<Realestate> getRealestateAreaPrice(int area, int price)  {
		return realestateDAO.selectRealestateAreaPrice(area, price);
		
	}
	
	public int addRealEstateByObject(Realestate realestate) {
		return realestateDAO.insertRealEstateByObject(realestate);
	}
	
	public int addRealEstate(
			int realtorId
			, String address
			, int area
			, String type
			, int price
			, int rentPrice) {
		return realestateDAO.insertRealEstate(realtorId, address, area, type, price, rentPrice);
	}
	
	// 변경할 대상 id, 변경 할 type, 변경 할 price
	public int updateRealEstate(int id, String type, int price) {
		return realestateDAO.updateRealEstate(id, type, price);
	}
	
	public int deleteRealEstate(int id) {
		return realestateDAO.deleteRealEstate(id);
	}
}
