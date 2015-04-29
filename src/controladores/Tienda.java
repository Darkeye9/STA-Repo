package controladores;

import java.io.File;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import modelos.Producto;
import modelos.Productos;

@Stateless
@LocalBean
public class Tienda {

	public String addProducto(Producto prod) {
		
		JAXBContext jCtx;

		Productos prods = new Productos();
		
		try {
			jCtx = JAXBContext.newInstance(Productos.class);
			Unmarshaller umrs = jCtx.createUnmarshaller();
			prods = (Productos) umrs.unmarshal(new File("BD.xml"));
			
			prods.getProductos().add(prod);
			
			Marshaller mrs = jCtx.createMarshaller();
			mrs.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			mrs.marshal(prods, new File("BD.xml"));
			
			return "Articulo "+prod.getNombre()+" dado de Alta en "+prod.getTipo()+" con un precio de "+prod.getPrecio();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
	}
	
	public Productos getProductos() {
		Productos prods = new Productos();
		JAXBContext jCtx;
		try {
			jCtx = JAXBContext.newInstance(Productos.class);
			Unmarshaller umrs = jCtx.createUnmarshaller();
			prods = (Productos) umrs.unmarshal(new File("BD.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Productos();
		}
		
		return prods;
	}
}
