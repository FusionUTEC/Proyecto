package com.entities;

import java.io.Serializable;
import javax.persistence.*;


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

	private String datos;

	//bi-directional many-to-one association to Formulario
	@ManyToOne
	@JoinColumn(name="ID_FORMULARIO")
	private Formulario formulario;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public Registro() {
	}

	public long getIdRegistro() {
		return this.idRegistro;
	}

	public void setIdRegistro(long idRegistro) {
		this.idRegistro = idRegistro;
	}

	public String getDatos() {
		return this.datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

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