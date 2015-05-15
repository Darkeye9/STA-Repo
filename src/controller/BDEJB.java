package controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Producto;
import model.Pedido;

@Stateless
@LocalBean
public class BDEJB implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Producto> getProductos() {
		return (List<Producto>) em.createNamedQuery("Producto.findAll")
				.getResultList();
	}

	public Producto getProducto(Integer pid) {
		return em.find(Producto.class, pid);
	}

	private void addPedido(String nombre, String dni, String dir, Integer pid, Integer cantidad) {
		em.persist(new Pedido(nombre, dni, dir, em.find(Producto.class, pid), cantidad));
		
		Producto temp = em.find(Producto.class, pid);
		temp.setStock(temp.getStock()-cantidad);
		em.persist(temp);
	}

	public Boolean doCompra(String nombre, String dni, String dir, List<Producto> productos) {
		for (Producto prod : productos) {
			if ((getProducto(prod.getId())).getStock() < prod.getStock()) {
				return false;
			}
		}

		for (Producto prod : productos) {
			addPedido(nombre, dni, dir, prod.getId(), prod.getStock());
		}
		return true;

	}

}
