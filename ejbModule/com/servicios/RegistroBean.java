package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Estacion;
import com.entities.Formulario;
import com.entities.Investigador;
import com.entities.Registro;
import com.entities.Usuario;
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
			ServiciosException("No se pudo crear el registro"); 
		}
		return reg;
	}
	
	@Override
	public Registro buscar(String idRegistro) {
		
		

		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT u FROM Registro u WHERE u.idRegistro= :idRegistro",Registro.class)		
			.setParameter("idRegistro", Long.parseLong(idRegistro) ) 
			.setMaxResults(1).getResultList();

			return (Registro) result.get(0);
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No se encontr� el registro");
			return null;
		}

	}
	
	@Override
	public List<Registro> obtenerTodos() {
		TypedQuery<Registro> query = em.createQuery("SELECT u FROM Registro u",Registro.class); 
		return (List<Registro>) query.getResultList();
	}
	
	@Override
	public void actualizar(Registro r) throws ServiciosException {
		try{
			em.merge(r);
			em.flush();
		}catch(PersistenceException e){
			e.getMessage();
		}


	}

}