package controladores;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import modelos.Productos;

@Path("/user")
public class Usuario {

	@GET
	@Path("/prods")
	@Produces(MediaType.APPLICATION_XML)
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
