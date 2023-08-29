package com.learning.learningspring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class jdbcStudent {
	public static void insertdata(Student student) {
		Connection cnx = null;
		 PreparedStatement stmt = null;
		 try {
			
			 String insert ="insert into studentData (name, score) values(?,?)";
			 cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentdb","saisidharthak","root");
			 System.out.println("hello");
			 stmt= cnx.prepareStatement(insert);
			 stmt.setString(1, student.name);
			 stmt.setInt(2, student.score);
			
			 stmt.executeUpdate();
			 
		 
		 stmt.close();
		 cnx.close();
	}
	
 catch(Exception e) {
	 e.printStackTrace();
 }

}}
