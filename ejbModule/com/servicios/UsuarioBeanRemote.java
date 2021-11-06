package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Administrador;
import com.entities.Aficionado;
import com.entities.Investigador;
import com.entities.Usuario;
import com.exception.ServiciosException;

@Remote
public interface UsuarioBeanRemote {

	Usuario login1(String nombreUsuario, String contraseña);
	Usuario ConsultaTipo(String nombreUsuario, String contraseña);
	public Usuario buscarUser(String nombreUsuario);
	public Administrador buscarAdm(String nombreUsuario);
	public Investigador buscarInv(String nombreUsuario);
	public Aficionado buscarAfi(String nombreUsuario);
	
	void crearU(Usuario usuario) throws ServiciosException;
	public  Administrador crearAd (Administrador admin) throws ServiciosException;
	void crearAf(Aficionado aficionado) throws ServiciosException;
	void crearIn(Investigador investigador) throws ServiciosException;
	
	void borrar(Long id) throws ServiciosException;
	List<Usuario> obtenerTodos();
	
	void actualizar(Usuario usuario) throws ServiciosException;
	void actualizarAf(Aficionado aficionado) throws ServiciosException;
	void actualizarIn(Investigador investigador) throws ServiciosException;
	void actualizarAd(Administrador administrador) throws ServiciosException;
	
	Usuario correoExistente(String mail);
	Usuario usuarioExistente(String nombreUsuario);

	//void crearAd(Administrador administrador) throws ServiciosException;
	//public  Usuario crearU () throws ServiciosException;
	
		
}
