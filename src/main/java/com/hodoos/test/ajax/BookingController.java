package com.hodoos.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/main")
	public String mainPage() {
		return "ajax/booking/booking";
	}
	
	// 이름, 전화번호 전달 받고, 일치하는 결과 하나를 json 형태로 변환해서 리스펀스에 담는다.
	@GetMapping("/find")
	@ResponseBody
	public Map<String, Object> findBooking(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingBO.findBooking(name, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();

		if(booking != null) {
			result.put("result", "success");
			result.put("booking", booking);
		} else {
			result.put("result", "fail");
		}
		// 조회가 성공하면 {"result":"success", "data":booking}
		// 조회가 실패하면 {"result":"fail"}
		
		
		
		return result;
		
		
	}
	
	
	
	
	
	
}
