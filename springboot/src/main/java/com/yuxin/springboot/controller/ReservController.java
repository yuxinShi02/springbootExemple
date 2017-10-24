package com.yuxin.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yuxin.springboot.entity.Reservation;
import com.yuxin.springboot.service.ServiceReserv;

@RestController
public class ReservController {
	@Autowired
	private ServiceReserv servSearch;
	
	@RequestMapping(value = "/reserv/{id}", method = RequestMethod.GET)
	public Reservation findOneReserv(@PathVariable("id") Integer id){
		System.out.println("ReservController findone invoked.");
		return servSearch.findById(id);
	}
	
	@RequestMapping(value = "/reserv/all", method = RequestMethod.GET)
	public List<Reservation> findAllReserv(){
		System.out.println("ReservController findAll invoked.");
		return servSearch.findAllReservation();
	}
	
	@RequestMapping(value = "reserv/all", method = RequestMethod.POST)
	public void createReserv(@RequestBody Reservation reserv){
		servSearch.save(reserv);
	}
	
	@RequestMapping(value = "/reserv/all", method = RequestMethod.PUT)
	public void modifyReserv(@RequestBody Reservation reserv){
		servSearch.update(reserv);
	}
	
	@RequestMapping(value = "/reserv/all", method = RequestMethod.DELETE)
	public void delReserv(@RequestBody Reservation reserv){
		servSearch.delete(reserv);
	}
	
}
