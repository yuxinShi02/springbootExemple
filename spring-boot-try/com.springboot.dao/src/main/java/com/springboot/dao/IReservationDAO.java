package com.springboot.dao;

import java.util.List;

import com.springboot.common.Reservation;

public interface IReservationDAO {
	List<Reservation> getAllReservations();

	Reservation getById(int id);

	boolean reservIsDispo(String name);
}
