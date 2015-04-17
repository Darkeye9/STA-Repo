

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import modelos.Producto;
import modelos.Productos;

/**
 * Servlet implementation class Serv_User
 */
@WebServlet("/Serv_User")
public class Serv_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serv_User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		Productos prods = new Productos();
		
		prods = ClientBuilder.newClient().target("http://127.0.0.1:8080/Practica-STA/rest/user/prods").request(MediaType.APPLICATION_XML).get(Productos.class);		
		
		ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();
		for (Producto prod : prods.getProductos())
		{
			datos.add(new ArrayList<String>(Arrays.asList(
					prod.getNombre(),
					prod.getTipo(),
					prod.getDesc(),
					prod.getPrecio().toString(),
					prod.getId().toString()
					)));
		}
		
		response.getWriter().write(
				utils.html(
						utils.head(
								utils.title("Venta de productos | Tienda Pepe")+
								utils.CSS_LINK)
						+ utils.body("<h1>Bienvenido a la tienda Pepe</h1><hr>"+
								"<h2>Lista de Productos disponibles</h2>"+
								utils.table(
										utils.table_header(
												new ArrayList<String>(Arrays.asList("Producto","Tipo","Descripcion","Precio","Ref."))
												)+
										utils.table_rows(datos)
										))
							)
						);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write(utils.html(
				utils.head(
						utils.title("Método no autorizado")
					)+
					utils.body("<h1>Método POST no Autorizado</h1>")
				)
			);
	}

}
