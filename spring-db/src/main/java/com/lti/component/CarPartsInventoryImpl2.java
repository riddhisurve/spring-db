package com.lti.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carParts2")
public class CarPartsInventoryImpl2 implements CarPartsInventory{

	@Autowired
	private DataSource dataSource;
	
	public void addNewPart(CarPart carPart) {
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=dataSource.getConnection();
		String sql="insert into TBL_CarParts values(?,?,?,?)";
		stmt=conn.prepareStatement(sql);
		stmt.setInt(1, carPart.getPartNo());
		stmt.setString(2, carPart.getName());
		stmt.setString(3, carPart.getCarModel());
		stmt.setInt(4, carPart.getQuantity());
		stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
		try {
		stmt.close();
		}
		catch(Exception e) {
		}
		try {
			conn.close();
			}
			catch(Exception e) {
			}
		}
	}

	public List<CarPart> getAvailableParts() {
		Connection conn=null;
		PreparedStatement stmt=null;
		List<CarPart> list=new ArrayList<CarPart>();
		CarPart cp=new CarPart();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish connection
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			String sql="select * from TBL_CarParts";
			stmt=conn.prepareStatement(sql);
			
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				cp.setPartNo(rs.getInt(1));
				cp.setName(rs.getString(2));
				cp.setCarModel(rs.getString(3));
				cp.setQuantity(rs.getInt(4));
				
				list.add(cp);
			}
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not found");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {stmt.close();} catch(Exception e) {}
			try {conn.close();} catch(Exception e) {}
		}
		return list;		
	}

}
