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

	Usuario buscarUser(String nombreUsuario);

	Administrador buscarAdm(String nombreUsuario);

	Investigador buscarInv(String nombreUsuario);

	Usuario correoExistente(String mail);

	Usuario usuarioExistente(String nombreUsuario);

	void actualizarAf(Aficionado aficionado) throws ServiciosException;

	void actualizarIn(Investigador investigador) throws ServiciosException;

	void actualizarAd(Administrador admin) throws ServiciosException;

	void actualizar(Usuario usuario) throws ServiciosException;

	void crearAf(Aficionado aficionado) throws ServiciosException;

	void crearIn(Investigador investigador) throws ServiciosException;
	
	Administrador crearAd(Administrador administrador) throws ServiciosException;

	List<Usuario> obtenerTodos();

	void borrar(Long id) throws ServiciosException;

	Usuario ConsultaTipo(String nombreUsuario, String contraseña);

	Aficionado buscarAfi(String nombreUsuario);

	Aficionado buscarAfi(Long idusuario);

	Investigador buscarInv(Long idusuario);

	Administrador buscarAdm(Long idusuario);

	
}
