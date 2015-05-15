package viewModels;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import controllers.BDEJB;
import models.Asignatura;

@ManagedBean
@RequestScoped
public class AsignaturaMBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Asignatura asignatura = new Asignatura();
	private List<Asignatura> asignaturas;
	
	@EJB
	private BDEJB bdEJB;

	/**
	 * @return the asignatura
	 */
	public Asignatura getAsignatura() {
		return asignatura;
	}

	/**
	 * @param asignatura the asignatura to set
	 */
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	/**
	 * @return the asignaturas
	 */
	public List<Asignatura> getAsignaturas() {
		asignaturas= bdEJB.getAsignaturas();
		return asignaturas;
	}

	/**
	 * @param asignaturas the asignaturas to set
	 */
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	/**
	 * @param asignatura
	 * @see controllers.BDEJB#addAsignatura(models.Asignatura)
	 */
	public void addAsignatura() {
		bdEJB.addAsignatura(asignatura);
	}

	/**
	 * @param aid
	 * @see controllers.BDEJB#delAsignatura(java.lang.Integer)
	 */
	public void delAsignatura(Integer aid) {
		bdEJB.delAsignatura(aid);
	}
	
	
	

}
