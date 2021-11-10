package com.entities;

import java.io.Serializable;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;


/**
 * The persistent class for the REGISTROS database table.
 * 
 */
@Entity
@Table(name="REGISTROS")
@NamedQuery(name="Registro.findAll", query="SELECT r FROM Registro r")
public class Registro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REGISTROS_IDREGISTRO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REGISTROS_IDREGISTRO_GENERATOR")
	@Column(name="ID_REGISTRO")
	private long idRegistro;
	
	@ManyToOne
	@JoinColumn(name="ID_DEPARTAMENTO")
	private Departamento departamento ;
	
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA")
	private Date fechaHora;
	
	//bi-directional many-to-one association to Formulario
	@ManyToOne
	@JoinColumn(name="ID_FORMULARIO")
	private Formulario formulario;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;
	

	@Enumerated(EnumType.STRING)
	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Registro() {
	}

	public long getIdRegistro() {
		return this.idRegistro;
	}

	public void setIdRegistro(long idRegistro) {
		this.idRegistro = idRegistro;
	}

	

	

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	/*public String[][] getDatos() {
		return datos;
	}

	public void setDatos(String[][] datos) {
		this.datos = datos;
	}*/

	public Formulario getFormulario() {
		return this.formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}