package com.praneeth.service;

import java.util.List;

import com.praneeth.model.BookingDetails;
import com.praneeth.model.HotelDetail;

public interface HotelBookingService {

	public List<String> getCities();

	public List<String> getHotelsByCity(String city);

	public String bookHotel(BookingDetails bookingDetails);

	public List<HotelDetail> getHotelDetailsbyCity(String city);

}
