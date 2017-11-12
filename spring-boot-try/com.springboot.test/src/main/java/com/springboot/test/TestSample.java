package com.springboot.test;

import org.junit.Test;

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
	}
}
