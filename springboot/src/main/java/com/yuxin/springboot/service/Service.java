package com.yuxin.springboot.service;

import java.util.List;

import com.yuxin.springboot.entity.Reservation;

public interface Service {
	 	List<Reservation> findAllReservation();
	 
	 	Reservation findById(Integer id);

	    Integer save(Reservation rsv);

	    Integer update(Reservation rsv);

	    Integer delete(Reservation id);
}
