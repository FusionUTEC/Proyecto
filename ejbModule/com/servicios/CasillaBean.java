package com.servicios;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Casilla;
import com.entities.Estacion;
import com.entities.Formulario;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class CasillaBean
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
			System.out.println("�No se encontr� la casilla");
			return null;
		}

	}

	public CasillaBean() {
	    }

	@Override
	public void actualizar(Casilla casilla) {
		try{
			em.merge(casilla);
			em.flush();
		}catch(PersistenceException e){
			e.getMessage();
		}
		
	}

	@Override
	public Casilla crear(Casilla casilla) throws ServiciosException {
		try{
			em.persist(casilla);
			em.flush();

		}catch(PersistenceException e) {
		e.getMessage();
		}
		return casilla;
	}
	
	@Override
	public Formulario buscarCas() {

		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT DISTINCT c.id_casilla,f.casillas FROM Formulario f, Casillas c WHERE c.id_casillas= f.casillas",Formulario.class )		
			//.setParameter("id_Casilla", id) 
			.setMaxResults(1).getResultList();

			return (Formulario) result.get(0);
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("�No se encontr� la casilla");
			return null;
		}

	}

}
