package com.MeuTeatroPortal.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {


private String url = "jdbc:mysql://localhost:3306/meuteatroportal";
private String usuario = "root";
private String senha ="qwertyuiop";
	
	
	
public Connection getConnection(){
	try{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		return DriverManager.getConnection(url,usuario,senha);
	}catch(SQLException e){
	
	throw new RuntimeException(e);
	}
	
}
}
