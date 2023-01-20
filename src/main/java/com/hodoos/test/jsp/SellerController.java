package com.hodoos.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hodoos.test.jsp.bo.SellerBO;
import com.hodoos.test.jsp.model.Seller;

@Controller
@RequestMapping("/jsp/seller")
public class SellerController {
	
	@Autowired
	private SellerBO sellerBO;
	
	@PostMapping("/add")
	@ResponseBody
	public String addSeller(
			@RequestParam("nickName") String nickName
			,@RequestParam("temperature") double temperature
			,@RequestParam("profileImage") String profileImage) {
		
		int count = sellerBO.addSeller(nickName, temperature, profileImage);
		return "삽입 결과 : " + count;
	} 
	
	@GetMapping("/input")
	public String sellerInput() {
		return "jsp/sellerInput";
	}
	
	@GetMapping("/info")
	public String sellerInfo(
			@RequestParam(value="id", required=false) Integer id
			,Model model) {
		
//		Seller seller = null;
//		if(id == null) {
//			seller = sellerBO.getLastSeller();
//		} else {
//			seller = sellerBO.getSeller(id);
//		}
		
		Seller seller = sellerBO.getSellerById(id);
		
		model.addAttribute("seller", seller);
		
		return "jsp/sellerInfo";
	}
	
	@GetMapping("/info/id")
	public String sellerInfoById(@RequestParam("id") int id, Model model) {
		return "jsp/sellerInfo";
	}
}
