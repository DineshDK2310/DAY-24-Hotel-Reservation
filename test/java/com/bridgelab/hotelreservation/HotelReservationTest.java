package com.bridgelab.hotelreservation;

import org.junit.*;

public class HotelReservationTest {

	HotelReservation hrTest = new HotelReservation();

	@Test
	public void givenHotelNameShouldReturnItsHotelName() {
		boolean result = hrTest.addHotel();
		Assert.assertTrue(result);
	}
}
