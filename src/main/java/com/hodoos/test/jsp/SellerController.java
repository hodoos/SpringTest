package com.hodoos.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hodoos.test.jsp.bo.SellerBO;

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
}
