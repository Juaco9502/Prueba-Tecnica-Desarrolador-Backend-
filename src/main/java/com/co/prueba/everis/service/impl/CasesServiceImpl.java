package com.co.prueba.everis.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.prueba.everis.entity.CaseDTO;
import com.co.prueba.everis.repository.CasesRepository;
import com.co.prueba.everis.service.CasesService;

@Service
public class CasesServiceImpl implements CasesService {
	
	@Autowired
	private CasesRepository casesRepository;
	
	public ResponseEntity<List<CaseDTO>> getAllCase(Long id) {
		try {
			List<CaseDTO> cases = new ArrayList<>();
			if (id == null) {
				casesRepository.findAll().forEach(cases::add);
			}else {
				Optional<CaseDTO> caso = casesRepository.findById(id);
				if(caso.isPresent()) {
					cases.add(caso.get());
				}
			}
			
			if (cases.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(cases, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	public ResponseEntity<CaseDTO> createCase(CaseDTO caseInfo) {
		try {
			CaseDTO newCase = casesRepository.save(new CaseDTO(caseInfo.getProceso(), caseInfo.getProcesoEtapa(), caseInfo.getFechaActualEtapa(), caseInfo.getClasificacionDeuda(), caseInfo.getOrigenAsignacionCat(), caseInfo.getComportamiento(), caseInfo.getTipoIdentificacionEmp(), caseInfo.getNumeroIdentificacionEmp(), caseInfo.getRiesgoEmpCat(), caseInfo.getPeriodoCosecha(),  caseInfo.getFechaUltimaPago(), caseInfo.getFechaInicioCaso(), caseInfo.getFechaInicioProceso()));
			return new ResponseEntity<>(newCase, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	public ResponseEntity<CaseDTO> deleteCase(Long id) {
		try {
			Optional<CaseDTO> caso = casesRepository.findById(id);
			
			if(caso.isPresent()) {
				casesRepository.deleteById(id);
			}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<CaseDTO> updateCase(Long id, CaseDTO caseInfo) {
		try {
			Optional<CaseDTO> caso = casesRepository.findById(id);
			
			if(caso.isPresent()) {
				caso.get().setProceso(caseInfo.getProceso());
				caso.get().setProcesoEtapa(caseInfo.getProcesoEtapa());
				caso.get().setFechaActualEtapa(caseInfo.getFechaActualEtapa());
				caso.get().setClasificacionDeuda(caseInfo.getClasificacionDeuda());
				caso.get().setOrigenAsignacionCat(caseInfo.getOrigenAsignacionCat());
				caso.get().setComportamiento(caseInfo.getComportamiento());
				caso.get().setTipoIdentificacionEmp(caseInfo.getTipoIdentificacionEmp());
				caso.get().setNumeroIdentificacionEmp(caseInfo.getNumeroIdentificacionEmp());
				caso.get().setRiesgoEmpCat(caseInfo.getRiesgoEmpCat());
				caso.get().setPeriodoCosecha(caseInfo.getPeriodoCosecha());
				caso.get().setFechaUltimaPago(caseInfo.getFechaUltimaPago());
				caso.get().setFechaInicioCaso(caseInfo.getFechaInicioCaso());
				caso.get().setFechaInicioProceso(caseInfo.getFechaInicioProceso());
				
			}
			
			return new ResponseEntity<>(caso.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
