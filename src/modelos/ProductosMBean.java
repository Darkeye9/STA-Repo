package modelos;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import controladores.Tienda;

@ManagedBean
@ApplicationScoped
public class ProductosMBean {
	
	@EJB
	private Tienda productos;

	public List<Producto> getProductos() {
		return productos.getProductos().getProductos();
	}

	
}
