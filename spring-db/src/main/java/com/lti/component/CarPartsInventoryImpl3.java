package com.lti.component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("carParts3")
public class CarPartsInventoryImpl3 implements CarPartsInventory{

	@Autowired
	private DataSource dataSource;
	
	public void addNewPart(CarPart carPart) {
		JdbcTemplate jt=new JdbcTemplate(dataSource);
		jt.update("insert into TBL_CarParts values(?,?,?,?)",
						carPart.getPartNo(),
						carPart.getName(),
						carPart.getCarModel(),
						carPart.getQuantity());
	}
	
	class CarPartRowMapper implements RowMapper<CarPart>{

		public CarPart mapRow(ResultSet rs, int rowNum) throws SQLException {
			CarPart cp=new CarPart();
			cp.setPartNo(rs.getInt(1));
			cp.setName(rs.getString(2));
			cp.setCarModel(rs.getString(3));
			cp.setQuantity(rs.getInt(4));
			
			return cp;
		}
		
	}

	public List<CarPart> getAvailableParts() {
		JdbcTemplate jt=new JdbcTemplate(dataSource);
		List<CarPart> list=jt.query("select * from TBL_CarParts where partno=111", new CarPartRowMapper());
		return list;
	}
}