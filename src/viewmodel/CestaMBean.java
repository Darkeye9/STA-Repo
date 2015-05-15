package viewmodel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controller.BDEJB;
import model.Producto;

@ManagedBean
@SessionScoped
public class CestaMBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Producto> productos = new ArrayList<Producto>();
	private Float total = (float) 0;
	private String mensaje = "";
	
	@EJB
	private BDEJB bdEJB;
	
	public void addProducto(Integer pid)
	{
		Producto temp = bdEJB.getProducto(pid);
		for (Producto prod : productos)
		{
			if (prod.getId() == pid)
			{
				if (prod.getStock() < temp.getStock())
				{
					prod.setStock(prod.getStock()+1);
					total+=temp.getPrecio();
					return;
				}else
				{
					return;
				}
			}
		}
		
		if (temp.getStock() > 0) {
			temp.setStock(1);
			total+=temp.getPrecio();
			productos.add(temp);
		}

		mensaje = "";
	}

	/**
	 * @return the productos
	 */
	public List<Producto> getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	/**
	 * @return the total
	 */
	public Float getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Float total) {
		this.total = total;
	}
	
	/**
	 * @param nombre
	 * @param dni
	 * @param dir
	 * @param pid
	 * @param cantidad
	 * @see controller.BDEJB#addPedido(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	public void addPedido(String nombre, String dni, String dir) {
		if (productos.isEmpty())
		{
			mensaje="No hay productos en su cesta";
			return;
		}
		
		if(bdEJB.doCompra(nombre, dni, dir, productos)){
			mensaje="Compra tramitada correctamente. Gracias!";
		}else
		{
			mensaje="No había suficiente stock para satisfacer su demanda. Lo sentimos";
		}
		productos.clear();
		total=(float) 0;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	

}
