package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Hospital;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class HospitalRepositoryImpl implements HospitalRepository {
	
	private final JdbcTemplate jdbcTemplate;

	@Override
	public List<Hospital> selectHospitalAll() {
		
		String sql = "SELECT * FROM m_hospital ORDER BY hospital_id;";
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		
		List<Hospital> result = new ArrayList<Hospital>();
		
		for(Map<String, Object> one : list) {
			Hospital hos = new Hospital();
			String id = String.valueOf(one.get("hospital_id"));
			hos.setHospital_id(id);
			hos.setHospital_name((String)one.get("Hospital_name"));
			hos.setAddress((String)one.get("address"));
			hos.setUrl((String)one.get("url"));
			hos.setHospital_img((String)one.get("hospital_img"));
			result.add(hos);
			
		}
		
		return result;
	}

}
