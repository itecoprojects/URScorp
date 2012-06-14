package ru.urscorp.dao.service;

import org.springframework.beans.factory.annotation.Autowired;

import ru.urscorp.dao.jpa.UtilJpa;


public class UtilServiceImpl implements UtilService {
	
	@Autowired
	UtilJpa utilJpa;
	
	public String test(){
		return utilJpa.test();//utilJpa.test();
	}
	
}
