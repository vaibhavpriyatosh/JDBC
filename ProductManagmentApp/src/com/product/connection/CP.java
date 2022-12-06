package com.product.connection;

import java.sql.Connection;
import java.sql.DriverManager;
public class CP {

	public static Connection con;
	public static Connection createC() {
		
		
		try {
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Create Connection..
			String user="root";
			String password="game10122";
			String url="jdbc:mysql://localhost:3306/product_company";
			
			con=DriverManager.getConnection(url,user,password);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}

