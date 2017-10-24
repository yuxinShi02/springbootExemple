package com.yuxin.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Service;
import com.yuxin.springboot.dao.ReservationDao;
import com.yuxin.springboot.entity.Reservation;

@Service
@EntityScan("com.yuxin.springboot.dao")
public class ServiceImpl implements ServiceReserv{
	@Autowired
	private ReservationDao rsvdao;
	
	public List<Reservation> findAllReservation(){
		System.out.println("ServiceImpl findone invoked.");
		return rsvdao.findAllReservation();
	}

	public Reservation findById(Integer id){
		System.out.println("ServiceImpl findall invoked.");
		return rsvdao.findById(id);
	}
	
	public Integer save(Reservation rsv){
		return rsvdao.save(rsv);
	}

    public Integer update(Reservation rsv){
    	return rsvdao.update(rsv);
    }
    
    public Integer delete(Reservation id){
    	return rsvdao.delete(id);
    }

}
