package com.springboot.test;

import java.sql.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.springboot.common.Reservation;
import com.springboot.common.Salle;

public class RestClient {
	   public String getByIdReserv(int id) {
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.setContentType(MediaType.APPLICATION_JSON);
	        RestTemplate restTemplate = new RestTemplate();
	        String url = "http://localhost:8080/reserv/src/{id}";
	        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	        ResponseEntity<Reservation> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Reservation.class, id);
	        Reservation rsv = responseEntity.getBody();
	        System.out.println("Id:"+rsv.getId()+", name:"+ rsv.getName()
	                 +", type:"+rsv.getType());
	        return rsv.toString();
	    }
	   
	    public void getAllReservationsDemo() {
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.setContentType(MediaType.APPLICATION_JSON);
	        RestTemplate restTemplate = new RestTemplate();
	        String url = "http://localhost:8080/reserv/src";
	        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	        ResponseEntity<Reservation[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Reservation[].class);
	        Reservation[] reservations = responseEntity.getBody();
	        for(Reservation rsv : reservations) {
	    	        System.out.println("Id:"+rsv.getId()+", name:"+ rsv.getName()
	                 +", type:"+rsv.getType());     
	        }
	    }
	    
	    public String getByIdSalle(int id){
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.setContentType(MediaType.APPLICATION_JSON);
	        RestTemplate restTemplate = new RestTemplate();
	        String url = "http://localhost:8080/reserv/salle/{id}";
	        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		    ResponseEntity<Salle> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Salle.class, id);
		    Salle salle = responseEntity.getBody();
		    return salle.toString();		        
	    }
	    
	    public String getIsDispoSalle(Date date, int id){
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.setContentType(MediaType.APPLICATION_JSON);
	        RestTemplate restTemplate = new RestTemplate();
	        String url = "http://localhost:8080/reserv/salle/{id}/{date}";
	        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		    ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class, id, date);
		    String rep = responseEntity.getBody();
		    return rep;	        
	    }
	    
	    public static void main(String args[]) {
	    	RestClient client = new RestClient();
	    	client.getAllReservationsDemo();
	    }
}
