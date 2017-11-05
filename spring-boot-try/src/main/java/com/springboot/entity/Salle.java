package com.springboot.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;


public class Salle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="salle_id")
	private int salle_id;
//	
//	@Column(name="salle_name")
	private String salle_name;
	
	private List<Date> timeStamp;

	public int getSalle_id() {
		return salle_id;
	}

	public void setSalle_id(int salle_id) {
		this.salle_id = salle_id;
	}

	public String getSalle_name() {
		return salle_name;
	}

	public void setSalle_name(String salle_name) {
		this.salle_name = salle_name;
	}

	public List<Date> getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(List<Date> timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "Salle [salle_id=" + salle_id + ", salle_name=" + salle_name + ", timeStamp=" + timeStamp + "]";
	}
	
}
