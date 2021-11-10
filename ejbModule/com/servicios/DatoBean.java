package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Dato;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class DatoBean
 */
@Stateless
public class DatoBean implements DatoBeanRemote {
	
	@PersistenceContext  
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public DatoBean() {
        // TODO Auto-generated constructor stub
    }
    
    public Dato crear(Dato reg) throws ServiciosException {
		try{
			em.persist(reg);
			em.flush();

		}catch(PersistenceException e){ throw new
			ServiciosException("No se pudo crear el Dato"); 
		}
		return reg;
	}
	
	public Dato buscar(String id_Dato) {

		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT u FROM Dato u WHERE u.id_Dato= :id_Dato",Dato.class)		
			.setParameter("id_Dato", id_Dato) 
			.setMaxResults(1).getResultList();

			return (Dato) result.get(0);
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No se encontró el Dato");
			return null;
		}

	}
	
	public List<Dato> obtenerTodos() {
		TypedQuery<Dato> query = em.createQuery("SELECT u FROM Dato u",Dato.class); 
		return (List<Dato>) query.getResultList();
	}

}
