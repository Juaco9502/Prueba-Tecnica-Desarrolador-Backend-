package com.co.prueba.everis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.prueba.everis.entity.AffiliateDTO;
import com.co.prueba.everis.service.AffiliatesService;

@RestController
@RequestMapping("/api/affiliates")
public class AffiliatesController {
	
	@Autowired
	private AffiliatesService affiliatesService;

	@GetMapping("/")
	public ResponseEntity<List<AffiliateDTO>> getAllAffiliates(@RequestParam(required = false) String numeroIdentificacion) {
		
		return affiliatesService.getAllAffiliate(numeroIdentificacion);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<AffiliateDTO> createAffiliates(@RequestBody AffiliateDTO affiliate) {
		return affiliatesService.createAffiliate(affiliate);
	}
	
	@DeleteMapping("/delete/{identificacion}")
	public ResponseEntity<HttpStatus> deleteAffiliates(@PathVariable("identificacion") String numeroIdentificacion) {
		return affiliatesService.deleteAffiliate(numeroIdentificacion);
	}
	
	@PostMapping("/update/{identificacion}")
	public ResponseEntity<List<AffiliateDTO>> deleteAffiliates(@PathVariable("identificacion") String numeroIdentificacion, @RequestBody AffiliateDTO affiliateInfo) {
		return affiliatesService.updateAffiliate(numeroIdentificacion, affiliateInfo);
	}
}
