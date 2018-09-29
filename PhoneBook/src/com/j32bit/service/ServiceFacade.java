package com.j32bit.service;

import java.util.Properties;

import com.j32bit.dao.person.PersonDAO;

public class ServiceFacade {
	
	private static ServiceFacade serviceFacade;
	private PersonDAO personDAO;
	
	public ServiceFacade(){
		
	}
	
	public static ServiceFacade getInstance() {
		if(serviceFacade == null)
			serviceFacade = new ServiceFacade();
		return serviceFacade;
	}
	
	public void start(Properties prop) throws ClassNotFoundException {
		personDAO = new PersonDAO();
		personDAO.start(prop);
	}
	
	

	public void finish() {
		/**
		 * 
		 */
	}
	
	public PersonDAO getPersonDAO() {
		return personDAO;
	}

}
