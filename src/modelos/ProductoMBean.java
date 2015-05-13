package modelos;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import controladores.BDEJB;

@ManagedBean
@RequestScoped
public class ProductoMBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String estado = "";

	@EJB
	private BDEJB bdEJB;
	
	private Producto prod= new Producto();
	private List<Producto> prods;

	public void add() {
		
		bdEJB.addProducto(prod);
		estado = prod.toString();
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Producto getProd() {
		return prod;
	}


	public void setProd(Producto prod) {
		this.prod = prod;
	}

	public List<Producto> getProds() {
		prods = bdEJB.getProductos();
		return prods;
	}


	public void setProds(List<Producto> prods) {
		this.prods = prods;
	}	
	
	public void delProd(Long id)
	{
		bdEJB.delProducto(id);
	}
}
