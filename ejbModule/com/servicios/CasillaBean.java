package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entities.Casilla;
import com.entities.Estacion;


/**
 * Session Bean implementation class CasillasBean
 */
@Stateless
public class CasillaBean implements CasillaBeanRemote {
	
	@PersistenceContext  
	private EntityManager em;
	
	@Override
	public List<Casilla> obtenerTodos() {
		TypedQuery<Casilla> query = em.createQuery("SELECT c FROM Casilla c",Casilla.class); 
		return query.getResultList();
	}
	
	@Override
	public Casilla buscar(String nombre) {

		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT c FROM Casilla c WHERE c.nombre= :nombre",Casilla.class)		
			.setParameter("nombre", nombre) 
			.setMaxResults(1).getResultList();

			return (Casilla) result.get(0);
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("¨No se encontró la casilla");
			return null;
		}

	}

    /**
     * Default constructor. 
     */
    public CasillaBean() {
        // TODO Auto-generated constructor stub
    }

}
