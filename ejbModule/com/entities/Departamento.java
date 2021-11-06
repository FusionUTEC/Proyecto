package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Departamento
 *
 */
@Entity
@Table(name="DEPARTAMENTOS")
public class Departamento implements Serializable {

	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idDepartamento;

	@Column(length=20)
	private String nombre;

	public Departamento() {
		super();
	}

	public Long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
   
}
