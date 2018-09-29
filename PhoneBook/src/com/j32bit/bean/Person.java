package com.j32bit.bean;

/**
 * Person verilerinin tutulduğu person beani
 * @author serkan
 *
 */
public class Person {
	
	private String firstName;
	private String lastName;
	private String phone;
	private String tcno;
	
	
	public Person() {
		
	}
	
	public Person(String tcno,String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.tcno = tcno;
	}

	public Person(String tcno,String firstname,String lastname,String phone) {
		
		this.firstName = firstname;
		this.lastName = lastname;
		this.phone = phone;
		this.tcno = tcno;
		
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	
	public String getPhone() {
		return phone;
	}
	
	public String getTcno() {
		return tcno;
	}
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
		
	}
	
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}
	
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	

}
