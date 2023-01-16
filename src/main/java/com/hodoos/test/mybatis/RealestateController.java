package com.hodoos.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hodoos.test.mybatis.bo.RealestateBO;
import com.hodoos.test.mybatis.model.Realestate;

@Controller
@RequestMapping("/mybatis/test01")
public class RealestateController {
	
	// 특정 id를 파라미터로 전달 받을 것임
	@Autowired
	private RealestateBO realestateBO;
	
	@RequestMapping("/1")
	@ResponseBody
	public Realestate realestate(
//			@RequestParam("id") int id
			@RequestParam(value="id", defaultValue="1") int id
			) {
		
		Realestate realestate = realestateBO.getRealestate(id);
		return realestate;
	}
	
	@RequestMapping("/2")
	@ResponseBody
	public List<Realestate> realestateRentPrice(@RequestParam("rent") int rentPrice) {
		
		List<Realestate> realestateList = realestateBO.getRealestateRentPrice(rentPrice);
		return realestateList;
	}
	
	@RequestMapping("/3")
	@ResponseBody
	public List<Realestate> realestateAreaPrice(
			@RequestParam("area") int area
			,@RequestParam("price") int price) {
		
		return realestateBO.getRealestateAreaPrice(area, price);
		
	}
	@RequestMapping("/4")
	@ResponseBody
	public String addRealEstateByObject() {
		Realestate realestate = new Realestate();
		realestate.setRealtorId(3);
		realestate.setAddress("푸르지용 리버 303동 1104호");
		realestate.setArea(89);
		realestate.setType("매매");
		realestate.setPrice(100000);
		
		int count = realestateBO.addRealEstateByObject(realestate);
		return "입력 성공 : " + count;
	}
	
	@RequestMapping("/5")
	@ResponseBody
	public String addRealEstate(@RequestParam("realtorId") int realtorId) {
		
		int count = realestateBO.addRealEstate(realtorId, "샹뗴빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		return "삽입결과 : " + count;		
				
	}
	
	@RequestMapping("/6")
	@ResponseBody
	public String updateRealEstate() {
		
		//id가 24인 매물의 타입을 전세 price 70000
		int count = realestateBO.updateRealEstate(14, "전세", 70000);
		return "수정사항 : " + count;
	}
	
	@RequestMapping("/7")
	@ResponseBody
	public String deleteRealEstate(@RequestParam("id") int id) {
		int count = realestateBO.deleteRealEstate(id);
		return "삭제결과 : " + count;
	}
}
