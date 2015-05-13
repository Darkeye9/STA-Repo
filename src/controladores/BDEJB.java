package controladores;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelos.Cliente;
import modelos.Pedido;
import modelos.Producto;

@Stateless
@LocalBean
public class BDEJB {
	
	@PersistenceContext
	private EntityManager em;

	public void addProducto(Producto prod) {
		em.persist(prod);
	}
	
	public void addCliente(Cliente user)
	{
		em.persist(user);
	}
	
	public Pedido addPedido(String dni, Long pid)
	{
		Producto prod = em.find(Producto.class, pid);
		Cliente cliente = em.find(Cliente.class, dni);
		Pedido pedido = new Pedido(prod, cliente,"Pendiente");
		em.persist(pedido);
		return pedido;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> getProductos() {
		return (List<Producto>) em.createNamedQuery("Producto.findAll").getResultList();
		//A propósito de la pregunta, se podría haber creado la consulta manualmente. ¿?
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes() {
		return (List<Cliente>) em.createNamedQuery("Cliente.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getPedidos() {
		return (List<Pedido>) em.createNamedQuery("Pedido.findAll").getResultList();
	}
	
	public void delProducto (Long id)
	{
		Producto prod = (Producto)em.find(Producto.class, id);
		em.remove(prod);
	}
	
	public void delCliente (String dni)
	{
		Cliente cliente = (Cliente)em.find(Cliente.class, dni);
		em.remove(cliente);
	}
	
	public void delPedido (Long id)
	{
		Pedido ped = (Pedido)em.find(Pedido.class, id);
		em.remove(ped);
	}
	
	public Boolean login (String dni, String passwd)
	{
		Cliente cliente = em.find(Cliente.class, dni);
		return (cliente != null && cliente.getPassword().equals(passwd)) ? true: false;
	}
}
