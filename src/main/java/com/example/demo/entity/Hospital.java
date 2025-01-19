package com.example.demo.entity;

import lombok.Data;

@Data
public class Hospital {
	private String hospitalId; 
	private String hospitalName; 
	private String address;
	private String phone;
	private String specialities;
	private String hours;
	private String notes;
	private String url; 
	private String hospital_img ;
}
