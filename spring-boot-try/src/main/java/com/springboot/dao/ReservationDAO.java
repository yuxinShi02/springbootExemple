package com.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.entity.Reservation;

@Transactional
@Repository
public class ReservationDAO implements IReservationDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Reservation> getAllReservations() {
		String hql = "SELECT rsv FROM reservation rsv ORDER BY rsv.id";
		return (List<Reservation>)entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Reservation getById(int id) {
		System.out.println(id + " getById at RervDAO .");
		Reservation rsv = entityManager.find(Reservation.class, id);
		System.out.println(rsv.getName());
		return rsv;
	}

	@Override
	public boolean reservIsDispo(String name) {
		String hql = "SELECT rsv FROM reservation rsv WHERE rsv.name=?";
		int count = entityManager.createQuery(hql).setParameter(1, name).getResultList().size();
		if (count > 0){
			Reservation rsv = (Reservation) entityManager.createQuery(hql).setParameter(1, name).getSingleResult();
			return true;
		} else {
			return false;
		}
	}

}
