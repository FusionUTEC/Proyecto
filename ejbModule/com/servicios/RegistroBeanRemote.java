package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Registro;
import com.exception.ServiciosException;

@Remote
public interface RegistroBeanRemote {
	
	Registro crear(Registro reg) throws ServiciosException;

	Registro buscar(String id_registro);

	List<Registro> obtenerTodos();

}
