package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Casilla;
import com.entities.Dato;
import com.entities.Registro;
import com.exception.ServiciosException;

@Remote
public interface DatoBeanRemote {

	List<Dato> obtenerTodos();

	Dato buscar(String id_Dato);
	
	public Dato crear(Dato reg) throws ServiciosException;



	List<Dato> obtenerDatos(Registro r);

	Dato actualizar(Registro r, Casilla c, String v);

}
