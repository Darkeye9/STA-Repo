package modelos;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pedido
 *
 */
@Entity
@Table(name="Pedido")
@NamedQueries({
	@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
})
public class Pedido implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	@Column(name="state")
	private String state;
	
	@ManyToOne
	@JoinColumn(name="Producto")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name="Cliente")
	private Cliente cliente;
	private static final long serialVersionUID = 1L;
	
	public Pedido()
	{
		
	}

	public Pedido(Producto prod, Cliente cliente, String state) {
		this.cliente = cliente;
		this.producto = prod;
		this.state = state;
	}

	public long getId() {
		return this.Id;
	}

	public void setId(long Id) {
		this.Id = Id;
	}   
	
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pedido correcto de "+this.producto.getNombre()+" por parte de "+this.cliente.getNombre();
	}   
   
	
}
