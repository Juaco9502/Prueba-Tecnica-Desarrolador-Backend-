package com.co.prueba.everis.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.co.prueba.everis.entity.CaseDTO;

public interface CasesService {
	public ResponseEntity<List<CaseDTO>> getAllCase(Long id);
	public ResponseEntity<CaseDTO> createCase(CaseDTO caseInfo);
	public ResponseEntity<CaseDTO> deleteCase(Long id);
	public ResponseEntity<CaseDTO> updateCase(Long id, CaseDTO caseInfo);
}
