package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Estacion
 *
 */
@Entity
@Table(name="ESTACIONES")

public class Estacion implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idEstacion;

	@Column(length=20)
	private String nombre;

	//DEPARTAMENTO ES CODIGUERA, COMO SE HACE?
	@Column
	private Long departamento;

	@Column
	private float latitud;

	@Column
	private float longitud;

	@Column
	private float humedadRelativa;

	@Column
	private float calidadAgua;
	
	@ManyToOne
	private Usuario idInvestigador;
	
	@Enumerated(EnumType.STRING)
	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	
	public Estacion() {
		super();
	}

	public Long getIdEstacion() {
		return idEstacion;
	}

	public void setIdEstacion(Long idEstacion) {
		this.idEstacion = idEstacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Long departamento) {
		this.departamento = departamento;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public float getHumedadRelativa() {
		return humedadRelativa;
	}

	public void setHumedadRelativa(float humedadRelativa) {
		this.humedadRelativa = humedadRelativa;
	}

	public float getCalidadAgua() {
		return calidadAgua;
	}

	public void setCalidadAgua(float calidadAgua) {
		this.calidadAgua = calidadAgua;
	}

	public Usuario getIdInvestigador() {
		return idInvestigador;
	}

	public void setIdInvestigador(Usuario idInvestigador) {
		this.idInvestigador = idInvestigador;
	}
	
	

}
