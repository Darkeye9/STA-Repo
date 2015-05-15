package controllers;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.Alumno;
import models.Asignatura;
import models.Nota;

@Stateless
@LocalBean
public class BDEJB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	EntityManager em;
	
	public void addAlumno (Alumno alumno)
	{
		em.persist(alumno);
	}
	
	public void addAsignatura (Asignatura asignatura)
	{
		em.persist(asignatura);
	}
	
	public void addNota(String dni, Integer aid, Double _nota)
	{
		Nota nota = new Nota(em.find(Asignatura.class, aid), em.find(Alumno.class, dni), _nota);
		em.persist(nota);
	}
	
	@SuppressWarnings("unchecked")
	public List<Alumno> getAlumnos()
	{
		return (List<Alumno>) em.createNamedQuery("Alumno.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Asignatura> getAsignaturas()
	{
		return (List<Asignatura>) em.createNamedQuery("Asignatura.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Nota> getNotas()
	{
		return (List<Nota>) em.createNamedQuery("Nota.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Nota> getNotas(String dni)
	{
		return (List<Nota>) em.createNamedQuery("Nota.findByDNI").setParameter("dni", dni).getResultList();
	}
	
	public void delAlumno (String dni)
	{
		em.remove(em.find(Alumno.class, dni));
	}
	
	public void delAsignatura (Integer aid)
	{
		em.remove(em.find(Asignatura.class, aid));
	}
	
	public void delNota (Integer nid)
	{
		em.remove(em.find(Nota.class, nid));
	}

}
