package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Hospital;
import com.example.demo.form.SearchHospitalForm;
import com.example.demo.service.HospitalService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class HospitalController {
	
	private final HospitalService hospitalService;
	private final HttpSession session;
	
	
	@GetMapping("/search-all-hospital")
    public String searchAllHospital() {
		
		hospitalService.findByAllHospital();
        return "hos-search"; 
    }
	
	@PostMapping("/search-hospital")
	private String searchHospital(
			@ModelAttribute SearchHospitalForm form,
			Model model) {
		
		session.removeAttribute("hosList");
		
		List<Hospital> list = 
				hospitalService.findByNameWildcard(form.getHospitalName());
		
		session.setAttribute("hosList", list);
		
		return "hos-search";
	}
	
	@PostMapping("/hos-detail")
	private String hosDetail(SearchHospitalForm form, Model model) {
		Hospital hospitalDetail = hospitalService.showHospitalDetail(form);
		model.addAttribute("hospital", hospitalDetail);
		return "hos-detail";
	}
	
}
