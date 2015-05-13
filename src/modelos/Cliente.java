package modelos;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
@Entity
@Table(name="cliente")
@NamedQueries({
	@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
})

public class Cliente implements Serializable {

	@Id
	@Column(name="dni")
	private String dni;
	@Column(name="nombre", nullable=false)
	private String nombre;
	@Column(name="password", nullable=false)
	private String password;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
	private List<Pedido> pedidos;

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Cliente "+this.nombre+" dado de alta con DNI "+this.dni+" y password "+this.password;
	}
   
}
