package com.co.prueba.everis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.co.prueba.everis.entity.AffiliateDTO;

public interface AffiliatesRepository extends JpaRepository<AffiliateDTO, Long> {

	List<AffiliateDTO> findByNumeroIdentificacion(String numeroIdentificacion);

}