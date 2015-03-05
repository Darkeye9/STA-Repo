
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	response.getWriter().write(utils.html(
			utils.head(
					utils.title("Método no autorizado")
				)+
				utils.body("<h1>Método GET no Autorizado</h1>")
			)
		);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> params = request.getParameterMap();
		
		Date fecha = new Date();
		Random rand = new Random();
		
		
		FileWriter writer = new FileWriter("bd.csv", true);
		writer.append((String)params.get("nombre")[0]+",");
		writer.append((String)params.get("tipo")[0]+",");
		writer.append((String)params.get("desc")[0]+",");
		writer.append((String)params.get("precio")[0]+",");
		writer.append(Long.toString(fecha.getTime()+Math.abs(rand.nextLong()))+"\n");

		writer.flush();
		writer.close();
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(
				utils.html(
						utils.head(
								utils.title("Producto Añadido"))
						+ utils.body("Artículo "+
								(String)params.get("nombre")[0] +
								" dado de alta en la categoría "+
								(String)params.get("tipo")[0]+
								" con un precio de "+
								(String)params.get("precio")[0]+" Euros"
								)
							)
						);
	}

}
