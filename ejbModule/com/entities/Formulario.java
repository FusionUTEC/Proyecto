package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the FORMULARIOS database table.
 * 
 */
@Entity
@Table(name="FORMULARIOS")
@NamedQuery(name="Formulario.findAll", query="SELECT f FROM Formulario f")
public class Formulario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FORMULARIOS_IDFORMULARIO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORMULARIOS_IDFORMULARIO_GENERATOR")
	@Column(name="ID_FORMULARIO")
	private long idFormulario;

	private String comentarios;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA")
	private Date fechaHora;

	@Column(name="ID_USUARIO")
	private Long idUsuario;

	@Column(name="METODO_MEDICION")
	private String metodoMedicion;

	private String nombre;

	@Column(name="NOMBRE_VARIABLE")
	private String nombreVariable;


	/*/bi-directional many-to-many association to Casilla
	@ManyToMany
	
	private List<Casilla> casillas;*/
	
	
	
	@ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(
			name="CONTIENE",
			joinColumns= @JoinColumn(name="ID_FORMULARIO"),
			inverseJoinColumns= @JoinColumn(name="ID_CASILLA")	
			)
	private List<Casilla> casillas;
	
	@Enumerated(EnumType.STRING)
	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	
	//bi-directional many-to-one association to Registro
	//@OneToMany(mappedBy="formulario")
	//private List<Registro> registros;

	public Formulario() {
	}

	public long getIdFormulario() {
		return this.idFormulario;
	}

	public void setIdFormulario(long idFormulario) {
		this.idFormulario = idFormulario;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUser) {
		this.idUsuario = idUser;
	}

	public String getMetodoMedicion() {
		return this.metodoMedicion;
	}

	public void setMetodoMedicion(String metodoMedicion) {
		this.metodoMedicion = metodoMedicion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreVariable() {
		return this.nombreVariable;
	}

	public void setNombreVariable(String nombreVariable) {
		this.nombreVariable = nombreVariable;
	}


	public List<Casilla> getCasillas() {
		return this.casillas;
	}

	public void setCasillas(List<Casilla> casillas) {
		this.casillas = casillas;
	}
	

}