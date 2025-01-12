package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Hospital;

public interface HospitalRepository {
	List<Hospital> selectHospitalAll();
}
