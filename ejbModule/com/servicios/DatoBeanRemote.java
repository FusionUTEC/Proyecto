package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Dato;
import com.exception.ServiciosException;

@Remote
public interface DatoBeanRemote {

	List<Dato> obtenerTodos();

	Dato buscar(String id_Dato);
	
	public Dato crear(Dato reg) throws ServiciosException;

}
