package com.steven.hrsystem.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.steven.hrsystem.soapws.GeoIPService;

@Service
public class GeoServiceImpl implements GeoService {
	
	@Autowired
	GeoIPService geoService;
	
	@Override
	public String getCountryName(String IP) {
		System.out.println("Inside the get country name method");
		return geoService.getGeoIPServiceSoap().getGeoIP(IP).getCountryName();
	}
	
	@Override
	public String getCountryCode(String IP) {
		return geoService.getGeoIPServiceSoap().getGeoIP(IP).getCountryCode();
	}
}
