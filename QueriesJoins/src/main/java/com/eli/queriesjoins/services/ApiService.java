package com.eli.queriesjoins.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eli.queriesjoins.repositories.CityRepo;
import com.eli.queriesjoins.repositories.CountryRepo;
import com.eli.queriesjoins.repositories.LanguageRepo;

@Service
public class ApiService {
	private final CountryRepo cR;
	private final LanguageRepo lR;
	private final CityRepo ctyR;
	
	public ApiService(CountryRepo cR, LanguageRepo lR, CityRepo ctyR) {
		this.cR = cR;
		this.lR = lR;
		this.ctyR = ctyR;
	}
	
	public List<Object[]> question1(String language){
		return cR.countrySpeaksLanguageByPercentage(language);
	}

}
