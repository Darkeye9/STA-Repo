package modelos;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import controladores.ProductoEJB;

@ManagedBean
@RequestScoped
public class ProductoMBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private boolean correcto = false;

	@EJB
	private ProductoEJB productoCtrl;
	
	private Producto prod= new Producto();

	public void add() {
		
		getProductoCtrl().addProducto(prod);
		
		setCorrecto(true);
	}


	public boolean isCorrecto() {
		return correcto;
	}


	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}


	public Producto getProd() {
		return prod;
	}


	public void setProd(Producto prod) {
		this.prod = prod;
	}


	public ProductoEJB getProductoCtrl() {
		return productoCtrl;
	}


	public void setProductoCtrl(ProductoEJB productoCtrl) {
		this.productoCtrl = productoCtrl;
	}
}
