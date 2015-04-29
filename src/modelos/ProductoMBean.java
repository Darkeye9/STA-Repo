package modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

@ManagedBean
@RequestScoped
public class ProductoMBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Producto prod = new Producto();
	private boolean correcto = false;

	@Override
	public String toString() {
		return getProd().getNombre() + "de la categoría "+getProd().getTipo()+"con precio"+getProd().getPrecio();
	}
	
	public void add() {
		Date fecha = new Date();
		Random rand = new Random();
		prod.setId(fecha.getTime() + Math.abs(rand.nextLong()));
		
		ClientBuilder
		.newClient()
		.target("http://127.0.0.1:8080/Practica-STA/rest/admin/add")
		.request(MediaType.APPLICATION_XML)
		.post(Entity.entity(getProd(), MediaType.APPLICATION_XML));
		
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
