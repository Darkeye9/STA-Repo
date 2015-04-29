package modelos;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

@ManagedBean
@ApplicationScoped
public class ProductosMBean {
	
	private Productos productos;

	public List<Producto> getProductos() {
		return ClientBuilder
				.newClient()
				.target("http://127.0.0.1:8080/Practica-STA/rest/user/prods")
				.request(MediaType.APPLICATION_XML)
				.get(Productos.class).getProductos();
	}

	
}
