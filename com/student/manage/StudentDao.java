package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
public class StudentDao {

	public static boolean insertStudentToDao(Student st) {
		
		boolean f = false;
		
		try {
			//jdbc code
			Connection con = CP.createC();
			String q = "insert into Students(sname, sphone, scity) values(?, ?, ?)";	
			
			//PreparedStatement for adding new data into db
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the value of parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute
			pstmt.executeUpdate();
			f = true;
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudentId(int userId) {
		
		boolean f = false;
		
		try {
			//jdbc code
			Connection con = CP.createC();
			String q = "delete from students where sid = ?";	
			
			//PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the value of parameter
			pstmt.setInt(1, userId);
			
			
			//execute
			pstmt.executeUpdate();
			f = true;
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	  return f;
	}

	public static void displayAll() {
		
		try {
			//jdbc code
			Connection con = CP.createC();
			String q = "select * from students";	
			
			Statement stmt = con.createStatement();	
			
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				
				System.out.println("Id : " + id);
				System.out.println("Name : " + name);
				System.out.println("Phone : " + phone);
				System.out.println("City : " + city);
				System.out.println("-------------------------");
			}	
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	 
	}

	public static boolean updateStudentPhone(Student st) {
		
		boolean f = false;
		
		try {
			//jdbc code
			Connection con = CP.createC();
			String q = "UPDATE students SET sphone = ? WHERE sname = ?";	
			
			//PreparedStatement for adding new data into db
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the value of parameter
			pstmt.setString(1, st.getStudentPhone());
			pstmt.setString(2, st.getStudentName());
			
			
			//execute
			pstmt.executeUpdate();
			f = true;
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
		
	}

	public static boolean updateStudentCity(Student st) {
boolean f = false;
		
		try {
			//jdbc code
			Connection con = CP.createC();
			String q = "UPDATE students SET scity = ? WHERE sid = ?";	
			
			//PreparedStatement for adding new data into db
			PreparedStatement pstmt = con.prepareStatement(q);
			
			//set the value of parameter
			pstmt.setString(1, st.getStudentCity());
			pstmt.setInt(2, st.getStudentId());
			
			
			//execute
			pstmt.executeUpdate();
			f = true;
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
		
}
