package com.servicios;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import org.jboss.resteasy.spi.metadata.SetterParameter;

import com.entities.Administrador;
import com.entities.Aficionado;
import com.entities.Investigador;
import com.entities.Usuario;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
public class UsuarioBean implements UsuarioBeanRemote {

	@PersistenceContext  
	private EntityManager em;
	/**
	 * Default constructor. 
	 */
	public UsuarioBean() {
		// TODO Auto-generated constructor stub
	}	

	@Override
	public Usuario login1(String nombreUsuario, String contraseña) {

		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario= :nombreUsuario and u.contraseña= :contraseña",Usuario.class)		
			.setParameter("nombreUsuario", nombreUsuario) 
			.setParameter("contraseña", contraseña)
			.setMaxResults(1).getResultList();

			return (Usuario) result.get(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("¨No se encontró el usuario");
			return null;
		}

	}
	
	@Override
	public Usuario buscarUser(String nombreUsuario) {

		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario= :nombreUsuario",Usuario.class)		
			.setParameter("nombreUsuario", nombreUsuario) 
			.setMaxResults(1).getResultList();

			return (Usuario) result.get(0);
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("¨No se encontró el usuario");
			return null;
		}

	}
	@Override
	public Administrador buscarAdm(String nombreUsuario) {

		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT u FROM Administrador u WHERE u.nombreUsuario= :nombreUsuario",Usuario.class)		
			.setParameter("nombreUsuario", nombreUsuario) 
			.setMaxResults(1).getResultList();

			return (Administrador) result.get(0);
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("¨No se encontró el usuario");
			return null;
		}

	}
	@Override
	public Investigador buscarInv(String nombreUsuario) {

		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario= :nombreUsuario",Usuario.class)		
			.setParameter("nombreUsuario", nombreUsuario) 
			.setMaxResults(1).getResultList();

			return (Investigador) result.get(0);
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("¨No se encontró el usuario");
			return null;
		}

	}
	
	@Override
	public Usuario buscarUser(Long id) {

		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario= :idUsuario",Usuario.class)		
			.setParameter("idUsuario", id) 
			.setMaxResults(1).getResultList();

			return (Usuario) result.get(0);
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("¨No se encontró el usuario");
			return null;
		}

	}
	
	@Override
	public Aficionado buscarAfi(String nombreUsuario) {

		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario= :nombreUsuario",Usuario.class)		
			.setParameter("nombreUsuario", nombreUsuario) 
			.setMaxResults(1).getResultList();

			return (Aficionado) result.get(0);
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("¨No se encontró el usuario");
			return null;
		}

	}
	
	@Override
	public Administrador buscarAdm(Long idusuario) {

		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT u FROM Usuario u WHERE u.idusuario= :idusuario",Administrador.class)		
			.setParameter("idusuario", idusuario) 
			.setMaxResults(1).getResultList();

			return (Administrador) result.get(0);
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("¨No se encontró el usuario");
			return null;
		}

	}
	@Override
	public Investigador buscarInv(Long idusuario) {

		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT u FROM Usuario u WHERE u.idusuario= :idusuario",Investigador.class)		
			.setParameter("idusuario", idusuario) 
			.setMaxResults(1).getResultList();

			return (Investigador) result.get(0);
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("¨No se encontró el usuario");
			return null;
		}

	}
	
	@Override
	public Aficionado buscarAfi(Long idusuario) {

		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT u FROM Aficionado u WHERE u.idusuario= :idusuario",Aficionado.class)		
			.setParameter("idusuario", idusuario) 
			.setMaxResults(1).getResultList();

			return (Aficionado) result.get(0);
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("¨No se encontró el usuario");
			return null;
		}

	}
	
	@Override
	public Usuario ConsultaTipo(  String nombreUsuario, String contraseña) {
		String tipo=null;

		TypedQuery<Usuario> query=em.createQuery("SELECT t.tipo FROM Usuario t WHERE u.nombreUsuario= :nombreUsuario and u.contraseña= :contraseña",Usuario.class)
				.setParameter(1, nombreUsuario)
				.setParameter(2, contraseña)
				.setParameter(3, tipo);
		Usuario u2= query.getResultList().get(0);
		return u2;

	}

	public void crearU(Usuario usuario) throws ServiciosException {
		try{
			em.persist(usuario);
			em.flush();
		}catch(PersistenceException e) {
			e.printStackTrace();
			System.out.println("ACA USUARIO 1");
		}
	}

	public Administrador crearAd(Administrador admin) throws ServiciosException  {

		try{
			em.persist(admin);
			em.flush();			
			return admin;
			
		}catch(PersistenceException e) {
			e.printStackTrace();
			System.out.println("ACA USUARIO 1");
			return null;
		}

	}

	
	@Override
	public void borrar(Long id) throws ServiciosException {
		try{
			Usuario usuario = em.find(Usuario.class, id);
			em.remove(usuario);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar el usuario");
		}

	}

	@Override
	public List<Usuario> obtenerTodos() {
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u",Usuario.class); 
		return query.getResultList();
	}


	@Override
	public void crearIn(Investigador investigador) throws ServiciosException {
		try{
			em.persist(investigador);
			em.flush();
		}catch(PersistenceException e){ throw new
			ServiciosException("No se pudo crear el usuario"); 
		}

	}

	@Override
	public void crearAf(Aficionado aficionado) throws ServiciosException {
		try{
			em.persist(aficionado);
			em.flush();
		}catch(PersistenceException e){ throw new
			ServiciosException("No se pudo crear el usuario"); 
		}	
	}
	
	@Override
	public void actualizar(Usuario usuario) throws ServiciosException {
		try{
			em.merge(usuario);
			em.flush();
		}catch(PersistenceException e){
			e.getMessage();
		}

	}
	@Override
	public void actualizarAd(Administrador admin) throws ServiciosException {
		try{
			em.merge(admin);
			em.flush();
		}catch(PersistenceException e){
			System.out.println(e.getMessage());
		}
		

	}
	@Override
	public void actualizarIn(Investigador investigador) throws ServiciosException {
		try{
			em.merge(investigador);
			em.flush();
		}catch(PersistenceException e){
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void actualizarAf(Aficionado aficionado) throws ServiciosException {
		try{
			em.merge(aficionado);
			em.flush();
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el usuario");
		}

	}
	@Override
	public Usuario usuarioExistente(String nombreUsuario) {
		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario= :nombreUsuario",Usuario.class)		
			.setParameter("nombreUsuario", nombreUsuario) 
			.setMaxResults(1).getResultList();

			return (Usuario) result.get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}

	}
	@Override
	public Usuario correoExistente(String mail) {
		try {
			@SuppressWarnings("unchecked")
			List result = em.createQuery("SELECT u FROM Usuario u WHERE u.mail= :mail",Usuario.class)		
			.setParameter("mail", mail) 
			.setMaxResults(1).getResultList();

			return (Usuario) result.get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}

	}


}