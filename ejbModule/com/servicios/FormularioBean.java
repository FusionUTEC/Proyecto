package com.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.entities.Aficionado;
import com.entities.Formulario;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class FormularioBean
 */
@Stateless
@LocalBean
public class FormularioBean implements FormularioBeanRemote {
	
	
	@PersistenceContext  
	private EntityManager em;
	
	@Override
	public void crear(Formulario formulario) throws ServiciosException {
		try{
			em.persist(formulario);
			em.flush();

		}catch(PersistenceException e){ throw new
			ServiciosException("No se pudo crear la el formulario"); 
		}
	}

    /**
     * Default constructor. 
     */
    public FormularioBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Formulario> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Formulario buscarForm(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Formulario form) {
		// TODO Auto-generated method stub
		
	}

}
