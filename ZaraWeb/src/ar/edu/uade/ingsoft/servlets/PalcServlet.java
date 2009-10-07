package ar.edu.uade.ingsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.NamingException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import server.VO.PALC.ItemPALCVO;
import server.VO.PALC.PalcPropuestoVO;
import server.VO.articulos.ArticuloVO;
import server.VO.ventas.ItemVentaVO;

import ar.edu.uade.ingsoft.model.ZaraModel;

 public class PalcServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 1L;

	private ZaraModel modelo;
	
	public PalcServlet() {
		super();
	}   	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try {
			modelo = new ZaraModel();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession ses = req.getSession(true);
		Collection<PalcPropuestoVO> palc = (Collection<PalcPropuestoVO>) ses.getAttribute("palc");
		palc = modelo.getFachada().getPALC();					
		
		ses.setAttribute("palc", palc);
		req.setAttribute("palc", palc);				
		
		
	  muestraPagina(req, resp);

	}  	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		if (req.getParameter("agregar") != null) {
			
			HttpSession ses = req.getSession(true);
			Collection<PalcPropuestoVO> palc = (Collection<PalcPropuestoVO>) ses.getAttribute("palc");
			
			boolean existe = false;
			
			
			long referencia;
			try {
				referencia = new Long(req.getParameter("referencia"));
			
			
			PalcPropuestoVO nuevo = modelo.getFachada().getPALC(referencia);
			
			if (nuevo != null) {															
				
				for (PalcPropuestoVO item : palc) {
					if (item.getArticulo().getReferencia() == nuevo.getArticulo().getReferencia()) {
						existe = true;
					}											
				}
				
				if (!existe) {
					palc.add(nuevo);
				}else{
					req.setAttribute("error", "El articulo ya figura en la lista");
				}
				
				
												
			} 
			  else if (nuevo == null)	
			{
				req.setAttribute("error", "El artículo ingresado no existe");
			}
			
			} catch (NumberFormatException e) {
				req.setAttribute("error", "Referencia no valida");
				e.printStackTrace();
			}
			
			
			ses.setAttribute("palc", palc);
			req.setAttribute("palc", palc);
			
			muestraPagina(req, resp);
		}		
		
	}   	  	    
	
	private void muestraPagina(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String pagina = "/palc.jsp";
		getServletConfig().getServletContext().getRequestDispatcher(pagina).forward(req, res);
	}
}