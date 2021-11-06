package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_FORMULARIO")
	private long idFormulario;

	private String comentarios;

	//@Temporal(TemporalType.DATE)
	@Column(name="FECHA_HORA")
	private Timestamp fechaHora;

	@Column(name="ID_USUARIO")
	private Long idUsuario;

	private String nombre;

	private String ubicacion;
	
	
	@ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(
			name="CONTIENE",
			joinColumns= @JoinColumn(name="ID_FORMULARIO"),
			inverseJoinColumns= @JoinColumn(name="ID_CASILLA")	
			)
	private List<Casilla> casillas;
	
	
	@Enumerated(EnumType.STRING)
	private Estado estado;


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

	public Timestamp getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUser) {
		this.idUsuario = idUser;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Casilla> getCasillas() {
		return this.casillas;
	}

	public void setCasillas(List<Casilla> casillas) {
		this.casillas = casillas;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	

}