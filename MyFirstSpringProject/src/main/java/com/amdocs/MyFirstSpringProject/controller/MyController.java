package com.amdocs.MyFirstSpringProject.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apii")
public class MyController {

	String connectionUrl = "jdbc:mysql://localhost:3306/db";
	String userName = "root";
	String passWord = "Piyush@312";
	
	
	@GetMapping("testdb")
	public String testDb() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(connectionUrl, userName, passWord);
			return "Connected Successfully to: " + connectionUrl;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "Can't connect to database!!";
	}
}
