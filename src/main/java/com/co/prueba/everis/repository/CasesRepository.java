package com.co.prueba.everis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.prueba.everis.entity.CaseDTO;

public interface CasesRepository extends JpaRepository<CaseDTO, Long>{

}
