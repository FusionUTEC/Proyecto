package com.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entities.Departamento;
import com.entities.Estacion;
import com.entities.Usuario;

/**
 * Session Bean implementation class DepartamentoBean
 */
@Stateless
public class DepartamentoBean implements DepartamentoBeanRemote {
	
	@PersistenceContext 
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public DepartamentoBean() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public List<Departamento> obtenerTodos() {
		TypedQuery<Departamento> query = em.createQuery("SELECT u FROM Departamento u",Departamento.class); 
		return query.getResultList();
	}

	@Override
	public Departamento buscar(String nombre) {

		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT d FROM Departamento d WHERE d.nombre= :nombre",Departamento.class)		
			.setParameter("nombre", nombre) 
			.setMaxResults(1).getResultList();

			return (Departamento) result.get(0);
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No se encontró el departamento");
			return null;
		}

	}


}