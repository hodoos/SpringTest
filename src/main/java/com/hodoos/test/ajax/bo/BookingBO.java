package com.hodoos.test.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hodoos.test.ajax.dao.BookingDAO;
import com.hodoos.test.ajax.model.Booking;

@Service
public class BookingBO {
	
	@Autowired
	private BookingDAO bookingDAO;

	public List<Booking> getBookingList() {
		return bookingDAO.selectBookingList();
	}
	
	public int deleteBookingList(int id) {
		return bookingDAO.deleteBookingList(id);
	}
	
	public int insertBookingList(
			String name
			, int day
			, int headcount
			, String date
			, String phoneNumber) {
		
		return bookingDAO.getBookingList(name, day, headcount, date, phoneNumber, "대기중");
	}
	
	public Booking findBooking(String name, String phoneNumber) {
		
		return bookingDAO.selectBookingByNamePhoneNumber(name, phoneNumber);
	}
}
