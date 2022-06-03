package com.co.prueba.everis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.prueba.everis.entity.AffiliateDTO;
import com.co.prueba.everis.repository.AffiliatesRepository;
import com.co.prueba.everis.service.AffiliatesService;

@Service
public class AffiliatesServiceImpl implements AffiliatesService {
	
	@Autowired
	private AffiliatesRepository affiliatesRepository;
	
	public ResponseEntity<List<AffiliateDTO>> getAllAffiliate(String numeroIdentificacion) {
		try {
			List<AffiliateDTO> affiliates = new ArrayList<>();
			if (numeroIdentificacion == null) {
				affiliatesRepository.findAll().forEach(affiliates::add);
			}else {
				affiliatesRepository.findByNumeroIdentificacion(numeroIdentificacion).forEach(affiliates::add);
			
			}
			
			if (affiliates.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(affiliates, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<List<AffiliateDTO>> getAffiliateByCreationDate(String fechaCreacion) {
		try {
			List<AffiliateDTO> affiliates = new ArrayList<>();
			if (fechaCreacion != null) {
				affiliatesRepository.findByFechaCreacion(fechaCreacion).forEach(affiliates::add);
			}
			
			if (affiliates.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(affiliates, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	public ResponseEntity<AffiliateDTO> createAffiliate(AffiliateDTO affiliate) {
		try {
			AffiliateDTO newAffiliate = affiliatesRepository.save(new AffiliateDTO(affiliate.getNumeroIdentificacion(), affiliate.getTipoIdentificacion(), affiliate.getPrimerNombre(), affiliate.getSegundoNombre(), affiliate.getPrimerApellido(), affiliate.getSegundoApellido(), affiliate.getRiesgoCat(), affiliate.getActivo(), affiliate.getFechaCreacion()));
			return new ResponseEntity<>(newAffiliate, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	public ResponseEntity<HttpStatus> deleteAffiliate(String numeroIdentificacion) {
		try {
			List<AffiliateDTO> affiliates = new ArrayList<>();
			affiliatesRepository.findByNumeroIdentificacion(numeroIdentificacion).forEach(affiliates::add);
			
			for (AffiliateDTO aff : affiliates) {
				affiliatesRepository.deleteById(aff.getAfiliadoId());		
			}
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<List<AffiliateDTO>> updateAffiliate(String numeroIdentificacion, AffiliateDTO affiliateInfo) {
		try {
			List<AffiliateDTO> affiliates = new ArrayList<>();
			affiliatesRepository.findByNumeroIdentificacion(numeroIdentificacion).forEach(affiliates::add);
			
			for (AffiliateDTO aff : affiliates) {
				aff.setNumeroIdentificacion(affiliateInfo.getNumeroIdentificacion());
				aff.setTipoIdentificacion(affiliateInfo.getTipoIdentificacion());
				aff.setPrimerNombre(affiliateInfo.getPrimerNombre());
				aff.setPrimerApellido(affiliateInfo.getPrimerApellido());
				aff.setSegundoApellido(affiliateInfo.getSegundoApellido());
				aff.setRiesgoCat(affiliateInfo.getRiesgoCat());
				aff.setActivo(affiliateInfo.getActivo());
				affiliatesRepository.save(aff);
			}
			
			return new ResponseEntity<>(affiliates, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
