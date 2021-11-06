package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Casilla;
import com.entities.Formulario;
import com.exception.ServiciosException;

@Remote
public interface FormularioBeanRemote {
	
	
	public Formulario crear(Formulario form) throws ServiciosException;
	Formulario buscarForm(String nombre);
	List<Formulario> obtenerTodos();
	void borrar(Long id) throws ServiciosException;
	void actualizar(Formulario form) throws ServiciosException;
	public List<Casilla> buscarContiene (Long id);
}