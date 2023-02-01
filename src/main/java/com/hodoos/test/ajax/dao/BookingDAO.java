package com.hodoos.test.ajax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hodoos.test.ajax.model.Booking;

@Repository
public interface BookingDAO {

	public List<Booking> selectBookingList();
	
	public int deleteBookingList(@Param("id") int id);
	
	public int getBookingList(
			@Param("name") String name
			, @Param("day") int day
			, @Param("headcount") int headcount
			, @Param("date") String date
			, @Param("phoneNumber") String phoneNumber
			, @Param("state") String state);
}
