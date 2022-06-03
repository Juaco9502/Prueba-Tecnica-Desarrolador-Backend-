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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "cases", description = "the cases API")
@RestController
@RequestMapping("/api/cases")
public class CasesController {
	
	@Autowired
	private CasesService casesService;

	@Operation(summary = "Get all affiliates or get affiliate by id", description = "Returns all affiliates or return affiliate with id", responses = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = CaseDTO.class))), 
			@ApiResponse(responseCode = "404", description = "Cases not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error")}
	)
	@GetMapping("/")
	public ResponseEntity<List<CaseDTO>> getAllCases(@RequestParam(required = false) Long id) throws CasesException {
		
		return casesService.getAllCase(id);
		
	}
	
	@Operation(summary = "Create a cases", description = "Add a case", responses = {
			@ApiResponse(responseCode = "201", description = "Created"),
			@ApiResponse(responseCode = "500", description = "Internal server error")}
	)
	@PostMapping("/create")
	public ResponseEntity<CaseDTO> createCases(@RequestBody CaseDTO caseInfo) throws CasesException {
		return casesService.createCase(caseInfo);
	}
	
	@Operation(summary = "Deletes a cases by id", description = "Delete a case", responses = {
			@ApiResponse(responseCode = "204", description = "No content"),
			@ApiResponse(responseCode = "500", description = "Internal server error") }
	)
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CaseDTO> deleteCases(@PathVariable("id") long id) throws CasesException {
		return casesService.deleteCase(id);
	}
	
	
	@Operation(summary = "Update a cases by id", description = "Update a case", responses = {
			@ApiResponse(responseCode = "200", description = "Successful operation"),
			@ApiResponse(responseCode = "500", description = "Internal server error") }
	)
	@PostMapping("/update/{id}")
	public ResponseEntity<CaseDTO> updateCases(@PathVariable("id") Long id, @RequestBody CaseDTO caseInfo) throws CasesException {
		return casesService.updateCase(id, caseInfo);
	}
}
