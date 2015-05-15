package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Nota database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Nota.findAll", query="SELECT n FROM Nota n"),
	@NamedQuery(name="Nota.findByDNI", query="SELECT n FROM Nota n WHERE n.alumnoBean.dni =:dni")
})

public class Nota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idNota;

	private double nota;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="alumno")
	private Alumno alumnoBean;

	//bi-directional many-to-one association to Asignatura
	@ManyToOne
	@JoinColumn(name="asignatura")
	private Asignatura asignaturaBean;

	public Nota() {
	}
	
	public Nota(Asignatura asignatura, Alumno alumno, Double _nota)
	{
		this.asignaturaBean=asignatura;
		this.alumnoBean=alumno;
		this.nota=_nota;
	}

	public int getIdNota() {
		return this.idNota;
	}

	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}

	public double getNota() {
		return this.nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Alumno getAlumnoBean() {
		return this.alumnoBean;
	}

	public void setAlumnoBean(Alumno alumnoBean) {
		this.alumnoBean = alumnoBean;
	}

	public Asignatura getAsignaturaBean() {
		return this.asignaturaBean;
	}

	public void setAsignaturaBean(Asignatura asignaturaBean) {
		this.asignaturaBean = asignaturaBean;
	}

}