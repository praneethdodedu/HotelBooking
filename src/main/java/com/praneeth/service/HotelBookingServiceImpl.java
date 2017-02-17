package com.praneeth.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praneeth.dao.HotelBookingDao;
import com.praneeth.model.BookingDetails;
import com.praneeth.model.HotelDetail;

@Service
public class HotelBookingServiceImpl implements HotelBookingService {

	@Autowired
	private HotelBookingDao hotelBookingDao;

	@Override
	public List<String> getCities() {
		return hotelBookingDao.getCities();
	}

	@Override
	public List<String> getHotelsByCity(String city) {
		return hotelBookingDao.getHotelsByCity(city);
	}

	@Override
	public String bookHotel(BookingDetails bookingDetails) {
		String respMessage;
		int numberroom = hotelBookingDao.getRoomNumber(
				bookingDetails.getCity(), bookingDetails.getHotelName());
		if (bookingDetails.getNumberRooms() > numberroom) {
			respMessage = "Requested Rooms are not available";
		} else {
			UUID idOne = UUID.randomUUID();
			respMessage = "Successfully booked hotel. BookId is:" + idOne;
		}
		// TODO Auto-generated method stub
		return respMessage;
	}

	@Override
	public List<HotelDetail> getHotelDetailsbyCity(String city) {
		return hotelBookingDao.getHotelDetailsbyCity(city);
	}

}
