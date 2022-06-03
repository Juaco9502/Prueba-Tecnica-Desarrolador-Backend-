package com.co.prueba.everis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.co.prueba.everis.entity.AffiliateDTO;

public interface AffiliatesRepository extends JpaRepository<AffiliateDTO, Long> {

	List<AffiliateDTO> findByNumeroIdentificacion(String numeroIdentificacion);
	
	@Query(value = "SELECT * FROM Goya.GCCOBRANZAS.COB_AFILIADO WHERE CONVERT(DATETIME, FLOOR(CONVERT(FLOAT, FECHA_CREACION))) = :fechaCreacion", nativeQuery = true)
	List<AffiliateDTO> findByFechaCreacion(String fechaCreacion);

}