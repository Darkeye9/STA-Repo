package viewmodel;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import controller.BDEJB;
import model.Producto;

@ManagedBean
@RequestScoped
public class ProductoMBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Producto producto = new Producto();
	private List<Producto> productos;
	
	@EJB
	private BDEJB bdEJB;

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
	 * @return the productos
	 */
	public List<Producto> getProductos() {
		productos = bdEJB.getProductos();
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	

}
