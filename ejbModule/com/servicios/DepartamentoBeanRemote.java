package com.servicios;
import java.util.List;
import javax.ejb.Remote;
import com.entities.Departamento;

@Remote
public interface DepartamentoBeanRemote {

	List<Departamento> obtenerTodos();

}
