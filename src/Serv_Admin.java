import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import modelos.Producto;
import modelos.Productos;

/**
 * Servlet implementation class Serv_Admin
 */
@WebServlet("/Serv_Admin")
public class Serv_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Serv_Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write(
				utils.html(utils.head(utils.title("Método no autorizado"))
						+ utils.body("<h1>Método GET no Autorizado</h1>")));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		Map<String, String[]> params = request.getParameterMap();

		Date fecha = new Date();
		Random rand = new Random();

		Producto prod = new Producto();
		prod.setId(fecha.getTime() + Math.abs(rand.nextLong()));
		prod.setNombre((String) params.get("nombre")[0]);
		prod.setTipo((String) params.get("tipo")[0]);
		prod.setDesc((String) params.get("desc")[0]);
		prod.setPrecio(Integer.parseInt(params.get("precio")[0]));

		ClientBuilder.newClient().target("http://127.0.0.1:8080/Practica-STA/rest/admin/add").request(MediaType.APPLICATION_XML).post(Entity.entity(prod, MediaType.APPLICATION_XML));
		
		
		response.getWriter()
				.write(utils.html(utils.head(utils.title("Producto Añadido"))
						+ utils.body("Artículo "
								+ (String) params.get("nombre")[0]
								+ " dado de alta en la categoría "
								+ (String) params.get("tipo")[0]
								+ " con un precio de "
								+ (String) params.get("precio")[0] + " Euros")));
	}

}
