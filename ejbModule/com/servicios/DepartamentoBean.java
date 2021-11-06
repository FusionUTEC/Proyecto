package com.servicios;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.entities.Departamento;
import com.entities.Estacion;

/**
 * Session Bean implementation class DepartamentoBean
 */
@Stateful
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



}
