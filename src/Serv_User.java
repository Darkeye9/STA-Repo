

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		BufferedReader in
		   = new BufferedReader(new FileReader("bd.csv"));
		
		ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();
		
		while (in.ready())
		{
			String line = in.readLine();
			ArrayList<String> data = new ArrayList<String> (Arrays.asList(line.split(",")));
			datos.add(data);
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
