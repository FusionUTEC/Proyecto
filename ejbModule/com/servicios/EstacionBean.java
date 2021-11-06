package com.servicios;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Administrador;
import com.entities.Departamento;
import com.entities.Estacion;
import com.entities.Usuario;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class EstacionBean
 */
@Stateless
public class EstacionBean implements EstacionBeanRemote {


	@PersistenceContext  
	private EntityManager em;
	/**
	 * Default constructor. 
	 */
	public EstacionBean() {
		// TODO Auto-generated constructor stub


	}

	public Estacion crear(Estacion estacion) throws ServiciosException {
		try{
			em.persist(estacion);
			em.flush();

		}catch(PersistenceException e){ throw new
			ServiciosException("No se pudo crear la Estación"); 
		}
		return estacion;
	}

	@Override
	public Estacion buscarEst(String nombre) {

		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT e FROM Estacion e WHERE e.nombre= :nombre",Estacion.class)		
			.setParameter("nombre", nombre) 
			.setMaxResults(1).getResultList();

			return (Estacion) result.get(0);
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("¨No se encontró la Estación");
			return null;
		}

	}
	@Override
	public void actualizar(Estacion estacion) throws ServiciosException {
		try{
			em.merge(estacion);
			em.flush();
		}catch(PersistenceException e){
			e.getMessage();
		}


	}
	@Override
	public void borrar(Long id) throws ServiciosException {
		try{
			Estacion estacion = em.find(Estacion.class, id);
			em.remove(estacion);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar la Estación");
		}

	}

	@Override
	public List<Estacion> obtenerTodos() {
		TypedQuery<Estacion> query = em.createQuery("SELECT u FROM Estacion u",Estacion.class); 
		return query.getResultList();
	}


		
	}



