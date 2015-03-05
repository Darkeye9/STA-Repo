import java.util.ArrayList;
import java.util.Iterator;

public class utils {
	
	public static final String CSS_LINK = "<link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\">";
	public static final String DOCTYPE = "<!DOCTYPE html>";

	public static String title(String title) {
		return "<title>" + title + "</title>";
	}

	public static String head(String content) {
		return "<head>" + content + "</head>";
	}

	public static String html(String content) {
		return DOCTYPE+"<html>" + content + "</html>";
	}

	public static String body(String content) {
		return "<body>" + content + "</body>";
	}

	public static String table(String content) {
		return "<table>" + content + "</table>";
	}

	public static String table_header(ArrayList<String> content) {
		StringBuilder str = new StringBuilder();

		str.append("<tr>");
		for (String header : content)
		{
			str.append("<th>" + header + "</th>");
		}
		str.append("</tr>");
		
		return str.toString();
	}
	
	public static String table_rows(ArrayList<ArrayList<String>> content) {
		StringBuilder str = new StringBuilder();
		
		for (ArrayList<String> fila : content)
		{
			str.append("<tr>");
			for (String celda : fila)
			{
				str.append("<td>" + celda + "</td>");
			}
			str.append("</tr>");
		}
		
		return str.toString();
	}
}
