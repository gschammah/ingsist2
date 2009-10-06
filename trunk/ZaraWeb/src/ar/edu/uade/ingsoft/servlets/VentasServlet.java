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

import server.VO.articulos.ArticuloVO;
import server.VO.ventas.ItemVentaVO;
import ar.edu.uade.ingsoft.model.ZaraModel;

 public class VentasServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;
	private ZaraModel modelo; 

	public VentasServlet() {
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	  String pagina = "/ventas.jsp";
	       
      getServletConfig().getServletContext().getRequestDispatcher(pagina).forward(request, response);

	}  	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {				
		
		HttpSession ses = req.getSession(true);
		Collection<ItemVentaVO> articulos = (Collection<ItemVentaVO>) ses.getAttribute("articulos");
		
		if (articulos == null) {
			articulos = new ArrayList<ItemVentaVO>();
		}
		
		if (req.getParameter("agregar") != null) {
			
			long referencia = new Long(req.getParameter("referencia"));
			ArticuloVO art = modelo.getFachada().buscarArticuloVO(referencia);
			
			if (art != null) {
				ItemVentaVO item = new ItemVentaVO();
				item.setArticulo(art);
				item.setCantidad(1);
				item.setPrecio(art.getPrecioLista());
				articulos.add(item);
				req.setAttribute("currentArt", item);
			} else {
				req.setAttribute("error", "El artículo ingresado no existe");
			}
			
			ses.setAttribute("articulos", articulos);
			req.setAttribute("articulos", articulos);
			
		}
		doGet(req,res);
	}   	  	    
}