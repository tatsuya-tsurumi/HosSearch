package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Hospital;
import com.example.demo.form.SearchHospitalForm;

public interface HospitalService {
	List<Hospital> findByNameWildcard(String hospitalName);
	void findByAllHospital();
	Hospital showHospitalDetail(SearchHospitalForm form);
}
