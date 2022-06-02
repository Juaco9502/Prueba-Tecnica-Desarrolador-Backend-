package com.co.prueba.everis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.co.prueba.everis.entity.CaseDTO;
import com.co.prueba.everis.exception.CasesException;
import com.co.prueba.everis.service.CasesService;

@RestController
@RequestMapping("/api/cases")
public class CasesController {
	
	@Autowired
	private CasesService casesService;

	@GetMapping("/")
	public ResponseEntity<List<CaseDTO>> getAllCases(@RequestParam(required = false) Long id) throws CasesException {
		
		return casesService.getAllCase(id);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<CaseDTO> createCases(@RequestBody CaseDTO caseInfo) throws CasesException {
		return casesService.createCase(caseInfo);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CaseDTO> deleteCases(@PathVariable("id") long id) throws CasesException {
		return casesService.deleteCase(id);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<CaseDTO> deleteCases(@PathVariable("id") Long id, @RequestBody CaseDTO caseInfo) throws CasesException {
		return casesService.updateCase(id, caseInfo);
	}
}
