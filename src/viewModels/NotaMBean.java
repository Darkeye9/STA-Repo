package viewModels;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import controllers.BDEJB;
import models.Nota;



@ManagedBean
@RequestScoped
public class NotaMBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Nota nota = new Nota();
	private List<Nota> notas, notasUser;
	private Boolean notasUserB = false;
	private String mensaje = "";
	
	@EJB
	private BDEJB bdEJB;

	/**
	 * @return the nota
	 */
	public Nota getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(Nota nota) {
		this.nota = nota;
	}

	/**
	 * @return the notas
	 */
	public List<Nota> getNotas() {
		notas = bdEJB.getNotas();
		return notas;
	}
	
	public void notaUser(String dni) {
		notasUser = bdEJB.getNotas(dni);
		notasUserB=true;
		System.out.println(notasUser.size());
	}

	/**
	 * @param notas the notas to set
	 */
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	/**
	 * @param dni
	 * @param aid
	 * @see controllers.BDEJB#addNota(java.lang.String, java.lang.Integer)
	 */
	public void addNota(String dni, Integer aid, Double _nota) {
		 bdEJB.addNota(dni, aid, _nota);
	}

	/**
	 * @param nid
	 * @see controllers.BDEJB#delNota(java.lang.Integer)
	 */
	public void delNota(Integer nid) {
		bdEJB.delNota(nid);
	}

	/**
	 * @return the notasUser
	 */
	public List<Nota> getNotasUser() {
		return notasUser;
	}

	/**
	 * @return the notasUserB
	 */
	public Boolean getNotasUserB() {
		return notasUserB;
	}

	/**
	 * @param notasUserB the notasUserB to set
	 */
	public void setNotasUserB(Boolean notasUserB) {
		this.notasUserB = notasUserB;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
