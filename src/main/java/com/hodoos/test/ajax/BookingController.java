package com.hodoos.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hodoos.test.ajax.bo.BookingBO;
import com.hodoos.test.ajax.model.Booking;

@Controller
@RequestMapping("/ajax/booking")
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/list")
	public String bookingList(Model model) {
		
		List<Booking> bookingList = bookingBO.getBookingList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "ajax/booking/list";
	}
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteBookingList(@RequestParam("id") int id) {
		
		int count = bookingBO.deleteBookingList(id);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 0) {
			result.put("result", "fail");
		} else {
			result.put("result", "success");
		}
		
		return result;
	}
	@GetMapping("/input")
	public String inputBookingList() {
		return "ajax/booking/input";
	}
	
	@GetMapping("/insert")
	@ResponseBody
	public Map<String, String> insertBookingList(
			@RequestParam("date") String date
			,@RequestParam("name") String name
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		int count = bookingBO.insertBookingList(name, day, headcount, date, phoneNumber);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 0) {
			result.put("result", "fail");
		} else {
			result.put("result", "success");
		}
		
		return result;
	}
}
