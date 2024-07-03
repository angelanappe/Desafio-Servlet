package CalculadoraServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculadoraServlet")
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalculadoraServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numero1 = request.getParameter("numero1");
		String numero2 = request.getParameter("numero2");
		String operacion = request.getParameter("operacion");
		String resultado = "";
		
		try {
			int n1 = Integer.parseInt(numero1);
			int n2 = Integer.parseInt(numero2);
			
			switch(operacion) {
				case "sumar":
					resultado = String.valueOf(n1 + n2);
					break;
					
				case "restar":
					resultado = String.valueOf(n1 - n2);
					break;
					
				case "multiplicar":
					resultado = String.valueOf(n1 * n2);
					break;
					
				case "dividir":
					if (n2 != 0) {
						resultado = String.valueOf(n1 / n2);
					} else {
						resultado = "Error: no se puede dividir por cero.";
					}
					break;
					
				case "ordenar":
					if (n1 > n2) {
						resultado = n2 + ", " + n1;
					} else {
						resultado = n1 + ", " + n2;
					}
					break;
					
				case "parImpar":
					resultado = "El número " + n1 + " es " + (n1 % 2 == 0 ? "par" : "impar") + ". El número " + n2 + " es " + (n2 % 2 == 0 ? "par" : "impar") + ".";
					break;
					
				default:
					resultado = "Elija una opción válida.";
					break;
			}
			
		} catch (NumberFormatException e) {
			response.sendRedirect("error.jsp");
			return;
		}
		
		request.setAttribute("resultado", resultado);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
