package com.yuxin.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.yuxin.springboot.entity.Reservation;

public interface ReservationDao {
	 List<Reservation> findAllReservation();
	 
	 Reservation findById(@Param("id") Integer id);

	 Integer save(Reservation rsv);

	 Integer update(Reservation rsv);

	 Integer delete(Reservation id);
}
