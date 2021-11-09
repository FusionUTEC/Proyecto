package com.servicios;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.entities.Formulario;
import com.entities.Registro;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class RegistroBean
 */
@Stateless
public class RegistroBean implements RegistroBeanRemote {
	@PersistenceContext  
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public RegistroBean() {
        // TODO Auto-generated constructor stub
    }
    
	public Registro crear(Registro reg) throws ServiciosException {
		try{
			em.persist(reg);
			em.flush();

		}catch(PersistenceException e){ throw new
			ServiciosException("No se pudo crear la Estación"); 
		}
		return reg;
	}

}
