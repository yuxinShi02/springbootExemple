package com.springboot.dao;

import java.sql.Date;
import java.util.List;

import com.springboot.entity.Salle;

public interface ISalleDAO {
	public List<Salle> getAllSalle();
	public Salle getById(int salle_id);
	public boolean isDispo(Date from, int salle_id);

}
