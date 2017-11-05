package com.springboot.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.dao.SalleDAO;
import com.springboot.entity.Salle;

@Service
public class SalleService implements ISalleService{
	private SalleDAO salleDao;
	
	@Override
	public List<Salle> getAllSalle() {
		salleDao = new SalleDAO();
		return salleDao.getAllSalle();
	}

	@Override
	public Salle getById(int salle_id) {
		salleDao = new SalleDAO();
		return salleDao.getById(salle_id);
	}

	@Override
	public boolean isDispo(Date from, int salle_id) {
		salleDao = new SalleDAO();
		return salleDao.isDispo(from, salle_id);
	}

}
