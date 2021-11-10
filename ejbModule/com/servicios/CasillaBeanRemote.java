package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Casilla;
import com.entities.Formulario;
import com.exception.ServiciosException;

@Remote
public interface CasillaBeanRemote {

	List<Casilla> obtenerTodos();
	Casilla buscar(String nombre);
	void actualizar(Casilla casilla);
	Casilla crear(Casilla casilla) throws ServiciosException;
//	Casilla buscarId(Long id) throws ServiciosException;
	Formulario buscarCas();

}
