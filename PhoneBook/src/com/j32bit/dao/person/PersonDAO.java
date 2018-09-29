package com.j32bit.dao.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.j32bit.bean.Person;
import com.j32bit.dao.ConnectionHelperDAO;


/**
 * Person beanindeki veriler kullanılarak database üzerinde 
 * add,update,delete gibi işlemler yapılır.
 * 
 * @author serkan
 *
 */
public class PersonDAO extends ConnectionHelperDAO implements IService {
	
	public PersonDAO(){
		
	}
	
	
	@Override
	public void start(Properties prop) throws ClassNotFoundException{
		super.init(prop);
		
	}
	
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		
	}
	
	
	/**
	 * Database ile connection kurulup parametre ile gelen 
	 * person verileri insert edilir.
	 * @param person databaseye eklenecek person
	 * @param choice form sayfasındaki seçime göre yapılacak update yada register işlemini belirtir.
	 * @throws Exception 
	 */
	public void savePerson(Person person,String choice) throws Exception {
		
		Connection conn = getConnection();
		try {
			
			saveToPeople(person,conn); 
			saveToPhones(person,conn);
			
			conn.commit();
			
		}catch (SQLIntegrityConstraintViolationException e) {
			
			if(choice.equals("update")) {
				saveToPhones(person,conn); // Kayıtlı kişiye ait yeni telefon numarası eklenir.
				conn.commit();
			}
			else
				throw new Exception("You are already registered,you can only update your phone!");
			
		} catch(SQLException ex) {
			rollBackTransaction(conn);
		}
		finally {
			
			closeConnection(conn);
		}
	}

	
	/**
	 * Kişinin telefon numarası ve tcnosunu phones tablosuna yazar
	 * @param person phones tablosuna telefon nosu ve tcnosu eklenecek kişi.
	 * @param conn database bağlantısı
	 * @throws SQLException
	 */
	public void saveToPhones(Person person,Connection conn) throws SQLException {
		
		PreparedStatement preparedStmt = conn.prepareStatement("insert into phones (tcno, phone) values (?, ?)");
		preparedStmt.setString(1, person.getTcno());
		preparedStmt.setString(2, person.getPhone());
		
		preparedStmt.execute();
		closePreparedStatement(preparedStmt);
		
	}

	/**
	 * Kişinin ad,soyad ve tcnosunu people tablosuna yazar
	 * @param person people tablosuna yazılacak person.
	 * @param conn database bağlantısı
	 * @throws SQLException
	 */
	public void saveToPeople(Person person,Connection conn) throws SQLException {
		
		PreparedStatement preparedStmt = conn.prepareStatement("insert into people (tcno,lastname, firstname) values (?, ?, ?)");
		preparedStmt.setString(1, person.getTcno());
		preparedStmt.setString(2, person.getLastName());
		preparedStmt.setString(3, person.getFirstName());
		
		preparedStmt.execute();
		closePreparedStatement(preparedStmt);
		
				
	}

	/**
	 * Databasedeki tüm kişileri bir arrayliste ekler
	 * @return Person lardan oluşan arraylist
	 * @throws Exception
	 */
	public ArrayList<Person> getAllCustomer() throws Exception {
		
		Connection conn = getConnection();
	    Statement stm = conn.createStatement();
	    ResultSet rst = stm.executeQuery("Select * from people");
	    ArrayList<Person> customerList = new ArrayList<>();
	    while (rst.next()) {
	        Person person = new Person(rst.getString("tcno"), rst.getString("firstname"), rst.getString("lastname"));
	        customerList.add(person);
	    }
	    return customerList;
	}
	
	/**
	 * Verilen tcnoya ait kişi databaseden getirilir.
	 * @param tcno aranacak kişinin tcnosu
	 * @return bulunan kişiye ait verileri içeren bean
	 * @throws Exception
	 */
	public Person getPerson(String tcno) throws Exception {
		
		Connection conn = getConnection();
		Person person = new Person();
		PreparedStatement preparedStmt = conn.prepareStatement("Select * from people WHERE tcno=?");
		preparedStmt.setString(1, tcno);
		ResultSet rs = preparedStmt.executeQuery();
		
		if(rs.next()) {
			person.setFirstName(rs.getString("firstname"));
			person.setLastName("lastname");
			person.setTcno(rs.getString("tcno"));
			person.setPhone(rs.getString("phone"));
		}
		
		return person;
		
	}
	
	/**
	 * Verilen tcnoya ait kişi databaseden silinir.
	 * @param tcno silinecek kişinin tcnosu
	 * @throws Exception
	 */
	public void deletePerson(String tcno) throws Exception {
		
		Connection conn = getConnection();
		PreparedStatement preparedStmt = conn.prepareStatement("Delete from people WHERE tcno=?");
		PreparedStatement preparedStmt2 = conn.prepareStatement("Delete from phones WHERE tcno=?");

		preparedStmt.setString(1, tcno);
		preparedStmt2.setString(1, tcno);
		
		preparedStmt.executeUpdate();
		preparedStmt2.executeUpdate();
	
	}
	
	
	
	
}
