package com.yuxin.springboot.service;

import java.lang.annotation.Annotation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuxin.springboot.service.*;
import com.yuxin.springboot.dao.ReservationDao;
import com.yuxin.springboot.entity.Reservation;

@Service
public class ServiceImpl implements com.yuxin.springboot.service.Service{
	@Autowired
	private ReservationDao rsvdao;
	
	public List<Reservation> findAllReservation(){
		return rsvdao.findAllReservation();
	}

	public Reservation findById(Integer id){
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
