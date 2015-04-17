package controladores;

import java.io.File;
import java.util.Date;
import java.util.Random;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import modelos.Producto;
import modelos.Productos;

@Path("/admin")
public class Admin {

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_XML)
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
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
	}
}
