package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Departamento;
import com.entities.Estacion;
import com.exception.ServiciosException;

@Remote
public interface EstacionBeanRemote {
	
	void actualizar(Estacion estacion) throws ServiciosException;
	public Estacion buscarEst(String nombre);
	void borrar(Long id) throws ServiciosException;
	List<Estacion> obtenerTodos();
	//void crear(Estacion estacion) throws ServiciosException;
	public Estacion crear(Estacion estacion) throws ServiciosException;
	
}
