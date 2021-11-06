package com.entities;

//import com.entities.Usuario;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="INVESTIGADORES")
@PrimaryKeyJoinColumn(referencedColumnName="idUsuario")
public class Investigador extends Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ciudad;
	private String documento;
	private String domicilio;
	private String telefono;
	
	//bi-directional many-to-one association to Estaciones
	@OneToMany
	private List<Estacion> estaciones;
	
	//private static final long serialVersionUID = 1L;	
	public Investigador() {
		super();
	}

	public Investigador(String apellido, String contraseña, String mail, String nombre, String tipo, String nombreUsuario
			,String ciudad, String documento, String domicilio, String telefono, List<Estacion> estaciones) {
		super(apellido, contraseña, mail, nombre, tipo, nombreUsuario);
		this.ciudad = ciudad;
		this.documento = documento;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.estaciones = estaciones;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Estacion> getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(List<Estacion> estaciones) {
		this.estaciones = estaciones;
	} 
	
   
}

