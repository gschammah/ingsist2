package ar.edu.uade.ingsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class VentasServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;

	public VentasServlet() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  String pagina = "/ventas.jsp";
	       
      getServletConfig().getServletContext().getRequestDispatcher(pagina).forward(request, response);

	}  	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}   	  	    
}