package com.springboot.service;

import java.util.List;

import com.springboot.common.Reservation;

public interface IReservService {
	List<Reservation> getAllReservations();
	
	Reservation getById(int id);
	
	boolean reservIsDispo(String name);
} 
