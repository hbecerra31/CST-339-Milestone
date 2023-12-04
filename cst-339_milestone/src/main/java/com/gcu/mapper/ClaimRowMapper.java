package com.gcu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.entity.ClaimEntity;

public class ClaimRowMapper implements RowMapper<ClaimEntity>{

	@Override
	public ClaimEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new ClaimEntity(rs.getLong("CLAIM_ID"), 
							   rs.getString("PATIENT_NAME"), 
							   rs.getString("DIAGNOSIS"), 
							   rs.getDate("CLAIM_DATE").toLocalDate(),
							   rs.getDouble("CLAIM_AMOUNT")
							   );
	}
	
}
