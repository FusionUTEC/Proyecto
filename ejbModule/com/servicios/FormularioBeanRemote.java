package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Formulario;
import com.exception.ServiciosException;

@Remote
public interface FormularioBeanRemote {

	void crear(Formulario formulario) throws ServiciosException;

	List<Formulario> obtenerTodos();

	Formulario buscarForm(String nombre);

	void actualizar(Formulario form);

}
