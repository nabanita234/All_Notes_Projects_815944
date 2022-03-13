package com.dev.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dev.web.model.Alien;

public class AlienDao {
	Statement st;
	Connection conn;
	PreparedStatement statement;

	public AlienDao() throws Exception {
		super();
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "Nabatina@123");
		st = conn.createStatement();
	}

	public Alien getAlien(int aid) {
		Alien a = new Alien();

		try {
			
			ResultSet rs = st.executeQuery("select * from alien where aid= " + aid);
			if (rs.next()) {
				a.setAid(rs.getInt("aid"));
				a.setAname(rs.getString("aname"));
				a.setTech(rs.getString("tech"));

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return a;
	}
	
	public int postAlien(int aid,String name,String tech) throws Exception
	{
		
		statement =conn.prepareStatement("insert into alien values(?,?,?);");
		statement.setInt(1, aid);
		statement.setString(2, name);
		statement.setString(3, tech);
		int executeUpdate = statement.executeUpdate();
		return executeUpdate;

		
	}

}
