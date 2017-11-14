package com.springboot.test;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import org.springframework.http.ResponseEntity;

import com.springboot.controller.SalleController;
import com.springboot.service.ISalleService;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Verifications;


public class TestSalle {
	
	@Mocked
	ISalleService mockiSalleService;
	
	@Before
	public void setUp() throws Exception {
		// on peut factoriser l'initialisation de certaines variables ici !
	}
	
	/***
	 * Init: Create an instance of Salle Controller and a id, a date string
	 * Transation: invoke isDispo method with the valid initial parameters 
	 * Verification: mocked method must be successfully invoked
	 ****/
	
	@Test
	public void testisDispo(){
		//init
		SalleController salleCtl = new SalleController();
		int id = 1;
		String date = "2017-08-22";
		System.out.println("test controller isDispo");
		new NonStrictExpectations(){
			{
				mockiSalleService.isDispo((Date) any, id);
				result = true;
			}
		};
		
		//Transition
		ResponseEntity<String> isIsalleCtlInvoked = salleCtl.isDispo(id, date);
		assertTrue("controller is dispo is invoked successfully", isIsalleCtlInvoked.getBody().equals("yes"));
		
		new Verifications() {
			{
				mockiSalleService.isDispo((Date) any, id);
				times = 1;
			}
		};
	}
}
