package com.hodoos.test.jstl.model;

import java.util.Date;

public class WeatherHistory {

	private int id;
	private String weather;
	private Date date;
	private double temperatures;
	private double precipitation;
	private String microDust;
	private double windSpeed;
	private Date createdAt;
	private Date updatedAt;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getTemperatures() {
		return temperatures;
	}
	public void setTemperature(double temperature) {
		this.temperatures = temperature;
	}
	public double getPrecipitation() {
		return precipitation;
	}
	public void setPrecipiptation(double precipiptation) {
		this.precipitation = precipiptation;
	}
	public String getMicroDust() {
		return microDust;
	}
	public void setMicroDust(String microDust) {
		this.microDust = microDust;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
