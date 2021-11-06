package com.entities;

//import com.entities.Usuario;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="AFICIONADOS")
@PrimaryKeyJoinColumn(referencedColumnName="idUsuario")
public class Aficionado extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(length=20)
	private String ocupacion;
	
	
	//private static final long serialVersionUID = 1L;	
	
	public Aficionado() {
		super();
	}

	public Aficionado(String apellido, String contraseña, String mail, String nombre, String tipo, String nombreUsuario,
			String ocupacion) {
		super(apellido, contraseña, mail, nombre, tipo, nombreUsuario);
		this.ocupacion = ocupacion;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	} 
	
   
}

