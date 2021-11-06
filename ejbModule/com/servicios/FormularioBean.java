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
 * Session Bean implementation class FormularioBean
 */
@Stateless
public class FormularioBean implements FormularioBeanRemote {

	@PersistenceContext  
	private EntityManager em;
	/**
	 * Default constructor. 
	 */

	/**
	 * Default constructor. 
	 */
	public FormularioBean() {
		// TODO Auto-generated constructor stub
	}

	public Formulario crear(Formulario form) throws ServiciosException {
		try{
			em.persist(form);
			em.flush();

		}catch(PersistenceException e){ throw new
			ServiciosException("No se pudo crear la Estación"); 
		}
		return form;
	}		
	@Override
	public Formulario buscarForm(String nombre) {

		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT f FROM Formulario f WHERE f.nombre= :nombre",Formulario.class)		
			.setParameter("nombre", nombre) 
			.setMaxResults(1).getResultList();

			return (Formulario) result.get(0);

		} catch (IndexOutOfBoundsException e) {
			System.out.println("¨No se encontró la Estación");
			return null;
		}

	}
	@Override
	public void borrar(Long id) throws ServiciosException {
		try{
			Formulario form = em.find(Formulario.class, id);
			em.remove(form);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar el Formulario");
		}
	}

	@Override
	public void actualizar(Formulario form) throws ServiciosException {
		try{
			em.merge(form);
			em.flush();
		}catch(PersistenceException e){
			e.getMessage();
		}


	}
	@Override
	public List<Formulario> obtenerTodos() {
		TypedQuery<Formulario> query = em.createQuery("SELECT u FROM Formulario u",Formulario.class); 
		return query.getResultList();
	}

	public List<Casilla> buscarContiene (Long id){


		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT c,p FROM CONTIENE c WHERE c.id= :p.id",Formulario.class)		
			.setParameter("id", id) 
			.setMaxResults(1).getResultList();

			return result;

		} catch (IndexOutOfBoundsException e) {
			System.out.println("¨No se encontró la Estación");
			return null;
		}




	}


}



