package com.co.prueba.everis.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COB_CASO", schema="GCCOBRANZAS")
public class CaseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long casoId;
	
	@Column(name="PROCESO")
	private String proceso;
	
	@Column(name="PROCESO_ETAPA")
	private String procesoEtapa;
	
	@Column(name="FECHA_ACTUAL_ETAPA")
	private LocalDateTime fechaActualEtapa;
	
	@Column(name="CLASIFICACION_DEUDA")
	private String clasificacionDeuda;
	
	@Column(name="ORIGEN_ASIGNACION_CAT")
	private String origenAsignacionCat;
	
	@Column(name="COMPORTAMIENTO")
	private int comportamiento;
	
	@Column(name="TIPO_IDENTIFICACION_EMP")
	private String tipoIdentificacionEmp;
	
	@Column(name="NUMERO_IDENTIFICACION_EMP")
	private String numeroIdentificacionEmp;

	@Column(name="RIESGO_EMP_CAT")
	private String riesgoEmpCat;
	
	@Column(name="PERIODO_COSECHA")
	private int periodoCosecha;
	
	@Column(name="FECHA_ULTIMO_PAGO")
	private LocalDateTime fechaUltimaPago;
	
	@Column(name="FECHA_INICIO_CASO")
	private LocalDateTime fechaInicioCaso;
	
	@Column(name="FECHA_INICIO_PROCESO")
	private LocalDateTime fechaInicioProceso;

	public CaseDTO() {
	
	}
	

	public CaseDTO(String proceso, String procesoEtapa, LocalDateTime fechaActualEtapa, String clasificacionDeuda,
			String origenAsignacionCat, int comportamiento, String tipoIdentificacionEmp,
			String numeroIdentificacionEmp, String riesgoEmpCat, int periodoCosecha, LocalDateTime fechaUltimaPago,
			LocalDateTime fechaInicioCaso, LocalDateTime fechaInicioProceso) {
		super();
		this.proceso = proceso;
		this.procesoEtapa = procesoEtapa;
		this.fechaActualEtapa = fechaActualEtapa;
		this.clasificacionDeuda = clasificacionDeuda;
		this.origenAsignacionCat = origenAsignacionCat;
		this.comportamiento = comportamiento;
		this.tipoIdentificacionEmp = tipoIdentificacionEmp;
		this.numeroIdentificacionEmp = numeroIdentificacionEmp;
		this.riesgoEmpCat = riesgoEmpCat;
		this.periodoCosecha = periodoCosecha;
		this.fechaUltimaPago = fechaUltimaPago;
		this.fechaInicioCaso = fechaInicioCaso;
		this.fechaInicioProceso = fechaInicioProceso;
	}


	public Long getCasoId() {
		return casoId;
	}


	public void setCasoId(Long casoId) {
		this.casoId = casoId;
	}


	public String getProceso() {
		return proceso;
	}


	public void setProceso(String proceso) {
		this.proceso = proceso;
	}


	public String getProcesoEtapa() {
		return procesoEtapa;
	}


	public void setProcesoEtapa(String procesoEtapa) {
		this.procesoEtapa = procesoEtapa;
	}


	public LocalDateTime getFechaActualEtapa() {
		return fechaActualEtapa;
	}


	public void setFechaActualEtapa(LocalDateTime fechaActualEtapa) {
		this.fechaActualEtapa = fechaActualEtapa;
	}


	public String getClasificacionDeuda() {
		return clasificacionDeuda;
	}


	public void setClasificacionDeuda(String clasificacionDeuda) {
		this.clasificacionDeuda = clasificacionDeuda;
	}


	public String getOrigenAsignacionCat() {
		return origenAsignacionCat;
	}


	public void setOrigenAsignacionCat(String origenAsignacionCat) {
		this.origenAsignacionCat = origenAsignacionCat;
	}


	public int getComportamiento() {
		return comportamiento;
	}


	public void setComportamiento(int comportamiento) {
		this.comportamiento = comportamiento;
	}


	public String getTipoIdentificacionEmp() {
		return tipoIdentificacionEmp;
	}


	public void setTipoIdentificacionEmp(String tipoIdentificacionEmp) {
		this.tipoIdentificacionEmp = tipoIdentificacionEmp;
	}


	public String getNumeroIdentificacionEmp() {
		return numeroIdentificacionEmp;
	}


	public void setNumeroIdentificacionEmp(String numeroIdentificacionEmp) {
		this.numeroIdentificacionEmp = numeroIdentificacionEmp;
	}


	public String getRiesgoEmpCat() {
		return riesgoEmpCat;
	}


	public void setRiesgoEmpCat(String riesgoEmpCat) {
		this.riesgoEmpCat = riesgoEmpCat;
	}


	public int getPeriodoCosecha() {
		return periodoCosecha;
	}


	public void setPeriodoCosecha(int periodoCosecha) {
		this.periodoCosecha = periodoCosecha;
	}


	public LocalDateTime getFechaUltimaPago() {
		return fechaUltimaPago;
	}


	public void setFechaUltimaPago(LocalDateTime fechaUltimaPago) {
		this.fechaUltimaPago = fechaUltimaPago;
	}


	public LocalDateTime getFechaInicioCaso() {
		return fechaInicioCaso;
	}


	public void setFechaInicioCaso(LocalDateTime fechaInicioCaso) {
		this.fechaInicioCaso = fechaInicioCaso;
	}


	public LocalDateTime getFechaInicioProceso() {
		return fechaInicioProceso;
	}


	public void setFechaInicioProceso(LocalDateTime fechaInicioProceso) {
		this.fechaInicioProceso = fechaInicioProceso;
	}


	@Override
	public String toString() {
		return "CaseDTO [casoId=" + casoId + ", proceso=" + proceso + ", procesoEtapa=" + procesoEtapa
				+ ", fechaActualEtapa=" + fechaActualEtapa + ", clasificacionDeuda=" + clasificacionDeuda
				+ ", origenAsignacionCat=" + origenAsignacionCat + ", comportamiento=" + comportamiento
				+ ", tipoIdentificacionEmp=" + tipoIdentificacionEmp + ", numeroIdentificacionEmp="
				+ numeroIdentificacionEmp + ", riesgoEmpCat=" + riesgoEmpCat + ", periodoCosecha=" + periodoCosecha
				+ ", fechaUltimaPago=" + fechaUltimaPago + ", fechaInicioCaso=" + fechaInicioCaso
				+ ", fechaInicioProceso=" + fechaInicioProceso + "]";
	}
     
	

}
