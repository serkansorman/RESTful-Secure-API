package com.j32bit.bean;

/**
 * Connection kurulacak databasenin verileri tutulur.
 * @author serkan
 *
 */
public class ConnectionData {
	
	private String mySqlDriver;
	private String dbUrl;
	private String dbUserName;
	private String dbPassword;
	
	/**
	 * Database verilerinin property filestan mı yoksa datasourcedan mı alınacağını belirtir.
	 */
	private boolean isUsingDataSource;
	
	/**
	 * Eger data source kullanılıyorsa connection pool olarak kullanılacak data sourcenin JNDI nameini belirtir.
	 */
	private String JNDIname;
	
	public ConnectionData() {
		
	}
	
	
	public boolean isUsingDataSource() {
		return isUsingDataSource;
	}


	public void setUsingDataSource(boolean isUsingDataSource) {
		this.isUsingDataSource = isUsingDataSource;
	}


	public String getJNDIname() {
		return JNDIname;
	}


	public void setJNDIname(String jNDIname) {
		JNDIname = jNDIname;
	}
	
	
	
	public ConnectionData(String mySqlDriver, String dbUrl, String dbUserName, String dbPassword,
			boolean isUsingDataSource, String jNDIname) {
		this.mySqlDriver = mySqlDriver;
		this.dbUrl = dbUrl;
		this.dbUserName = dbUserName;
		this.dbPassword = dbPassword;
		this.isUsingDataSource = isUsingDataSource;
		JNDIname = jNDIname;
	}
	
	
	
	public String getMySqlDriver() {
		return mySqlDriver;
	}
	public void setMySqlDriver(String mySqlDriver) {
		this.mySqlDriver = mySqlDriver;
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getDbUserName() {
		return dbUserName;
	}
	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

}
