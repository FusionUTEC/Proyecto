package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Dato
 *
 */
@Entity
@Table(name="Datos")

public class Dato implements Serializable {
	
	@Id
	@SequenceGenerator(name="DATOS_IDDATO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DATOS_IDDATO_GENERATOR")
	@Column(name="ID_DATO")
	private long idDato;

	
	private static final long serialVersionUID = 1L;
	
	
	@ManyToOne
	@JoinColumn(name="ID_REGISTRO")
	private Registro registro ;
	
	@ManyToOne
	@JoinColumn(name="ID_CASILLA")
	private Casilla casilla ;
	
	@Column(name="Valor")
	private String valor ;
	
	

	public long getIdDato() {
		return idDato;
	}



	public void setIdDato(long idDato) {
		this.idDato = idDato;
	}



	public Registro getRegistro() {
		return registro;
	}



	public void setRegistro(Registro registro) {
		this.registro = registro;
	}



	public Casilla getCasilla() {
		return casilla;
	}



	public void setCasilla(Casilla casilla) {
		this.casilla = casilla;
	}



	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}



	public Dato() {
		super();
	}
   
}
