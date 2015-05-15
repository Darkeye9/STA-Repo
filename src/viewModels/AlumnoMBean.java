package viewModels;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import models.Alumno;
import controllers.BDEJB;

@ManagedBean
@RequestScoped
public class AlumnoMBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Alumno alumno = new Alumno();
	private List<Alumno> alumnos;
	
	
	@EJB
	private BDEJB bdEJB;


	/**
	 * @return the alumno
	 */
	public Alumno getAlumno() {
		return alumno;
	}


	/**
	 * @param alumno the alumno to set
	 */
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}


	/**
	 * @return the alumnos
	 */
	public List<Alumno> getAlumnos() {
		alumnos = bdEJB.getAlumnos();
		System.out.println(alumnos.size());
		return alumnos;
	}


	/**
	 * @param alumnos the alumnos to set
	 */
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}


	/**
	 * @param alumno
	 * @see controllers.BDEJB#addAlumno(models.Alumno)
	 */
	public void addAlumno() {
		bdEJB.addAlumno(alumno);
	}


	/**
	 * @param dni
	 * @see controllers.BDEJB#delAlumno(java.lang.String)
	 */
	public void delAlumno(String dni) {
		bdEJB.delAlumno(dni);
	}
	
	

}
