 package com.j32bit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.j32bit.bean.ConnectionData;

/**
 * Database ile kurulacak connection işlemlerinin yapıldığı class
 * @author serkan
 *
 */
public class ConnectionHelperDAO {
	
	private ConnectionData connectionDataBean;
	final Logger logger = Logger.getLogger(ConnectionHelperDAO.class);

	
	/**
	 * Property filestan okunmuş olan veriler ile bean oluşturulur
	 * @param prop property filestan okunan database verileri
	 * @throws ClassNotFoundException
	 */
	public void init(Properties prop) throws ClassNotFoundException{
				
		connectionDataBean = new ConnectionData();
		
		connectionDataBean.setMySqlDriver(prop.getProperty("mySqlDriver"));
		connectionDataBean.setDbUrl(prop.getProperty("dbUrl"));
		connectionDataBean.setDbUserName(prop.getProperty("dbUserName"));
		connectionDataBean.setDbPassword(prop.getProperty("dbPassword"));
		connectionDataBean.setUsingDataSource(Boolean.valueOf(prop.getProperty("isUsingDataSource")));
		connectionDataBean.setJNDIname(prop.getProperty("JNDIname"));
		
	}
	
	/**
	 * Datasource ya da property files kullanarak database ile connection kurulur.
	 * @return database ile kurulan connection return edilir.
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		Connection conn = null;
		if(connectionDataBean.isUsingDataSource()) {
			InitialContext ic = new InitialContext();
			BasicDataSource ds = (BasicDataSource) ic.lookup(connectionDataBean.getJNDIname());
			conn = ds.getConnection();
			logger.debug("Connection created with Data source");
		}else {
			
			Class.forName(connectionDataBean.getMySqlDriver());
			conn = DriverManager.getConnection(connectionDataBean.getDbUrl(), connectionDataBean.getDbUserName(), connectionDataBean.getDbPassword());
			logger.debug("Connection created using Property files");
		}
		
		conn.setAutoCommit(false);		
		return conn;
	}
	

	public void closeConnection(Connection conn) throws SQLException {
		if (conn != null)
			conn.close();
	}
	
	
	public void closePreparedStatement (PreparedStatement pst) throws SQLException {
		if(pst != null)
			pst.close();
	}
	
	/**
	 * Connection transaction yapıldığında eğer bir hata gerçekleşmişse
	 * database üzerinde yapılan değişiklikler geri alınır.
	 * @param conn
	 */
	public void rollBackTransaction(Connection conn) {
		
		if (conn != null) {
			try {
				conn.rollback();
				logger.debug("Transaction is being rolled back");				
			} catch (SQLException excep) {
				excep.printStackTrace();
			}
		}
	}

}
