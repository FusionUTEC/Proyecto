/*package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 
@Entity
@Table(name="USUARIOS")

public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUsuario;


	@Column(length=50)
	private String mail;

	@Column(length=20)
	private String nombreUsuario;


	@Column(length=20)
	private String nombre;

	@Column(length=20)
	private String apellido;

	@Column(length=10)
	private String contraseña;
	
	@Column(length=14)
	private String tipo;
	
	


	public Usuario() {
		super();

	}

	public Usuario(String nombreDeUsuario, String contraseña) {
		super();
		this.nombreUsuario = nombreDeUsuario;
		this.contraseña = contraseña;
	}

	
	public Usuario(String mail, String nombreUsuario, String nombre, String apellido, String contraseña, String tipo) {
		super();
		this.mail = mail;
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.tipo = tipo;
	
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}*/

package com.entities;

import javax.persistence.*;

@Entity
@Table(name="USUARIOS")
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idUsuario;
	
	@Column(length=14)
	private String apellido;
	
	@Column(length=14)
	private String nombre;
	
	@Column(length=20)
	private String mail;
	
	@Column(length=14)
	private String tipo;
	
	@Column(length=15)
	private String nombreUsuario;
	
	@Column(length=14)
	private String contraseña;
	
	@Enumerated(EnumType.STRING)
	private Estado estado;


	
	//private static final long serialVersionUID = 1L;	
	public Usuario() {
		super();
	}

	public Usuario(String apellido, String contraseña, String mail, String nombre, String tipo, String nombreUsuario) {
		super();
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.mail = mail;
		this.nombre = nombre;
		this.tipo = tipo;
		this.nombreUsuario = nombreUsuario;
		
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return nombre +" "+ apellido;
	} 
	
   
}


	
