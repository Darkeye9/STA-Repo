package modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import controladores.Tienda;

@ManagedBean
@RequestScoped
public class ProductoMBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Producto prod = new Producto();
	private boolean correcto = false;
	
	@EJB
	private Tienda tienda;

	@Override
	public String toString() {
		return getProd().getNombre() + "de la categoría "+getProd().getTipo()+"con precio"+getProd().getPrecio();
	}
	
	public void add() {
		Date fecha = new Date();
		Random rand = new Random();
		prod.setId(fecha.getTime() + Math.abs(rand.nextLong()));
		
		tienda.addProducto(prod);
		
		setCorrecto(true);
	}

	public Producto getProd() {
		return prod;
	}

	public void setProd(Producto prod) {
		this.prod = prod;
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}
}
