package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.entity.Reservation;
import com.springboot.service.IReservService;

@Controller
@RequestMapping("reserv")
public class ReservController {
	@Autowired
	private IReservService rsvService;
	
	@GetMapping("src/{id}")
	public ResponseEntity<Reservation> getById(@PathVariable("id") int id){
		Reservation rsv = rsvService.getById(id);
		return new ResponseEntity<Reservation>(rsv, HttpStatus.OK);
	}
	
	@GetMapping("src")
	public ResponseEntity<List<Reservation>> getAllReservations(){
		List<Reservation> rsvList = rsvService.getAllReservations();
		return new ResponseEntity<List<Reservation>>(rsvList, HttpStatus.OK);
	}
	
//	@GetMapping("src/{name}")
//	public ResponseEntity<String> reservIsDispo(@PathVariable("name") String name){
//		boolean bool = rsvService.reservIsDispo(name);
//		String res = bool == true ? "yes" : "no";
//		return new ResponseEntity<String>(res, HttpStatus.OK);
//	}
	
}
