package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CASILLAS database table.
 * 
 */
@Entity
@Table(name="CASILLAS")
@NamedQuery(name="Casilla.findAll", query="SELECT c FROM Casilla c")
public class Casilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_CASILLA")
	private long idCasilla;

	private String descripcion;

	private String nombre;

	private String parametro;

	@Column(name="TIPO_INPUT")
	private String tipoInput;

	@Column(name="UNIDAD_MEDIDA")
	private String unidadMedida;

	//bi-directional many-to-many association to Formulario
	@ManyToMany(mappedBy="casillas", fetch = FetchType.EAGER)
	private List<Formulario> formularios;

	public Casilla() {
	}

	public long getIdCasilla() {
		return this.idCasilla;
	}

	public void setIdCasilla(long idCasilla) {
		this.idCasilla = idCasilla;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getParametro() {
		return this.parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getTipoInput() {
		return this.tipoInput;
	}

	public void setTipoInput(String tipoInput) {
		this.tipoInput = tipoInput;
	}

	public String getUnidadMedida() {
		return this.unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public List<Formulario> getFormularios() {
		return this.formularios;
	}

	public void setFormularios(List<Formulario> formularios) {
		this.formularios = formularios;
	}

}