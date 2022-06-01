package com.co.prueba.everis.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COB_AFILIADO", schema="GCCOBRANZAS")
public class AffiliateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long afiliadoId;
	
	@Column(name="NUMERO_IDENTIFICACION")
	private String numeroIdentificacion;
	
	@Column(name="TIPO_IDENTIFICACION")
	private String tipoIdentificacion;
	
	@Column(name="PRIMER_NOMBRE")
	private String primerNombre;
	
	@Column(name="SEGUNDO_NOMBRE")
	private String segundoNombre;
	
	@Column(name="PRIMER_APELLIDO")
	private String primerApellido;
	
	@Column(name="SEGUNDO_APELLIDO")
	private String segundoApellido;
	
	@Column(name="RIESGO_CAT")
	private String riesgoCat;
	
	@Column(name="ACTIVO")
	private String activo;

	public AffiliateDTO() {
	}
	
	

	public AffiliateDTO(String numeroIdentificacion, String tipoIdentificacion, String primerNombre,
			String segundoNombre, String primerApellido, String segundoApellido, String riesgoCat, String activo) {
		this.numeroIdentificacion = numeroIdentificacion;
		this.tipoIdentificacion = tipoIdentificacion;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.riesgoCat = riesgoCat;
		this.activo = activo;
	}



	public Long getAfiliadoId() {
		return afiliadoId;
	}

	public void setAfiliadoId(Long afiliadoId) {
		this.afiliadoId = afiliadoId;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getRiesgoCat() {
		return riesgoCat;
	}

	public void setRiesgoCat(String riesgoCat) {
		this.riesgoCat = riesgoCat;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Affiliate [afiliadoId=" + afiliadoId + ", numeroIdentificacion=" + numeroIdentificacion
				+ ", tipoIdentificacion=" + tipoIdentificacion + ", primerNombre=" + primerNombre + ", segundoNombre="
				+ segundoNombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido
				+ ", riesgoCat=" + riesgoCat + ", activo=" + activo + "]";
	}

}
