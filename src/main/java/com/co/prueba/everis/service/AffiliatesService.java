package com.co.prueba.everis.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.co.prueba.everis.entity.AffiliateDTO;

public interface AffiliatesService {

	public ResponseEntity<List<AffiliateDTO>> getAllAffiliate(String numeroIdentificacion);
	public ResponseEntity<AffiliateDTO> createAffiliate(AffiliateDTO affiliate);
	public ResponseEntity<HttpStatus> deleteAffiliate(String numeroIdentificacion);
	public ResponseEntity<List<AffiliateDTO>> updateAffiliate(String numeroIdentificacion, AffiliateDTO affiliateInfo);
}
