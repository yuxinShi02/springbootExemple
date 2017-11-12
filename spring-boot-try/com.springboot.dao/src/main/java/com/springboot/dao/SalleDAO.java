package com.springboot.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.springboot.common.Salle;

public class SalleDAO implements ISalleDAO{
	private Connection conn;
	private Statement statement;
	public void init(){
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false", "yuxin", "toto");
			statement = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void close(){
		try {
			this.statement.close();
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public List<Salle> getAllSalle() {
		init();
		ResultSet resultSet;
		List<Salle> ls_salle = new ArrayList<>();
		try {
			String sql = "SELECT salle_id, salle_name from salle;";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Salle salle = new Salle();
				salle.setSalle_id(resultSet.getInt("salle_id"));
				salle.setSalle_name(resultSet.getString("salle_name"));
				ls_salle.add(salle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return ls_salle;
	}

	@Override
	public Salle getById(int salle_id) {
		init();
		String sql = "SELECT * FROM salle WHERE salle_id="+salle_id + ";";
		ResultSet resultSet;
		Salle salle = new Salle();
		List<Date> ls_date = new ArrayList<>();
		try {
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				salle.setSalle_id(resultSet.getInt("salle_id"));
				salle.setSalle_name(resultSet.getString("salle_name"));
			}
			sql = "SELECT * FROM reserv_time WHERE id = " + salle.getSalle_id() +";";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Date date = resultSet.getDate("reserv_date");
				ls_date.add(date);
			}
			salle.setTimeStamp(ls_date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return salle;
	}

	@Override
	/**
	 * pay attention, a bug, sql=2017-11-24 but the truth is 2017-10-24
	 */
	public boolean isDispo(Date from, int salle_id) {
		init();
		String sql = "SELECT reserv_time.reserv_date FROM salle INNER JOIN reserv_time ON salle.salle_id = "
				+ "reserv_time.salle_id WHERE reserv_time.salle_id="+salle_id + " "
						+ "AND reserv_time.reserv_date = '" + from.toString() +"';";
		ResultSet resultSet;
		System.out.println(sql);
		try {
			resultSet = statement.executeQuery(sql);
			if (resultSet.first()){
				System.out.println("=================PENDING===============");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return true;
	}
	

}
