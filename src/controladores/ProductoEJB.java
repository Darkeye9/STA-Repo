package controladores;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import modelos.Producto;

@Stateless
@LocalBean
public class ProductoEJB {
	
	@PersistenceContext
	private EntityManager em;

	public void addProducto(Producto prod) {
		em.persist(prod);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> getProductos() {
		return (List<Producto>) em.createNamedQuery("Producto.findAll").getResultList();
		//A propósito de la pregunta, se podría haber creado la consulta manualmente. ¿?
	}
}
