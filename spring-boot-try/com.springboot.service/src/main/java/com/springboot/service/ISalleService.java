package com.springboot.service;

import java.sql.Date;
import java.util.List;

import com.springboot.common.Salle;

public interface ISalleService {
	public List<Salle> getAllSalle();
	public Salle getById(int salle_id);
	public boolean isDispo(Date from, int salle_id);

}
