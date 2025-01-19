package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Hospital;
import com.example.demo.form.SearchHospitalForm;

public interface HospitalRepository {
	List<Hospital> selectHospitalAll();
	List<Hospital> selectByNameWildcard(String hospitalName);
	Hospital selectHospitalDetail(SearchHospitalForm form);
}
