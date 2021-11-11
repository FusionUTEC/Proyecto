package com.servicios;
import java.util.List;
import javax.ejb.Remote;

import com.entities.Dato;
import com.entities.Departamento;
import com.exception.ServiciosException;

@Remote
public interface DepartamentoBeanRemote {

	List<Departamento> obtenerTodos();

	Departamento buscar(String nombre);
	

}
