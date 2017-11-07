package com.springboot.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.springboot.client.RestClient;
import com.springboot.dao.ReservationDAO;
import com.springboot.entity.Reservation;

public class TestSample {
	/**
	 * Compare the result of web and the result of database
	 * if they are equal, test is true 
	 */
	@Test
	public void testReservById(){
		System.out.println("test ReservByID");
		RestClient restClient = new RestClient();
		String stringByWeb = restClient.getByIdReserv(1);
		
		ReservationDAO reservationDAO = new ReservationDAO();
		Reservation rsvByDao = reservationDAO.getById(1);
		assertEquals(stringByWeb, rsvByDao.toString());
	}
}
