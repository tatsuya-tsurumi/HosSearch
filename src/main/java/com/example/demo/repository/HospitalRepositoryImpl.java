package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Hospital;
import com.example.demo.form.SearchHospitalForm;

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
			hos.setHospitalId(id);
			hos.setHospitalName((String)one.get("Hospital_name"));
			hos.setAddress((String)one.get("address"));
			hos.setUrl((String)one.get("url"));
			hos.setHospital_img((String)one.get("hospital_img"));
			result.add(hos);
			
		}
		
		return result;
	}

	@Override
	public List<Hospital> selectByNameWildcard(String hospitalName) {
		String sql = 
				  " SELECT 				 "
				+ " * 					 "
				+ " FROM 				 "
				+ " m_hospital 			 "
				+ " WHERE hospital_name  "
				+ " LIKE ? 				 "
				+ " ORDER BY hospital_id ";
		
		String p = "%" + hospitalName + "%";
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, p);
		
		List<Hospital> result = new ArrayList<Hospital>();
		for(Map<String, Object> one : list) {
			Hospital hos = new Hospital();
			String id = String.valueOf(one.get("hospital_id"));
			hos.setHospitalId(id);
			hos.setHospitalName((String)one.get("Hospital_name"));
			hos.setAddress((String)one.get("address"));
			hos.setUrl((String)one.get("url"));
			hos.setHospital_img((String)one.get("hospital_img"));
			result.add(hos);
		}
		
		return result;
	}

	@Override
	public Hospital selectHospitalDetail(SearchHospitalForm form) {
		
		String sql = "SELECT * FROM m_hospital WHERE hospital_id = ?";
		int hospitalId = Integer.parseInt(form.getHospitalId());
		
		Map<String, Object> list = jdbcTemplate.queryForMap(sql, hospitalId);
		
		Hospital hosDetail = new Hospital();
		hosDetail.setHospitalName((String)list.get("hospital_name"));
		hosDetail.setAddress((String)list.get("address"));
		hosDetail.setPhone((String)list.get("phone"));
		hosDetail.setSpecialities((String)list.get("specialities"));
		hosDetail.setHours((String)list.get("hours"));
		hosDetail.setNotes((String)list.get("notes"));
		

		return hosDetail;
	}

}
