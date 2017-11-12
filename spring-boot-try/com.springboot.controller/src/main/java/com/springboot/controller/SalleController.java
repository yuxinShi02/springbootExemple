package com.springboot.controller;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springboot.common.Salle;
import com.springboot.service.ISalleService;

@Controller
@RequestMapping("reserv")
public class SalleController {
	@Autowired
	private ISalleService isalleService;
	
	@GetMapping("salle/{id}")
	public ResponseEntity<Salle> getById(@PathVariable("id") int id){
		Salle salle = isalleService.getById(id);
		return new ResponseEntity<Salle>(salle, HttpStatus.OK);
	}
	
	@GetMapping("salle")
	public ResponseEntity<List<Salle>> getAllSalle(){
		List<Salle> ls_salle = isalleService.getAllSalle();
		return new ResponseEntity<List<Salle>>(ls_salle, HttpStatus.OK);
	}
	
	@GetMapping("salle/{id}/{date}")
	public ResponseEntity<String> isDispo(@PathVariable("id") int id, @PathVariable("date") String date){
		Date sqlDate = Date.valueOf(date);
		boolean bool = isalleService.isDispo(sqlDate, id);
		String res = bool == true ? "yes" : "no";
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
}
