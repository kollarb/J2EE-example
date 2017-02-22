package com.firstwebapplication.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.firstwebapplication.model.UserModel;

public class LoginDao {
	static final String DB_URL = "jdbc:mysql://mytest.cld167w3fmw5.us-east-1.rds.amazonaws.com:3306/mytest";

	static final String USER = "admin";
	static final String PASS = "admin1234";

	public static void main(String args[]){
		LoginDao loginDao= new LoginDao();
		UserModel um = new UserModel();
		um.setUserName("bharath");
		um.setPassword("Test@1234");
		loginDao.checkUserValidity(um);
	}

	public boolean checkUserValidity(UserModel um) {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			String sql = "SELECT user_id, user_password" +
			             " FROM login";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				System.out.println("successfull");
				return true;
			}
		}catch(SQLException se){
			se.printStackTrace();
			return false;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		return false;
	}

}
