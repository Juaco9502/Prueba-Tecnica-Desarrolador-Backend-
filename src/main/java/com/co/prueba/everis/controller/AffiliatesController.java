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
import com.co.prueba.everis.exception.AffiliatesException;
import com.co.prueba.everis.service.AffiliatesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "affiliates", description = "the affiliates API")
@RestController
@RequestMapping("/api/affiliates")
public class AffiliatesController {
	
	@Autowired
	private AffiliatesService affiliatesService;

	@Operation(summary = "Get all affiliates or get affiliates by numero identificacion", description = "Returns all affiliates or return affiliates with numero identificacion", responses = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = AffiliateDTO.class))), 
			@ApiResponse(responseCode = "404", description = "Affiliates not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error")}
	)
	@GetMapping("/")
	public ResponseEntity<List<AffiliateDTO>> getAllAffiliates(@RequestParam(required = false) String numeroIdentificacion) throws AffiliatesException {
		
		return affiliatesService.getAllAffiliate(numeroIdentificacion);
		
	}
	
	
	@Operation(summary = "Create a affiliates", description = "Add a affiliate", responses = {
			@ApiResponse(responseCode = "201", description = "Created"),
			@ApiResponse(responseCode = "500", description = "Internal server error")}
	)
	@PostMapping("/create")
	public ResponseEntity<AffiliateDTO> createAffiliates(@RequestBody AffiliateDTO affiliate) throws AffiliatesException {
		return affiliatesService.createAffiliate(affiliate);
	}
	
	@Operation(summary = "Deletes a affiliates by numero identificacion", description = "Delete a affiliate", responses = {
			@ApiResponse(responseCode = "204", description = "No content"),
			@ApiResponse(responseCode = "500", description = "Internal server error") }
	)
	@DeleteMapping("/delete/{identificacion}")
	public ResponseEntity<HttpStatus> deleteAffiliates(@PathVariable("identificacion") String numeroIdentificacion) throws AffiliatesException {
		return affiliatesService.deleteAffiliate(numeroIdentificacion);
	}
	
	
	@Operation(summary = "Update a affiliates by numero identificacion", description = "Update a affiliate", responses = {
			@ApiResponse(responseCode = "200", description = "Successful operation"),
			@ApiResponse(responseCode = "500", description = "Internal server error") }
	)
	@PostMapping("/update/{identificacion}")
	public ResponseEntity<List<AffiliateDTO>> updateAffiliates(@PathVariable("identificacion") String numeroIdentificacion, @RequestBody AffiliateDTO affiliateInfo) throws AffiliatesException {
		return affiliatesService.updateAffiliate(numeroIdentificacion, affiliateInfo);
	}
	
	@Operation(summary = "Get all affiliates by creation date", description = "Returns all affiliates with creation date", responses = {
			@ApiResponse(responseCode = "200", description = "Successful operation" , content = @Content(schema = @Schema(implementation = AffiliateDTO.class))), 
			@ApiResponse(responseCode = "204", description = "No content"),
			@ApiResponse(responseCode = "500", description = "Internal server error") }
	)
	@GetMapping("/creationdate/{date}")
	public ResponseEntity<List<AffiliateDTO>> getAffiliateByCreationDate(@PathVariable("date") String fechaCreacion) throws AffiliatesException {
		return affiliatesService.getAffiliateByCreationDate(fechaCreacion);
		
	}
}
