package com.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.entity.Reservation;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Transactional
@Repository
public class ReservationDAO implements IReservationDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private Statement st;
	private Connection conn;
	private ResultSet rs;
	
	public void init(){
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "yuxin", "toto");
			st = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Reservation> getAllReservations() {
//		String hql = "SELECT rsv FROM reservation rsv ORDER BY rsv.id";
//		return (List<Reservation>)entityManager.createQuery(hql).getResultList();
		init();
		List<Reservation> ls = new ArrayList<Reservation>();
		try {
			ResultSet rs = st.executeQuery("SELECT * from reservation;");
			while (rs.next()){
				Reservation rsv = new Reservation();
				rsv.setId(rs.getInt("id"));
				rsv.setName(rs.getString("name"));
				rsv.setStatus(rs.getBoolean("status"));
				rsv.setType(rs.getString("type"));
				ls.add(rsv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public Reservation getById(int id) {
		System.out.println(id + " getById at RervDAO .");
		init();
//		Reservation rsv = entityManager.find(Reservation.class, id);
		Reservation rsv = new Reservation();
		try {
			rs = st.executeQuery("Select * from reservation where id = " + id +";");
			while(rs.next()){
			rsv.setId(rs.getInt("id"));
			rsv.setName(rs.getString("name"));
			rsv.setStatus(rs.getBoolean("status"));
			rsv.setType(rs.getString("type"));
			System.out.println(rsv.getName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rsv;
	}

	@Override
	public boolean reservIsDispo(String name) {
//		String hql = "SELECT rsv FROM reservation rsv WHERE rsv.name=?";
//		int count = entityManager.createQuery(hql).setParameter(1, name).getResultList().size();
		init();
		boolean bool = false;
		try {
			rs = st.executeQuery("SELECT  * FROM reservation WHERE name = '" + name + "';");
			if (rs.next()){
				bool = rs.getBoolean("status");
				return bool;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;

	}

}

