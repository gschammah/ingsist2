package ar.edu.uade.ingsoft.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import server.VO.EnvT.ItemEnvTVO;
import server.VO.articulos.ArticuloVO;
import server.VO.clientes.ClienteVO;
import server.VO.ventas.ItemVentaVO;
import server.entidades.EnvT.ItemEnvT;
import ar.edu.uade.ingsoft.model.DatosT;
import ar.edu.uade.ingsoft.model.ZaraModel;

 public class AjaxServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	private ZaraModel modelo; 

	public AjaxServlet() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		try {
			modelo = new ZaraModel();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			  
	  String cuit = req.getParameter("cuit");
	  
	  if (cuit != null) {
		  ClienteVO cliente = modelo.getFachada().buscarCliente(cuit);
		  req.setAttribute("cliente", cliente);		  		  
	  }
	  
	  String pagina = "/ajax.jsp";	 
	  getServletConfig().getServletContext().getRequestDispatcher(pagina).forward(req, res);
	}  	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {		
		doGet(req, res);
	}
}