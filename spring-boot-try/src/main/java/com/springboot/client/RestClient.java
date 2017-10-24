package com.springboot.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.springboot.entity.Reservation;

public class RestClient {
	   public void getByIdDemo() {
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.setContentType(MediaType.APPLICATION_JSON);
	        RestTemplate restTemplate = new RestTemplate();
	        String url = "http://localhost:8080/reserv/src/{id}";
	        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	        ResponseEntity<Reservation> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Reservation.class, 1);
	        Reservation rsv = responseEntity.getBody();
	        System.out.println("Id:"+rsv.getId()+", name:"+ rsv.getName()
	                 +", type:"+rsv.getType());      
	    }
	   
	    public void getAllReservationsDemo() {
	    	HttpHeaders headers = new HttpHeaders();
	    	headers.setContentType(MediaType.APPLICATION_JSON);
	            RestTemplate restTemplate = new RestTemplate();
	    	String url = "http://localhost:8080/user/Reservations";
	            HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	            ResponseEntity<Reservation[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Reservation[].class);
	            Reservation[] reservations = responseEntity.getBody();
	            for(Reservation rsv : reservations) {
	    	        System.out.println("Id:"+rsv.getId()+", name:"+ rsv.getName()
	                 +", type:"+rsv.getType());     
	            }
	    }
	    
	    public static void main(String args[]) {
	    	RestClient client = new RestClient();
	        //util.getArticleByIdDemo();
	    	//client.getByIdDemo();
	    	client.getAllReservationsDemo();
	    }
}
