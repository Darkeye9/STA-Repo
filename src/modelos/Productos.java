package modelos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Productos {
	/**
	 * @return the productos
	 */
	@XmlElement(name="producto")
	public List<Producto> getProductos() {
		if (productos == null)
			productos = new ArrayList<Producto>();
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	private List<Producto> productos;
}
