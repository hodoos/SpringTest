package com.hodoos.test.jstl.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hodoos.test.jstl.model.WeatherHistory;

@Repository
public interface WeatherHistoryDAO {
	public List<WeatherHistory> selectWeatherHistory();
	
	public int insertWeather(
			@Param("date") Date date
			, @Param("weather") String weather
			, @Param("temperatures") double temperatures
			, @Param("precipitation") double precipitation
			, @Param("microDust") String microDust
			, @Param("windSpeed") double windSpeed);
}
