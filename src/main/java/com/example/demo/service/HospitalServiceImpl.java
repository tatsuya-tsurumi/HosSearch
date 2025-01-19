package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Hospital;
import com.example.demo.form.SearchHospitalForm;
import com.example.demo.repository.HospitalRepository;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {
	
	private final HospitalRepository hospitalrepository;
	private final HttpSession session;

	@Override
	public List<Hospital> findByNameWildcard(String hospitalName) {
		List<Hospital> list = 
				hospitalrepository.selectByNameWildcard(hospitalName);
		return list;
	}

	@Override
	public void findByAllHospital() {
			List<Hospital> hosList = hospitalrepository.selectHospitalAll();
			session.setAttribute("hosList", hosList);
	}

	@Override
	public Hospital showHospitalDetail(SearchHospitalForm form) {

		Hospital hospitalDetail = hospitalrepository.selectHospitalDetail(form);
		return hospitalDetail;
	}
	
	

}
