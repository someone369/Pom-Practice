package com.uIFrameWork.companyName.projectNmae.hepler.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.uIFrameWork.companyName.projectNmae.hepler.logger.LoggerHelper;

public class DatabaseHelper {
	private static Logger log = LoggerHelper.getLogger(DatabaseHelper.class);
	
	private static String drivername = "";
	private static String URL = "";
	private static String username = "";
	private static String password = "";
	private static Connection connection;
	private static DatabaseHelper instance = null;
	
	public DatabaseHelper() {
		connection = getSingleInstanceconnection();
	}

	public static DatabaseHelper getInstance() {
		if (instance == null) {
			instance = new DatabaseHelper();
		}
		return instance;
	}

	
	private Connection getSingleInstanceconnection(){
		try {
			Class.forName(drivername);
			try {
				connection = DriverManager.getConnection(URL, username, password);
				if(connection!=null){
					log.info("Connected to database");
				}
			} catch (SQLException e) {
				log.info("Failed to create database connection "+e);
			} 
		} catch (ClassNotFoundException e) {
			log.info("Driver not found");
			
		}
		return connection;
	}
	public Connection getConnection() {
		return connection;
	}
	
}
