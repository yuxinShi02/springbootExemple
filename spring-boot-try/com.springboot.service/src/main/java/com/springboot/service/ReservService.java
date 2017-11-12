package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.IReservationDAO;
import com.springboot.common.Reservation;

@Service
public class ReservService implements IReservService{
	@Autowired
	private IReservationDAO rsvDao;
	
	@Override
	public List<Reservation> getAllReservations() {
		return rsvDao.getAllReservations();
	}

	@Override
	public Reservation getById(int id) {
		return rsvDao.getById(id);
	}

	@Override
	public boolean reservIsDispo(String name) {
		return rsvDao.reservIsDispo(name);
	}
	
}
