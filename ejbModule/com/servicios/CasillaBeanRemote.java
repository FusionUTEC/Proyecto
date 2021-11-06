package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Casilla;

@Remote
public interface CasillaBeanRemote {

	List<Casilla> obtenerTodos();

	Casilla buscar(String nombre);

}
