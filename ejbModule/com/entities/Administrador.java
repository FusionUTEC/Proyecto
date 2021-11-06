package com.entities;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="ADMINISTRADORES")
@PrimaryKeyJoinColumn(referencedColumnName="idUsuario")
public class Administrador extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(length=20)
	private String ciudad;
	
	@Column(length=20)
	private String documento;
	
	@Column(length=20)
	private String domicilio;
	
	@Column(length=20)
	private String telefono;
	
	//private static final long serialVersionUID = 1L;
	
	public Administrador() {
		super();
	}

	public Administrador(String apellido, String contraseña, String mail, String nombre, String tipo, String nombreUsuario,
			String ciudad, String documento, String domicilio, String telefono) {
		super(apellido, contraseña, mail, nombre, tipo, nombreUsuario);
		this.ciudad = ciudad;
		this.documento = documento;
		this.domicilio = domicilio;
		this.telefono = telefono;
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
	
   
}

