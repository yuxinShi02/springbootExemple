package com.springboot.dao;

import java.util.List;

import com.springboot.entity.Reservation;

public interface IReservationDAO {
	List<Reservation> getAllReservations();

	Reservation getById(int id);

	boolean reservIsDispo(String name);
}
